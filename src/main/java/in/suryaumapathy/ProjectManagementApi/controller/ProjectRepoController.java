package in.suryaumapathy.ProjectManagementApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.suryaumapathy.ProjectManagementApi.DTO.ProjectRepoDTO;
import in.suryaumapathy.ProjectManagementApi.DTO.RepositoryDTO;
import in.suryaumapathy.ProjectManagementApi.service.ProjectRepoService;

@RestController
@RequestMapping("api/v1/projects/{id}/repo")
public class ProjectRepoController {

    @Autowired
    ProjectRepoService projectRepoService;

    @GetMapping
    public List<ProjectRepoDTO> getAllProjectRepos(@PathVariable("id") Integer projectId) {
        System.out.println(projectId);
        return projectRepoService.getAllProjectRepo(projectId);
    }

    @GetMapping("{repoId}")
    public ProjectRepoDTO getProjectRepo(
            @PathVariable("id") Integer projectId,
            @PathVariable("repoId") Integer repoId) {
        System.out.println(projectId);
        System.out.println(repoId);
        return projectRepoService.getProjectRepo(projectId, repoId);
    }

    @PostMapping("{username}")
    public Integer createProjectRepo(
            @PathVariable("id") Integer id,
            @PathVariable("username") String username,
            @RequestBody RepositoryDTO repo) {
        System.out.println(id);
        System.out.println(username);
        System.out.println(repo);
        return projectRepoService.create(id, username, repo);
    }

}
