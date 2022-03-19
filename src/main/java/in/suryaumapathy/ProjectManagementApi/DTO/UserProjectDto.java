package in.suryaumapathy.ProjectManagementApi.Dto;

import java.time.LocalDateTime;


import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProjectDto {

	 public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getProjectId() {
			return projectId;
		}
		public void setProjectId(Integer projectId) {
			this.projectId = projectId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Boolean getActive() {
			return active;
		}
		public void setActive(Boolean active) {
			this.active = active;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Integer getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(Integer createdBy) {
			this.createdBy = createdBy;
		}
		public Integer getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(Integer modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public LocalDateTime getCreatedDate() {
			return createdDate;
		}
		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}
		public LocalDateTime getModifiedDate() {
			return modifiedDate;
		}
		public void setModifiedDate(LocalDateTime modifiedDate) {
			this.modifiedDate = modifiedDate;
		}
		private Integer id;
	    private Integer projectId;
	    
	    private String name;
	    private String description;
	    
	    private String status;
	    private Boolean active;
	    
	    private String role;
	    
	    private Integer createdBy;
	    private Integer modifiedBy;
	    
	    private LocalDateTime createdDate;
	    private LocalDateTime modifiedDate;
	
	
}
