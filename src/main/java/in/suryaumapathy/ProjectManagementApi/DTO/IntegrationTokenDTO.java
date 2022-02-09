package in.suryaumapathy.ProjectManagementApi.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntegrationTokenDTO {

    private Integer id;
    private Integer userId;

    private String provider;
    private String token;
    private String clientId;
    private String clientSecret;

    private Boolean active;
    private String status;

    private Integer createdBy;
    private Integer modifiedBy;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
