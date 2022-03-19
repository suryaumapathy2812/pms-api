package in.suryaumapathy.ProjectManagementApi.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderTokenDTO {

	private Integer id;
	private Integer providerId;
	private Integer userId;
	private String token;
	private String clientId;
	private String ClientSecret;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
}
