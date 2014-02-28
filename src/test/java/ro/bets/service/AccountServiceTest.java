package ro.bets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ro.bets.config.InfrastructureConfig;
import ro.bets.domain.Account;

import java.util.Date;

/**
 * Created by yozmo on 2/25/14.
 */
@ContextConfiguration(classes = {InfrastructureConfig.class})
@TransactionConfiguration(defaultRollback=false)
public class AccountServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private AccountServiceInterface accountService;

    private Account account;
    private Long id;
    private int noOfEntriesInDB;

    @Override
    @BeforeSuite
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }

    @BeforeClass
    public void setUp() throws Exception {
        account = new Account();
        account.setDateCreated(new Date());
        account.setSalt("random");
        account.setPasswordHash("askdahsdhi1o4o23p12-asd");
        account.setEmail("mail@mail.ro");
        account.setUsername("yozmo");
    }

    @AfterClass
    public void tearDown() throws Exception {
        account = null;
    }

    @Test(priority = 1)
    public void testCreateAccount() throws Exception {

        noOfEntriesInDB = accountService.findAll().size();

        Account testAccount = accountService.createAccount(account);
        Assert.assertNotNull(testAccount.getId());
        id = testAccount.getId();
        account.setId(id); // used for next test

    }

    @Test(priority = 2)
    public void testUpdateAccount() throws Exception {

        account.setSalt("rand_str");
        Account accountDB = accountService.updateAccount(account); // update

        Assert.assertTrue(accountService.findAll().size() == noOfEntriesInDB + 1);
        Assert.assertEquals(accountDB.getSalt(), "rand_str");

    }

    @Test(priority = 3)
    public void testFindById() throws Exception {

        Account dbAccount = accountService.findById(id);
        Assert.assertEquals(account.getId(), dbAccount.getId());
//        Assert.assertTrue(account.equals(dbAccount));

    }

    @Test(priority = 4)
    public void testFindAll() throws Exception {

        Assert.assertEquals(accountService.findAll().size(), noOfEntriesInDB + 1);

    }

    @Test(priority = 5)
    public void testDeleteAccount() throws Exception {

        accountService.deleteAccount(id);
        Assert.assertEquals(accountService.findAll().size(), noOfEntriesInDB);

    }

}
