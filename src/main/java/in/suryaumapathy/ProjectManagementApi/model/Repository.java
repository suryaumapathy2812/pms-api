package in.suryaumapathy.ProjectManagementApi.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Repository {

    private Integer id;

    private String accountName;
    private String repoName;
    private String repoUrl;

    private String status;
    private Boolean active;

    private User createdBy;
    private User modifiedBy;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
