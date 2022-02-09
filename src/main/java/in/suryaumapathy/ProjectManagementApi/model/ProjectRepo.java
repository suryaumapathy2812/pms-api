package in.suryaumapathy.ProjectManagementApi.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRepo {

    private Integer id;
    private Project projectId;
    private Repository repoId;

    private User createdBy;
    private User modifiedBy;

    private Boolean active;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
