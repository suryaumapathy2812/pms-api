package in.suryaumapathy.ProjectManagementApi.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {

	private Integer id;
	private String username;
	private String repoName;
	private String repoUrl;
	private String status;
	private Boolean active;
	private User createdBy;
	private User modfiedBy;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
}
