package in.suryaumapathy.ProjectManagementApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.suryaumapathy.ProjectManagementApi.DAO.IntegrationTokenDAO;
import in.suryaumapathy.ProjectManagementApi.DTO.IntegrationTokenDTO;

@Service
public class IntegrationTokenService {

    @Autowired
    IntegrationTokenDAO integrationTokenDao;

    @Autowired
    UserService userService;

    public List<IntegrationTokenDTO> getAllUserTokens(Integer userId) {
        return integrationTokenDao.getAllUserTokens(userId);
    }

    public IntegrationTokenDTO getUserToken(Integer userId, String provider) {
        return integrationTokenDao.getUserToken(userId, provider);
    }

    public IntegrationTokenDTO getUserToken(String username, String provider) {
        Integer userId = userService.getUserIdByUsername(username);
        return integrationTokenDao.getUserToken(userId, provider);
    }

    public Integer createUserToken(IntegrationTokenDTO token) {
        return integrationTokenDao.createUserToken(token);
    }

    public Integer createUserClient(IntegrationTokenDTO client) {
        return integrationTokenDao.createUserClient(client);
    }
}
