package in.suryaumapathy.ProjectManagementApi.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.suryaumapathy.ProjectManagementApi.DAO.UserDAO;
import in.suryaumapathy.ProjectManagementApi.DTO.UserDTO;
import in.suryaumapathy.ProjectManagementApi.model.User;

@Service
public class UserService {

    @Autowired
    UserDAO userDao;

    public Integer createUser(UserDTO user) {
        return userDao.create(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUser(Integer id) {
        return userDao.getUser(id);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    public Integer getUserIdByUsername(String username) {
        return userDao.getUserByUsername(username).getId();
    }

    public HashMap userExist(String username) {
        return userDao.userExist(username);
    }

}
