package org.meishi.app.modules.admin.service.impl;

import org.meishi.app.commons.security.PasswordHeper;
import org.meishi.app.modules.admin.dao.ICompanyBackUserDao;
import org.meishi.app.modules.admin.model.CompanyBackUser;
import org.meishi.app.modules.admin.service.ICompanyBackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class CompanyBackUserServiceImpl implements ICompanyBackUserService {

	@Autowired
	private ICompanyBackUserDao companyBackUserDao;
	
	@Autowired
	private PasswordHeper passwordHeper;
	
	@Override
	public void createUser(CompanyBackUser cbuer) {
		passwordHeper.encryptPassword(cbuer);
		companyBackUserDao.save(cbuer);
	}

	@Override
	public CompanyBackUser findByName(String username) {
		return companyBackUserDao.findByUsername(username);
	}

	@Override
	public void saveOrUpdate(CompanyBackUser cbuer) {
		companyBackUserDao.saveAndFlush(cbuer);
	}

}
