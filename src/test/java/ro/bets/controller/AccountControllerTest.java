package ro.bets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ro.bets.config.InfrastructureConfig;
import ro.bets.domain.Account;

import java.util.Date;

/**
 * Created by yozmo on 2/28/14.
 */

@ContextConfiguration(classes = {InfrastructureConfig.class})
@TransactionConfiguration(defaultRollback=false)
public class AccountControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AccountController accountController;

    private Account account;

    @Override
    @BeforeSuite
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        account = new Account();
        account.setPasswordHash("qweqeasvasgoghth");
        account.setDateCreated(new Date());
        account.setSalt("random_rand");
        account.setEmail("email@my.ro");
        account.setUsername("gigel");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        account = null;
    }

    @Test
    public void testGetAccount() throws Exception {

    }

    @Test
    public void testGetAllAccounts() throws Exception {

    }

    @Test
    public void testCreateAccount() throws Exception {

    }
}
