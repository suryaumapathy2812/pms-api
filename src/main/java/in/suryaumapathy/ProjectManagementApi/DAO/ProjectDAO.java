package in.suryaumapathy.ProjectManagementApi.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.suryaumapathy.ProjectManagementApi.DTO.ProjectDTO;

@Repository
public class ProjectDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer create(ProjectDTO project) {
        System.out.println(project.toString());
        String sql = "INSERT INTO `projects`( `name`, `description`, `created_by`,`modified_by`) VALUES ( ?,?,?,? )";
        Object[] args = new Object[] {
                project.getName(),
                project.getDescription(),
                project.getCreatedBy(),
                project.getCreatedBy()
        };
        Integer response = jdbcTemplate.update(sql, args);
        return response;
    }

    public ProjectDTO getProject(Integer id) {
        String sql = "SELECT * FROM `projects` WHERE `id` = ?";
        Object[] args = new Object[] {
                id
        };
        ProjectDTO project = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            return convert(rs);
        }, args);
        return project;
    }

    public List<ProjectDTO> getAllProjects() {
        String sql = "SELECT * FROM `projects`";
        List<ProjectDTO> projects = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return convert(rs);
        });
        return projects;
    }

    public List<ProjectDTO> getAllByUserId(Integer createdBy) {
        String sql = "SELECT * FROM `projects` WHERE `created_by` = ?";
        Object[] args = new Object[] {
                createdBy
        };
        List<ProjectDTO> projects = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return convert(rs);
        }, args);
        return projects;
    }

    private ProjectDTO convert(ResultSet rs) throws SQLException {
        ProjectDTO project = new ProjectDTO();

        project.setId(rs.getInt("id"));
        project.setName(rs.getString("name"));
        project.setDescription(rs.getString("description"));
        project.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        project.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());
        project.setCreatedBy(rs.getInt("created_by"));
        project.setModifiedBy(rs.getInt("modified_by"));

        // project.setActive(rs.getString("active"));
        // project.setStatus(rs.getString("status"));
        // project.setCreatedBy(new User());
        // project.getCreatedBy().setId(rs.getInt("created_by"));
        // project.setModifiedBy(new User());
        // project.getModifiedBy().setId(rs.getInt("modified_by"));

        return project;
    }

}
