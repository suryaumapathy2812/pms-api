package in.suryaumapathy.ProjectManagementApi.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Integer id;
    private String name;
    private String description;

    private Integer createdBy;
    private Integer modifiedBy;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
