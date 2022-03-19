package in.suryaumapathy.ProjectManagementApi.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

	private Integer id;
	private String name;
	
	private String status;
	private Boolean active;
	
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
}
