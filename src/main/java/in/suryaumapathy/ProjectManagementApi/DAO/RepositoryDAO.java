package in.suryaumapathy.ProjectManagementApi.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import in.suryaumapathy.ProjectManagementApi.DTO.RepositoryDTO;

@org.springframework.stereotype.Repository
public class RepositoryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer create(RepositoryDTO repo) {
        String sql = "INSERT INTO `repositories` ( `account_name`,`repo_name`, `repo_url`, `created_by`, `modified_by` ) VALUES (?, ?,?,?,? )";
        Object[] args = new Object[] {
                repo.getAccountName(),
                repo.getRepoName(),
                repo.getRepoUrl(),
                repo.getCreatedBy(),
                repo.getCreatedBy()
        };
        Integer id = jdbcTemplate.update(sql, args);
        return id;
    }

    public List<RepositoryDTO> getAllRepos() {
        String sql = "SELECT * from `repositories`";
        List<RepositoryDTO> response = jdbcTemplate.query(sql, (rs, row) -> {
            RepositoryDTO repo = convert(rs);
            return repo;
        });
        return response;
    }

    public RepositoryDTO getRepo(Integer id) {
        String sql = "SELECT * from `repositories` WHERE id = ?";
        Object[] params = new Object[] { id };
        RepositoryDTO response = jdbcTemplate.queryForObject(sql, (rs, row) -> {
            RepositoryDTO repo = convert(rs);
            return repo;
        }, params);
        return response;
    }

    private RepositoryDTO convert(ResultSet rs) throws SQLException {
        RepositoryDTO repo = new RepositoryDTO();

        repo.setId(rs.getInt("id"));
        repo.setAccountName(rs.getString("account_name"));
        repo.setRepoName(rs.getString("repo_name"));
        repo.setRepoUrl(rs.getString("repo_url"));
        repo.setStatus(rs.getString("status"));
        repo.setActive(rs.getBoolean("active"));
        repo.setCreatedBy(rs.getInt("created_by"));
        repo.setModifiedBy(rs.getInt("modified_by"));
        // repo.setCreatedDate(rs.getTimestamp("created_at").toLocalDateTime());
        // repo.setModifiedDate(rs.getTimestamp("modified_at").toLocalDateTime());

        return repo;
    }

    public Boolean updateRepoStatus(Integer id, String status, String repoUrl) {
        String sql = "UPDATE `repositories` SET `status` = ?, `repo_url`= ? where `id` = ? ";
        Object[] params = { status, repoUrl, id };
        Integer rows = jdbcTemplate.update(sql, params);
        return (rows == 1);

    }

}
