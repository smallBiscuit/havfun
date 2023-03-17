package com.aristo.hklistco.dao;

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
import com.havfun.service.dao.UserLoginHistoryDao;
import com.havfun.service.entity.UserLoginHistory;
import com.havfun.service.entity.constant.LoginStatus;

@ContextConfiguration(classes = { HklistcoDaoTestConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional("hklistcoTxnManager")
@TransactionConfiguration(defaultRollback = true)
public class UserLoginHistoryDaoImplTest {

	/** logger */
	private final static Logger LOGGER = LogManager.getLogger(UserLoginHistoryDaoImplTest.class.getSimpleName());

	@Autowired
	private UserLoginHistoryDao userLoginHistoryDao;

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
		Assert.assertNotNull(userLoginHistoryDao);
		UserLoginHistory userLoginHistory = doCreate("loginToken",5555,LoginStatus.LOGIN);
		int result = userLoginHistoryDao.create(userLoginHistory);
		Assert.assertTrue(result > 0);
		UserLoginHistory theUserLoginHistory = userLoginHistoryDao.read(result);
		Assert.assertNotNull(theUserLoginHistory);
		LOGGER.debug(userLoginHistory);
		LOGGER.debug(theUserLoginHistory);
		Assert.assertTrue(EqualsBuilder.reflectionEquals(userLoginHistory, theUserLoginHistory, "userLoginHistoryId"));
	}

	@Test
	public void testDelete() {
		Assert.assertNotNull(userLoginHistoryDao);
		UserLoginHistory userLoginHistory = doCreate("loginToken",5555,LoginStatus.LOGIN);
		int result = userLoginHistoryDao.create(userLoginHistory);

		UserLoginHistory dbUserLoginHistory = userLoginHistoryDao.read(result);
		Assert.assertNotNull(dbUserLoginHistory);

		UserLoginHistory delete = new UserLoginHistory();
		delete.setUserLoginHistoryId(result);
		userLoginHistoryDao.delete(delete);
		
		UserLoginHistory theUserLoginHistory = userLoginHistoryDao.read(result);
		Assert.assertNull(theUserLoginHistory);
	}

	@Test
	public void testUpdate() {
		Assert.assertNotNull(userLoginHistoryDao);
		UserLoginHistory userLoginHistory = doCreate("loginToken",5555,LoginStatus.LOGIN);
		int result = userLoginHistoryDao.create(userLoginHistory);

		UserLoginHistory dbUserLoginHistory = userLoginHistoryDao.read(result);
		LOGGER.debug(dbUserLoginHistory);
		this.doUpdate(dbUserLoginHistory);
		userLoginHistoryDao.update(dbUserLoginHistory);

		UserLoginHistory theUserLoginHistory = userLoginHistoryDao.read(result);
		LOGGER.debug(dbUserLoginHistory);
		LOGGER.debug(theUserLoginHistory);

		Assert.assertTrue(EqualsBuilder.reflectionEquals(dbUserLoginHistory, theUserLoginHistory));
	}

	@Test
	public void testReadByUserIdAndToken(){
		Assert.assertNotNull(userLoginHistoryDao);
		
		UserLoginHistory userLoginHistory1 = doCreate("loginToken1", 1000,LoginStatus.LOGIN);
		UserLoginHistory userLoginHistory2 = doCreate("loginToken2", 2000,LoginStatus.LOGIN);
		
		int result1 = userLoginHistoryDao.create(userLoginHistory1);
		int result2 = userLoginHistoryDao.create(userLoginHistory2);
		
		Assert.assertTrue(result1>0 && result2 >0 );
		
		UserLoginHistory expectedResultDbUserLoginHistory = userLoginHistoryDao.read(result1);
		Assert.assertNotNull(expectedResultDbUserLoginHistory);
		UserLoginHistory theUserLoginHistory = userLoginHistoryDao.readByUserIdAndToken(userLoginHistory1.getUserId(), userLoginHistory1.getLoginToken());
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(theUserLoginHistory, expectedResultDbUserLoginHistory));
	}
	
	@Test
	public void testReadAllLogin(){
		Assert.assertNotNull(userLoginHistoryDao);
		
		UserLoginHistory userLoginHistory1 = doCreate("loginToken1", 10000,LoginStatus.LOGIN);
		UserLoginHistory userLoginHistory2 = doCreate("loginToken2", 20000,LoginStatus.LOGIN);
		UserLoginHistory userLoginHistory3 = doCreate("loginToken3", 10000,LoginStatus.LOGIN);
		UserLoginHistory userLoginHistory4 = doCreate("loginToken4", 10000,LoginStatus.LOGIN);
		UserLoginHistory userLoginHistory5 = doCreate("loginToken5", 10000,LoginStatus.FAIL);
		
		int result1 = userLoginHistoryDao.create(userLoginHistory1);
		int result2 = userLoginHistoryDao.create(userLoginHistory2);
		int result3 = userLoginHistoryDao.create(userLoginHistory3);
		int result4 = userLoginHistoryDao.create(userLoginHistory4);
		int result5 = userLoginHistoryDao.create(userLoginHistory5);
				
		Assert.assertTrue(result1>0 && result2 >0 && result3 >0 && result4 >0 && result5 >0);
		
		UserLoginHistory[] expectedDbResult = new UserLoginHistory[]{userLoginHistoryDao.read(result1),userLoginHistoryDao.read(result3),userLoginHistoryDao.read(result4)};
		List<UserLoginHistory> dbUserLoginHistoryList = userLoginHistoryDao.readAllLogin(userLoginHistory1.getUserId());
		Assert.assertTrue(dbUserLoginHistoryList.size() == expectedDbResult.length);
		int i = 0;
		for(UserLoginHistory dbUserLoginHistory: dbUserLoginHistoryList){
			LOGGER.debug(dbUserLoginHistory);
			Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedDbResult[i], dbUserLoginHistory));
			i++;
		}
	}
	
	public UserLoginHistory doCreate(String loginToken, int userId, LoginStatus loginStatus) {
		UserLoginHistory userLoginHistory = new UserLoginHistory();
		userLoginHistory.setIpAddress("ipAddress");
		userLoginHistory.setLoginStatus(loginStatus);
		userLoginHistory.setLoginTimestamp(1231456);
		userLoginHistory.setLogoutTimestamp(88888);
		userLoginHistory.setUserId(userId);
		userLoginHistory.setLoginToken(loginToken);
		return userLoginHistory;
	}

	public void doUpdate(UserLoginHistory dbUserLoginHistory) {
		dbUserLoginHistory.setIpAddress("new ipAddress");
	}
}
