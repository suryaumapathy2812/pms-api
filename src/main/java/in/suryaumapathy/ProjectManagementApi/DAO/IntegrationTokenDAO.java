package in.suryaumapathy.ProjectManagementApi.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.suryaumapathy.ProjectManagementApi.DTO.IntegrationTokenDTO;

@Repository
public class IntegrationTokenDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String getQuery = "SELECT * FROM `integration_tokens` ";

    public List<IntegrationTokenDTO> getAllUserTokens(Integer userId) {
        String sql = getQuery + "WHERE user_id=?";
        Object[] args = new Object[] { userId };
        List<IntegrationTokenDTO> response = jdbcTemplate.query(sql, (rs, rows) -> {
            return convert(rs);
        }, args);
        return response;
    }

    public IntegrationTokenDTO getUserToken(Integer userId, String provider) {
        String sql = getQuery + "WHERE user_id=? AND provider=?";
        Object[] args = new Object[] { userId, provider };
        IntegrationTokenDTO response = jdbcTemplate.queryForObject(sql, (rs, rows) -> {
            return convert(rs);
        }, args);
        return response;
    }

    public Integer createUserToken(IntegrationTokenDTO token) {
        String sql = "INSERT INTO `integration_tokens`( `user_id`, `provider`, `token`, `created_by`,`modified_by`) VALUES ( ?,?,?,?,? )";
        Object[] args = new Object[] {
                token.getUserId(),
                token.getProvider(),
                token.getToken(),
                token.getCreatedBy(),
                token.getCreatedBy()
        };
        Integer response = jdbcTemplate.update(sql, args);
        return response;
    }

    public Integer createUserClient(IntegrationTokenDTO token) {
        String sql = "INSERT INTO `integration_tokens`( `user_id`, `provider`, `client_id`, `client_secret`,`created_by`,`modified_by`) VALUES (?,?,?,?,?,? )";
        Object[] args = new Object[] {
                token.getUserId(),
                token.getProvider(),
                token.getClientId(),
                token.getClientSecret(),
                token.getCreatedBy(),
                token.getCreatedBy()
        };
        Integer response = jdbcTemplate.update(sql, args);
        return response;
    }

    public Integer updateUserToken(IntegrationTokenDTO token) {
        String sql = "UPDATE `integration_tokens` SET `token`=?,`modified_by`=? WHERE `user_id`=? AND `provider`=?";
        Object[] args = new Object[] {
                token.getToken(),
                token.getModifiedBy(),
                token.getUserId(),
                token.getProvider()
        };
        Integer response = jdbcTemplate.update(sql, args);
        return response;
    }

    public Integer updateUserClientToken(IntegrationTokenDTO token) {
        String sql = "UPDATE `integration_tokens` SET `client_id`=?,`client_secret`=?,`modified_by`=? WHERE `user_id`=? AND `provider`=?";
        Object[] args = new Object[] {
                token.getClientId(),
                token.getClientSecret(),
                token.getModifiedBy(),
                token.getUserId(),
                token.getProvider()
        };
        Integer response = jdbcTemplate.update(sql, args);
        return response;
    }

    private IntegrationTokenDTO convert(ResultSet rs) throws SQLException {
        IntegrationTokenDTO tokens = new IntegrationTokenDTO();

        tokens.setId(rs.getInt("id"));
        tokens.setUserId(rs.getInt("user_id"));

        tokens.setProvider(rs.getString("provider"));
        tokens.setToken(rs.getString("token"));
        tokens.setClientId(rs.getString("client_id"));
        tokens.setClientSecret(rs.getString("client_secret"));

        tokens.setActive(rs.getBoolean("active"));
        tokens.setStatus(rs.getString("status"));

        tokens.setCreatedBy(rs.getInt("created_by"));
        tokens.setModifiedBy(rs.getInt("modified_by"));

        tokens.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        tokens.setModifiedAt(rs.getTimestamp("modified_at").toLocalDateTime());

        return tokens;
    }

}
