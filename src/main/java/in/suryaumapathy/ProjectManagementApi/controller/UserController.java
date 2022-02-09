package in.suryaumapathy.ProjectManagementApi.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.suryaumapathy.ProjectManagementApi.DTO.IntegrationTokenDTO;
import in.suryaumapathy.ProjectManagementApi.DTO.UserDTO;
import in.suryaumapathy.ProjectManagementApi.model.User;
import in.suryaumapathy.ProjectManagementApi.service.IntegrationTokenService;
import in.suryaumapathy.ProjectManagementApi.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    IntegrationTokenService integrationTokenService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @PostMapping
    public Integer createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }

    @GetMapping("{username}/check")
    public HashMap userExist(@PathVariable("username") String username) {
        System.out.println(username);
        return userService.userExist(username);
    }

    @GetMapping("{id}/token")
    public List<IntegrationTokenDTO> getUserToken(@PathVariable("id") Integer userId) {
        return integrationTokenService.getAllUserTokens(userId);
    }

    @PostMapping("{id}/token")
    public Integer createUserToken(@PathVariable("id") Integer userId, @RequestBody IntegrationTokenDTO token) {
        System.out.println(userId);
        System.out.println(token);
        token.setUserId(userId);
        token.setCreatedBy(userId);
        return integrationTokenService.createUserToken(token);
    }

    @GetMapping("{id}/token/provider/{provider}")
    public IntegrationTokenDTO getUserToken(@PathVariable("id") Integer userId, @PathVariable String provider) {
        return integrationTokenService.getUserToken(userId, provider);
    }

    @GetMapping("{id}/client")
    public List<IntegrationTokenDTO> getUserClient(@PathVariable("id") Integer userId) {
        return integrationTokenService.getAllUserTokens(userId);
    }

    @PostMapping("{id}/client")
    public Integer createUserClient(@PathVariable("id") Integer userId, @RequestBody IntegrationTokenDTO client) {
        client.setUserId(userId);
        client.setCreatedBy(userId);
        return integrationTokenService.createUserClient(client);
    }

    @GetMapping("{id}/client/provider/{provider}")
    public IntegrationTokenDTO getUserClient(@PathVariable("id") Integer userId, @PathVariable String provider) {
        return integrationTokenService.getUserToken(userId, provider);
    }

}
