package in.suryaumapathy.ProjectManagementApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.suryaumapathy.ProjectManagementApi.DTO.GithubDTO;
import in.suryaumapathy.ProjectManagementApi.DTO.IntegrationTokenDTO;

@Service
public class GithubService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    IntegrationTokenService integrationTokenService;

    private final String base_url = "https://api.github.com/";

    private HttpHeaders getHeaders(Integer userId) {
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("accept", "application/vnd.github.v3+json");
        IntegrationTokenDTO tokenDetail = integrationTokenService.getUserToken(userId, "GITHUB");
        headers.set("Authorization", "Bearer " + tokenDetail.getToken());
        return headers;
    }

    public Object listRepo(Integer userId) {
        HttpEntity<Object> entity = new HttpEntity<Object>(getHeaders(userId));
        ResponseEntity<Object> response = restTemplate.exchange(base_url + "user/repos", HttpMethod.GET, entity,
                Object.class);
        return response.getBody();
    }

    public GithubDTO create(Integer userId, Object data) {
        HttpEntity<Object> entity = new HttpEntity<Object>(data, getHeaders(userId));
        ResponseEntity<GithubDTO> response = restTemplate.exchange(base_url + "user/repos", HttpMethod.POST, entity,
                GithubDTO.class);
        return response.getBody();
    }

}
