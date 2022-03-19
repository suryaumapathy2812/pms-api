package in.suryaumapathy.ProjectManagementApi.Model;

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
    
    private String status;
    private Boolean active;
    
    private User createdBy;
    private User modifiedBy;
    
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
	
}
