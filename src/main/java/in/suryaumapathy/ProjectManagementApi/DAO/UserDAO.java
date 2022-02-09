package in.suryaumapathy.ProjectManagementApi.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.suryaumapathy.ProjectManagementApi.DTO.UserDTO;
import in.suryaumapathy.ProjectManagementApi.model.User;

@Repository
public class UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int create(UserDTO user) {
        String sql = "INSERT INTO `users` (`name`,`email`,`role`,`username`) VALUES (?,?,?,?)";
        Object[] args = { user.getName(), user.getEmail() };
        int rows = jdbcTemplate.update(sql, args);
        return rows;
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, (rs, row) -> {
            User userObj = convert(rs);
            return userObj;
        });
        return users;
    }

    public User getUser(Integer id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        Object[] params = new Object[] { id };
        User users = jdbcTemplate.queryForObject(sql, (rs, row) -> {
            User userObj = convert(rs);
            return userObj;
        }, params);
        return users;
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        Object[] params = new Object[] { username };
        User users = jdbcTemplate.queryForObject(sql, (rs, row) -> {
            User userObj = convert(rs);
            return userObj;
        }, params);
        return users;
    }

    private User convert(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setRole(rs.getString("role"));
        user.setStatus(rs.getBoolean("status"));
        user.setCreatedDate(rs.getTimestamp("created_at").toLocalDateTime());
        user.setModifiedDate(rs.getTimestamp("modified_at").toLocalDateTime());
        return user;
    }

    public HashMap userExist(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        Object[] params = new Object[] { username };
        List<User> users = jdbcTemplate.query(sql, (rs, row) -> {
            User userObj = convert(rs);
            return userObj;
        }, params);
        Integer len = users.size();

        HashMap response = new HashMap<>();

        if (len.equals(0)) {
            response.put("exist", false);
            return response;
        }
        response.put("exist", true);
        response.put("username", users.get(0).getUsername());
        response.put("email", users.get(0).getEmail());
        response.put("role", users.get(0).getRole());
        return response;
    }

}
