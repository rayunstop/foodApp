package org.meishi.app.modules.admin.service;

import org.meishi.app.modules.admin.model.CompanyBackUser;

public interface ICompanyBackUserService {

	public void createUser(CompanyBackUser cbuer);
	
	public CompanyBackUser findByName(String username);
	
	public void saveOrUpdate(CompanyBackUser cbuer);
}
