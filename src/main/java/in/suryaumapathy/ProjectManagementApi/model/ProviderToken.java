package in.suryaumapathy.ProjectManagementApi.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderToken {

	private Integer id;
	private Provider providerId;
	private User userId;
	private String token;
	private String clientId;
	private String ClientSecret;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
}
