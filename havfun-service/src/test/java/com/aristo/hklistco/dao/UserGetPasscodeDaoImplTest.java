package com.aristo.hklistco.dao;

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
import com.havfun.service.dao.UserGetPasscodeDao;
import com.havfun.service.entity.UserGetPasscode;
import com.havfun.service.entity.constant.UserGetPasscodeStatus;

@ContextConfiguration(classes = { HklistcoDaoTestConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional("hklistcoTxnManager")
@TransactionConfiguration(defaultRollback = true)
public class UserGetPasscodeDaoImplTest {
	
	/** logger */
	private final static Logger LOGGER = LogManager.getLogger(UserGetPasscodeDaoImplTest.class.getSimpleName());
	
	@Autowired
	private UserGetPasscodeDao userGetPasscodeDao;

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
		Assert.assertNotNull(userGetPasscodeDao);
		UserGetPasscode userGetPasscode = doCreate();
		int result = userGetPasscodeDao.create(userGetPasscode);
		Assert.assertTrue(result > 0);
		UserGetPasscode theUserGetPasscode = userGetPasscodeDao.read(result);
		Assert.assertNotNull(theUserGetPasscode);
		LOGGER.debug(userGetPasscode);
		LOGGER.debug(theUserGetPasscode);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(userGetPasscode, theUserGetPasscode));
	}
	
	@Test
	public void testDelete() {
		Assert.assertNotNull(userGetPasscodeDao);
		UserGetPasscode userGetPasscode = doCreate();
		int result = userGetPasscodeDao.create(userGetPasscode);
		
		UserGetPasscode dbUserGetPasscode = userGetPasscodeDao.read(result);
		Assert.assertNotNull(dbUserGetPasscode);
		
		UserGetPasscode delete = new UserGetPasscode();
		delete.setUserId(result);
		userGetPasscodeDao.delete(delete);
		
		UserGetPasscode theUserGetPasscode = userGetPasscodeDao.read(result);
		Assert.assertNull(theUserGetPasscode);
	}
	
	@Test
	public void testUpdate() {
		Assert.assertNotNull(userGetPasscodeDao);
		UserGetPasscode userGetPasscode = doCreate();
		int result = userGetPasscodeDao.create(userGetPasscode);
		
		UserGetPasscode dbUserGetPasscode = userGetPasscodeDao.read(result);
		LOGGER.debug(dbUserGetPasscode);
		doUpdate(dbUserGetPasscode);
		userGetPasscodeDao.update(dbUserGetPasscode);
		
		UserGetPasscode theUserGetPasscode = userGetPasscodeDao.read(result);
		LOGGER.debug(dbUserGetPasscode);
		LOGGER.debug(theUserGetPasscode);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(dbUserGetPasscode, theUserGetPasscode));
	}
	
	public UserGetPasscode doCreate() {
		UserGetPasscode userGetPasscode = new UserGetPasscode();
		
		userGetPasscode.setUserId(123);
		userGetPasscode.setGeneratedToken("generatedToken");
		userGetPasscode.setExpiryTime(System.currentTimeMillis() + 1000L * 60 *60);
		userGetPasscode.setUserGetPasscodeStatus(UserGetPasscodeStatus.ACTIVE);
		
		return userGetPasscode;
	}
	
	public void doUpdate(UserGetPasscode dbUserGetPasscode) {
		dbUserGetPasscode.setUserGetPasscodeStatus(UserGetPasscodeStatus.DONE);
	}
}
