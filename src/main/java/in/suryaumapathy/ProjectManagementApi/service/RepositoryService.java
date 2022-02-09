package in.suryaumapathy.ProjectManagementApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.suryaumapathy.ProjectManagementApi.DAO.RepositoryDAO;
import in.suryaumapathy.ProjectManagementApi.DTO.RepositoryDTO;

@Service
public class RepositoryService {

    @Autowired
    RepositoryDAO repositoryDAO;

    public Integer create(RepositoryDTO repo) {
        return repositoryDAO.create(repo);
    }

    public List<RepositoryDTO> getAllRepos() {
        return repositoryDAO.getAllRepos();
    }

    public RepositoryDTO getRepo(Integer id) {
        return repositoryDAO.getRepo(id);
    }

}
