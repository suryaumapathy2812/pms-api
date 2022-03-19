package in.suryaumapathy.ProjectManagementApi.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDto {

	private Integer id;
	private String name;
	
	private String status;
	private Boolean active;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;	
	
}
