package in.suryaumapathy.ProjectManagementApi.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.suryaumapathy.ProjectManagementApi.DTO.ProjectRepoDTO;

@Repository
public class ProjectRepoDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String selectQuery = "SELECT pr.id, pr.project_id, pr.repo_id, r.account_name, r.repo_name, r.repo_url, r.created_by, r.modified_by, r.status, r.created_at, r.active FROM `project_repos` AS pr ,`repositories` AS r WHERE pr.repo_id = r.id ";

    public List<ProjectRepoDTO> getAllProjectRepos() {
        String sql = selectQuery;
        List<ProjectRepoDTO> projectRepos = jdbcTemplate.query(sql, (rs, rows) -> {
            return convert(rs);
        });
        return projectRepos;
    }

    public List<ProjectRepoDTO> getAllProjectRepo(Integer projectId) {
        String sql = selectQuery + "AND pr.project_id=?";
        Object[] args = new Object[] { projectId };
        List<ProjectRepoDTO> projectRepos = jdbcTemplate.query(sql, (rs, rows) -> {
            return convert(rs);
        }, args);
        return projectRepos;
    }

    public ProjectRepoDTO getProjectRepo(Integer projectId, Integer repoId) {
        String sql = selectQuery + "AND pr.project_id=? AND r.id=?";
        Object[] args = new Object[] { projectId, repoId };
        ProjectRepoDTO projectRepos = jdbcTemplate.queryForObject(sql, (rs, rows) -> {
            return convert(rs);
        }, args);
        return projectRepos;
    }

    public Integer create(ProjectRepoDTO projectRepo) {
        String sql = "INSERT INTO `project_repos`( `project_id`, `repo_id`, `created_by`,`modified_by`) VALUES (?,?,?,?) ";
        Object[] args = new Object[] {
                projectRepo.getId(),
                projectRepo.getRepoId(),
                projectRepo.getCreatedBy(),
                projectRepo.getCreatedBy()
        };
        Integer response = jdbcTemplate.update(sql, args);
        return response;
    }

    private ProjectRepoDTO convert(ResultSet rs) throws SQLException {
        ProjectRepoDTO projectRepo = new ProjectRepoDTO();

        projectRepo.setId(rs.getInt("id"));
        projectRepo.setRepoId(rs.getInt("repo_id"));

        projectRepo.setAccountName(rs.getString("account_name"));
        projectRepo.setRepoName(rs.getString("repo_name"));
        projectRepo.setRepoUrl(rs.getString("repo_url"));

        projectRepo.setStatus(rs.getString("status"));
        projectRepo.setActive(rs.getString("active"));

        projectRepo.setCreatedBy(rs.getInt("created_by"));
        projectRepo.setModifiedBy(rs.getInt("modified_by"));
        return projectRepo;
    }

}
