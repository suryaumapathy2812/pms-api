package in.suryaumapathy.ProjectManagementApi.Model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String status;
    private Boolean active;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
	
}
