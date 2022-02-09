package in.suryaumapathy.ProjectManagementApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.suryaumapathy.ProjectManagementApi.DTO.ProjectDTO;
import in.suryaumapathy.ProjectManagementApi.model.Project;
import in.suryaumapathy.ProjectManagementApi.service.ProjectService;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    /**
     * Get all projects from the database
     * 
     * @return A list of Project objects.
     */
    @GetMapping
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    /**
     * Create a new project
     * 
     * @param project The project to be created.
     * @return Nothing.
     */
    @PostMapping
    public Integer create(@RequestBody ProjectDTO project) {
        System.out.println(project.toString());
        return projectService.create(project);
    }

    /**
     * Get a project by id
     * 
     * @param id The id of the project to retrieve.
     * @return The Project object.
     */
    @GetMapping("{id}")
    public ProjectDTO getProject(@PathVariable("id") Integer id) {
        return projectService.getProject(id);
    }

    /**
     * Get all projects for a given user
     * 
     * @param userId The id of the user whose projects we want to retrieve.
     * @return A list of Project objects.
     */
    @GetMapping("/user/{username}")
    public List<ProjectDTO> getAllByUserId(@PathVariable("username") String username) {
        return projectService.getAllByUsername(username);
    }

    @PostMapping("/user/{username}")
    public Integer createByUsername(@PathVariable("username") String username, @RequestBody ProjectDTO project) {
        System.out.println(username);
        System.out.println(project.toString());
        return projectService.createByUsername(username, project);
    }

}