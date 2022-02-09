package in.suryaumapathy.ProjectManagementApi.DTO;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String name;
    private String email;
    private String username;
    private String role;
    private Boolean status;
    private LocalDateTime created_at;
    private LocalDateTime modified_at;

}
