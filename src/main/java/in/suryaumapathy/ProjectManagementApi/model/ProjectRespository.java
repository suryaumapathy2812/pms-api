package in.suryaumapathy.ProjectManagementApi.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRespository {

	private Integer id;
	private Project projectId;
	private Repository repoId;
	
	private User createdBy;
	private User modifiedBy;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	
}
