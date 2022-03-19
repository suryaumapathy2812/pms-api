package in.suryaumapathy.ProjectManagementApi.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRepositoryDto {

	private Integer id;
	private Integer projectId;
	private Integer repoId;
	
	private Integer createdBy;
	private Integer modifiedBy;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	
}
