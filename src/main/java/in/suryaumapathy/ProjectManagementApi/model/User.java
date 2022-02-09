package in.suryaumapathy.ProjectManagementApi.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String email;
    private String role;
    private String username;
    private Boolean status;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

}
