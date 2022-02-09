package in.suryaumapathy.ProjectManagementApi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRepoDTO {

    private Integer id;
    // private Integer projectId;
    private Integer repoId;

    private String accountName;
    private String repoName;
    private String repoUrl;

    private String status;
    private String active;

    private Integer createdBy;
    private Integer modifiedBy;
    private Integer createdAt;
    private Integer modifiedAt;

}
