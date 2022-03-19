package in.suryaumapathy.ProjectManagementApi.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoyDto {

	private Integer id;
	private String username;
	private String repoName;
	private String repoUrl;
	private String status;
	private Boolean active;
	private Integer createdBy;
	private Integer modfiedBy;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
}
