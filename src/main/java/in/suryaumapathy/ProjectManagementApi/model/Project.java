package in.suryaumapathy.ProjectManagementApi.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private Integer id;
    private String name;
    private String description;

    private String active;
    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private User createdBy;
    private User modifiedBy;

}
