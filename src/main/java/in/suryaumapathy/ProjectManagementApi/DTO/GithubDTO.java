package in.suryaumapathy.ProjectManagementApi.DTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GithubDTO {

    private String name;
    private String fullName;

    @JsonAlias({ "private" })
    private Boolean priv;
    @JsonAlias({ "html_url" })
    private String htmlUrl;
    @JsonAlias({ "created_at" })
    private LocalDateTime createdAt;
    @JsonAlias({ "updated_at" })
    private LocalDateTime modifiedAt;

}
