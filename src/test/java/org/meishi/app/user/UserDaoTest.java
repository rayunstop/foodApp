package org.meishi.app.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.meishi.app.commons.test.SpringTransactionContextTest;
import org.meishi.app.modules.user.dao.IUserDao;
import org.meishi.app.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

@ContextConfiguration(locations = {"classpath:root-context-test.xml"})//,"classpath*:servlet-contest.xml"
public class UserDaoTest extends SpringTransactionContextTest {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private IUserDao userDao;
	
	@Test
	public void testEntityManager(){
		Assert.notNull(em);
	}
	
	@Test
	@Rollback(false)
	public void addUser(){
		User user = new User();
		user.setPassword("123456");
		user.setUsername("小明");
		em.persist(user);
		em.flush();
		
	}
	@Test
//	@Rollback(false)
	public void updateUser(){
		User user = em.find(User.class, 1l);
		user.setUsername("小红");
		em.merge(user);
		em.flush();
	}
	
	@Test
	public void findAll(){
		List<User> users = userDao.findAll();
		for(User u : users){
			System.out.println(u);
		}
	}
	
}
