package org.meishi.app.commons.test;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
/**
 * 
 * @author Rui
 * 基类测试类  指定生产环境下的测试
 */
@ActiveProfiles("production")
@Configuration
public class SpringTransactionContextTest extends AbstractTransactionalJUnit4SpringContextTests{

	protected DataSource dataSource;
	
	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}

}
