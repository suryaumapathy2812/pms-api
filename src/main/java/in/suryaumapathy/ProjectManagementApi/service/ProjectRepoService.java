package in.suryaumapathy.ProjectManagementApi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.suryaumapathy.ProjectManagementApi.DAO.ProjectRepoDAO;
import in.suryaumapathy.ProjectManagementApi.DTO.GithubDTO;
import in.suryaumapathy.ProjectManagementApi.DTO.ProjectRepoDTO;
import in.suryaumapathy.ProjectManagementApi.DTO.RepositoryDTO;

@Service
public class ProjectRepoService {

    @Autowired
    ProjectRepoDAO projectRepoDAO;

    @Autowired
    UserService userService;

    @Autowired
    GithubService githubService;

    @Autowired
    RepositoryService repositoryService;

    public List<ProjectRepoDTO> getAllProjectRepos() {
        return projectRepoDAO.getAllProjectRepos();
    }

    public List<ProjectRepoDTO> getAllProjectRepo(Integer projectId) {
        return projectRepoDAO.getAllProjectRepo(projectId);
    }

    public ProjectRepoDTO getProjectRepo(Integer projectId, Integer repoId) {
        return projectRepoDAO.getProjectRepo(projectId, repoId);
    }

    public Integer create(Integer projectId, String username, RepositoryDTO repo) {
        Integer userId = userService.getUserIdByUsername(username);

        // todo:- call github create repo api
        Map<String, String> gitCreateObj = new HashMap<>();
        gitCreateObj.put("name", repo.getRepoName());
        System.out.println(" GitCreateObj --- " + gitCreateObj.toString());
        GithubDTO newGitRepo = githubService.create(userId, gitCreateObj);
        System.out.println(" newGitRepo --- " + newGitRepo.toString());
        // -- ends

        // todo - append github url to repo
        repo.setAccountName(username);
        repo.setRepoUrl(newGitRepo.getHtmlUrl());
        repo.setCreatedBy(userId);
        // -- ends

        System.out.println(" Repo --- " + repo.toString());
        Integer repoId = repositoryService.create(repo);

        ProjectRepoDTO projectRepo = new ProjectRepoDTO();
        projectRepo.setId(projectId);
        projectRepo.setRepoId(repoId);
        projectRepo.setCreatedBy(userId);
        projectRepo.setModifiedBy(userId);
        return projectRepoDAO.create(projectRepo);
    }

}
