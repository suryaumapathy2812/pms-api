package in.suryaumapathy.ProjectManagementApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.suryaumapathy.ProjectManagementApi.DTO.RepositoryDTO;
import in.suryaumapathy.ProjectManagementApi.service.ProjectRepoService;
import in.suryaumapathy.ProjectManagementApi.service.RepositoryService;

// @RestController
// @RequestMapping("api/v1/repos")
public class RepositoryController {

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    ProjectRepoService projectRepoService;

    @GetMapping
    public List<RepositoryDTO> getAllRepos() {
        return repositoryService.getAllRepos();
    }

    @GetMapping("{id}")
    public RepositoryDTO getRepo(@PathVariable("id") Integer id) {
        return repositoryService.getRepo(id);
    }

    @PostMapping
    public Integer create(@RequestBody RepositoryDTO repo) {
        System.out.println(repo.toString());
        return repositoryService.create(repo);
    }

    @PostMapping("project/{projectId}/user/{username}")
    public Integer createRepo(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("username") String username,
            @RequestBody RepositoryDTO repo) {
        System.out.println(projectId.toString());
        System.out.println(username);
        System.out.println(repo.toString());
        return projectRepoService.create(projectId, username, repo);
    }

}
