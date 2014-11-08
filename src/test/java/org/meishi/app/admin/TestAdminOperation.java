package org.meishi.app.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.meishi.app.commons.security.UsernamePasswordToken;
import org.meishi.app.commons.test.SpringTransactionContextTest;
import org.meishi.app.modules.admin.model.CompanyBackUser;
import org.meishi.app.modules.admin.service.ICompanyBackUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(locations = {"classpath*:root-context.xml",
		"classpath:spring-shiro.xml"})
public class TestAdminOperation extends SpringTransactionContextTest{
	
	@Autowired
	private ICompanyBackUserService companyBackUserService;
	
	@Test
	@Rollback(false)
	public void createCompanyBackUser(){
		CompanyBackUser cbuer = new CompanyBackUser(
				"admin",
				"123456",
				"",
				Boolean.FALSE
				);
		companyBackUserService.createUser(cbuer);
	}
	
	@Test
	public void isLogin(){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken upt = new UsernamePasswordToken("admin","123456".toCharArray(),false,"","");
		
		subject.login(upt);
		
		Assert.assertTrue(subject.isAuthenticated());
	}

}
