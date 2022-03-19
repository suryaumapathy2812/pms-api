package in.suryaumapathy.ProjectManagementApi.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProject {

	private Integer id;
	private User userId;
	private Project projectId;
	private String userRole;
	private User createdBy;
	private User modifiedBy;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
}
