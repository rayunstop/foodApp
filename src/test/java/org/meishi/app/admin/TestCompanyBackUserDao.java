package org.meishi.app.admin;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.meishi.app.commons.test.SpringTransactionContextTest;
import org.meishi.app.modules.admin.dao.ICompanyBackUserDao;
import org.meishi.app.modules.admin.model.CompanyBackUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"classpath*:root-context.xml"})
public class TestCompanyBackUserDao extends SpringTransactionContextTest{

	
	@Autowired
	private ICompanyBackUserDao companyBackUserDao;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void getCBUByUsername(){
		CompanyBackUser cbu = companyBackUserDao.findByUsername("admin");
		Assert.assertNotNull(cbu);
	}
}
