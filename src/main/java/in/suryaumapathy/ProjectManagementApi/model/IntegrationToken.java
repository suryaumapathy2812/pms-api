package in.suryaumapathy.ProjectManagementApi.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntegrationToken {

    private Integer id;
    private User userId;

    private String provider;
    private String token;
    private String clientId;
    private String clientSecret;

    private Boolean active;
    private String status;

    private User createdBy;
    private User modifiedBy;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
