package org.meishi.app.user;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.meishi.app.modules.user.dao.IUserDao;
import org.meishi.app.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:root-context-test.xml"})
@ActiveProfiles("development")
public class JpaCacheTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Autowired
	private EntityManager em;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void AssertNotNull(){
		Assert.notNull(em);
		Assert.notNull(userDao);
		Assert.notNull(applicationContext);
	}
	
	@Test
	public void testJpaOneCache(){
		
//		User user = em.find(User.class, 1l);
		User user = userDao.findOne(1l);
//		JpaTransactionManager jtm = (JpaTransactionManager) applicationContext.getBean("transactionManager");
//		Assert.notNull(jtm);
//		TransactionStatus ts = jtm.getTransaction(new DefaultTransactionDefinition());
//		Assert.isTrue(ts.isNewTransaction());
		
//		em.clear();
//		User user1 = em.find(User.class, 1l);
//		User user1 = userDao.findOne(1l);
		
		Assert.notNull(user);
	}
	//配置了2级缓存后，第二次查找不会发出sql语句请求  用@After是为了说明在两次事务中比较
	@After
	public void testJpaSecondCache(){
		User user = userDao.findOne(1l);
		Assert.notNull(user);
	}
}
