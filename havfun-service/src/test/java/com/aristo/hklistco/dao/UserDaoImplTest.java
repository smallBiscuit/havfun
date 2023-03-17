package com.aristo.hklistco.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.aristo.hklistco.service.config.HklistcoDaoTestConfig;
import com.havfun.service.dao.UserDao;
import com.havfun.service.entity.User;

@ContextConfiguration(classes = { HklistcoDaoTestConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional("hklistcoTxnManager")
@TransactionConfiguration(defaultRollback = true)
public class UserDaoImplTest {

	/** logger */
	private final static Logger LOGGER = LogManager.getLogger(UserDaoImplTest.class.getSimpleName());

	@Autowired
	private UserDao userDao;

	@BeforeClass
	public static void init() throws Exception {
		LOGGER.debug("init...");
	}

	@AfterClass
	public static void destroy() throws Exception {
		LOGGER.debug("destory...");
	}

	@Before
	public void setUp() throws Exception {
		LOGGER.debug("setup...");
	}

	@After
	public void tearDown() throws Exception {
		LOGGER.debug("tearDown");
	}

	@Test
	public void testCreateAndRead() {
		Assert.assertNotNull(userDao);
		User user = doCreate("userLoginId");
		int result = userDao.create(user);
		Assert.assertTrue(result > 0);
		User theUser = userDao.read(result);
		Assert.assertNotNull(theUser);
		LOGGER.debug(user);
		LOGGER.debug(theUser);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(user, theUser, "userId"));
	}

	@Test
	public void testDelete() {
		Assert.assertNotNull(userDao);
		User user = doCreate("userLoginId");
		int result = userDao.create(user);

		User dbUser = userDao.read(result);
		Assert.assertNotNull(dbUser);

		User delete = new User();
		delete.setUserId(result);
		userDao.delete(delete);

		User theUser = userDao.read(result);
		Assert.assertNull(theUser);
	}

	@Test
	public void testUpdate() {
		Assert.assertNotNull(userDao);
		User user = doCreate("userLoginId");
		int result = userDao.create(user);

		User dbUser = userDao.read(result);
		LOGGER.debug(dbUser);
		this.doUpdate(dbUser);
		userDao.update(dbUser);

		User theUser = userDao.read(result);
		LOGGER.debug(dbUser);
		LOGGER.debug(theUser);

		Assert.assertTrue(EqualsBuilder.reflectionEquals(dbUser, theUser));
	}
	
	@Test
	public void testReadAll(){
		Assert.assertNotNull(userDao);
		
		User user1 = doCreate("userLoginId1");
		
		int[] result = {userDao.create(user1),userDao.create(user1),userDao.create(user1)};
		User[] expectedDbResult = new User[]{userDao.read(result[0]),userDao.read(result[1]),userDao.read(result[2])};
		List<User> dbUserList = userDao.readAll();
		
		int i = 0;
		for(User dbUser : dbUserList ){
			LOGGER.debug(dbUser);
			Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedDbResult[i], dbUser));
			i++;
		}
	}
	
	@Test
	public void testReadByUserLoginId(){
		Assert.assertNotNull(userDao);
		
		User[] users = new User[]{doCreate("userLoginId1"),doCreate("userLoginId2"),doCreate("userLoginId3")};
		
		List<Integer> results = new ArrayList<Integer>();
		
		for(User user : users){
			results.add(userDao.create(user));
		}
		
		User expectedDbResult = userDao.read(results.get(0));
		User dBUser = userDao.readByUserName("userLoginId1");
		Assert.assertNotNull(dBUser);
		LOGGER.debug(dBUser);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedDbResult, dBUser));
	}

	public User doCreate(String userLoginId) {
		User user = new User();

		user.setUserName("userName");

		return user;
	}

	public void doUpdate(User dbUser) {
//		dbUser.setUserEmail("new userEmail");
	}
}
