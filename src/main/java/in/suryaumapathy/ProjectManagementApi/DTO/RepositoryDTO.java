package in.suryaumapathy.ProjectManagementApi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryDTO {

    private Integer id;
    private String accountName;
    private String repoName;
    private String repoUrl;
    private String status;
    private Boolean active;
    private Integer createdBy;
    private Integer modifiedBy;

}
