package org.meishi.app.modules.admin.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.meishi.app.commons.orm.UserEntity;

@Entity
@Table(name="company_back_user")
public class CompanyBackUser extends UserEntity{

	public CompanyBackUser(String username,String password,String salt,Boolean locked){
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.locked = locked;
	}
	//default constructor
	public CompanyBackUser(){
		
	}
}
