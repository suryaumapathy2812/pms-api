package in.suryaumapathy.ProjectManagementApi.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import in.suryaumapathy.ProjectManagementApi.Dto.UserDto;
import in.suryaumapathy.ProjectManagementApi.Model.User;

public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    private String baseQuery;
    
    public UserDao() {
    	baseQuery = "SELECT `id`,`first_name`,`last_name`,`email`,`status`,`active`,`created_at`,`modified_at` FROM `users` WHERE `status` != 'ARCHIVED' AND `active` = 1";
    }
	
	public List<UserDto> findAll() {
		String sql = baseQuery;
		List<UserDto> users = jdbcTemplate.query(sql, (rs, row)-> {
			UserDto userObj = convert(rs);
            return userObj;
		});
		return users;		
	}
	
	
	public UserDto findOne(Integer userId) {
		String sql = baseQuery + " AND `id` = ? ";
		Object[] params = new Object[] { userId };
		UserDto user = jdbcTemplate.queryForObject(sql, (rs, rows)->{
			UserDto userObj = convert(rs);
            return userObj;
		},params);
		return user;
	}
	
	
	public Integer insertOne(UserDto user) {
		String sql = " INSERT INTO `users`(`fist_name`,`last_name`,`email`) VALUES (?,?,?) ";
		Object[] params = new Object[] {user.getFirstName(), user.getLastName(), user.getEmail()};
		Integer row = jdbcTemplate.update(sql, params);
		return row;
	}
	
	
	public Integer updateOne(UserDto user, Integer id) {
		String sql = "UPDATE `users` SET `first_name`= ? , `last_name` = ? , `email` = ? WHERE `id`= ?";
		Object[] params = new Object[] { user.getFirstName(), user.getLastName(), user.getEmail(), id };
		Integer row = jdbcTemplate.update(sql, params);
		return row;
	}
	
	
	public Integer deleteOne(Integer id) {
		String sql = "UPDATE `users` SET `status`= ? , `active` = ? WHERE `id`= ?";
		Object[] params = new Object[] { "ARCHIVED" , false , id };
		Integer row = jdbcTemplate.update(sql, params);
		return row;
	}
	
	
//	Private Methods
	
	private UserDto convert(ResultSet rs) throws SQLException{
		UserDto user = new UserDto();
		user.setId(rs.getInt("id"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setEmail(rs.getString("email"));
		user.setStatus(rs.getString("status"));
		user.setActive(rs.getBoolean("active"));
		user.setCreatedDate(rs.getTimestamp("created_at").toLocalDateTime());
	    user.setModifiedDate(rs.getTimestamp("modified_at").toLocalDateTime());
		return user;
	}
	
	
}
