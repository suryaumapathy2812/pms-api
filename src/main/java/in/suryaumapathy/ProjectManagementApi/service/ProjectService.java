package in.suryaumapathy.ProjectManagementApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.suryaumapathy.ProjectManagementApi.DAO.ProjectDAO;
import in.suryaumapathy.ProjectManagementApi.DTO.ProjectDTO;
import in.suryaumapathy.ProjectManagementApi.model.Project;

@Service
public class ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    @Autowired
    UserService userService;

    public Integer create(ProjectDTO project) {
        return projectDAO.create(project);
    }

    public ProjectDTO getProject(Integer id) {
        return projectDAO.getProject(id);
    }

    public List<ProjectDTO> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    public List<ProjectDTO> getAllByUserId(Integer userId) {
        return projectDAO.getAllByUserId(userId);
    }

    public List<ProjectDTO> getAllByUsername(String username) {
        Integer userId = userService.getUserIdByUsername(username);
        return projectDAO.getAllByUserId(userId);
    }

    public Integer createByUsername(String username, ProjectDTO project) {
        Integer id = userService.getUserIdByUsername(username);
        project.setCreatedBy(id);
        return projectDAO.create(project);
    }

}