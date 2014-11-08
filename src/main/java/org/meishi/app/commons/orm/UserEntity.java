package org.meishi.app.commons.orm;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.codehaus.jackson.annotate.JsonIgnore;

@MappedSuperclass
public abstract class UserEntity extends BaseEntity{

	private Date createdDate;
	private Date modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private String delFlag; // 
	private Integer successLoginCount;
	private Integer failLoginCount;
	
	
	//user properties
	protected String username;
	protected String password;
	protected String salt;
	protected Boolean locked = Boolean.FALSE;
	
	@PrePersist
	public void prePersist(){
		this.createdDate = new Date();
		this.createdBy = "system";
		this.modifiedDate = createdDate;
		this.modifiedBy = createdBy;
	}
	
	@PreUpdate
	public void preUpdate(){
		this.modifiedBy = "Test";
		this.modifiedDate = new Date();
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@JsonIgnore
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Integer getSuccessLoginCount() {
		return successLoginCount;
	}

	public void setSuccessLoginCount(Integer successLoginCount) {
		this.successLoginCount = successLoginCount;
	}

	public Integer getFailLoginCount() {
		return failLoginCount;
	}

	public void setFailLoginCount(Integer failLoginCount) {
		this.failLoginCount = failLoginCount;
	}
	
	
}
