package in.suryaumapathy.ProjectManagementApi.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import in.suryaumapathy.ProjectManagementApi.Dto.ProjectDto;

public class ProjectDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String baseQuery;
	
	public ProjectDao() {
		baseQuery = """
				SELECT 
					p.id AS `id`,
					p.name AS `name`,
					p.description AS `description`,
					p.status AS `status`,
					p.active AS `active`,
					p.created_by AS `created_by`,
					p.modified_by AS `modified_by`,
					p.created_at AS `created_at`,
					p.modified_at AS`modified_at`
				
				FROM `projects` AS p
				""";
	}
	
	public List<ProjectDto> findAll() {
		String sql = baseQuery;
		List<ProjectDto> projects = jdbcTemplate.query(sql, (rs,rows)-> {
			ProjectDto obj = convert(rs);
			return obj;
		});
		return projects;
	}
	
	public Integer insertOne(ProjectDto project, Integer userId) {
		String sql = """
				INSERT INTO `projects`
					(`name`, `description`,`created_by`,`modified_by`)
				VALUES
					(?,?,?,?);
				""";
		Object[] params = new Object[] { project.getName(), project.getDescription(), userId, userId };
		Integer row = jdbcTemplate.update(sql,params);
		return row;
	}
	
	
	public Integer updateOne(ProjectDto project, Integer userId) {
		String sql = """
				INSERT INTO `projects`
					(`name`, `description`,`modified_by`)
				VALUES
					(?,?,?,?);
				""";
		Object[] params = new Object[] { project.getName(), project.getDescription(), userId };
		Integer row = jdbcTemplate.update(sql,params);
		return row;
	}
	
	
	
	
//	Private Method
	
	private ProjectDto convert(ResultSet rs) throws SQLException {
		ProjectDto obj = new ProjectDto();
		
		obj.setId(rs.getInt("id"));
		obj.setName(rs.getString("name"));
		obj.setDescription(rs.getString("description"));
		obj.setStatus(rs.getString("status"));
		obj.setActive(rs.getBoolean("active"));
		obj.setCreatedBy(rs.getInt("created_by"));
    	obj.setModifiedBy(rs.getInt("modified_by"));
		obj.setCreatedDate(rs.getTimestamp("created_at").toLocalDateTime());
	    obj.setModifiedDate(rs.getTimestamp("modified_at").toLocalDateTime());
		
		return obj;
	}
	
	
	
}
