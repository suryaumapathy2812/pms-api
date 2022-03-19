package in.suryaumapathy.ProjectManagementApi.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import in.suryaumapathy.ProjectManagementApi.Dto.ProjectDto;
import in.suryaumapathy.ProjectManagementApi.Dto.UserProjectDto;

public class UserProjectDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String baseQuery;
	
	public UserProjectDao(){
		baseQuery = """ 
					SELECT 
					up.id AS `id`,
					p.id AS `project_id`,
					p.name AS `name`,
					p.description AS `description`,
					p.status AS `status`,
					p.active AS `active`,
					up.user_role AS `role`,
					p.created_by AS `created_by`,
					p.modified_by AS `modified_by`,
					p.created_at AS `created_at`,
					p.modified_at AS`modified_at`
					FROM `user_projects` AS up
					JOIN `projects` AS p
					ON up.project_id = p.id
					JOIN `users` AS u
					ON up.user_id = u.id
					WHERE u.id = ?
				""";
	}
	
    public List<UserProjectDto> findAll( Integer userId ){
    	String sql = baseQuery;
    	Object[] params = new Object[] { userId };
    	List<UserProjectDto> projects = jdbcTemplate.query(sql, (rs, rows)-> {
    		UserProjectDto projectObj =  convert(rs);
    		return projectObj;
    	}, params);
    	return projects;
    }
    
    
    public UserProjectDto find( Integer userId, Integer projectId ){
    	String sql = baseQuery + " AND up.id = ?";
    	Object[] params = new Object[] {userId, projectId};
    	UserProjectDto projects = jdbcTemplate.queryForObject(sql, (rs, rows)-> {
    		UserProjectDto projectObj = convert(rs);
    		return projectObj;
    	}, params);
    	return projects;
    }
 
    
    
// Private Methods
    
    private UserProjectDto convert(ResultSet rs) throws SQLException  {
    	UserProjectDto obj = new UserProjectDto();
    	
    	obj.setId(rs.getInt("id"));
    	obj.setProjectId(rs.getInt("project_id"));
    	obj.setName(rs.getString("name"));
    	obj.setDescription(rs.getString("description"));
    	obj.setStatus(rs.getString("status"));
    	obj.setActive(rs.getBoolean("active"));
    	obj.setRole(rs.getString("role"));
    	obj.setCreatedBy(rs.getInt("created_by"));
    	obj.setModifiedBy(rs.getInt("modified_by"));
		obj.setCreatedDate(rs.getTimestamp("created_at").toLocalDateTime());
	    obj.setModifiedDate(rs.getTimestamp("modified_at").toLocalDateTime());
    	
		return obj;
    }
    
    
    
    
    
}
