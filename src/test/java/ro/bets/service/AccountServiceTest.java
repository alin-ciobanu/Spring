package ro.bets.service;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.bets.config.InfrastructureConfig;
import ro.bets.domain.Account;

import java.util.Date;
import java.util.List;

/**
 * Created by yozmo on 2/25/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InfrastructureConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountServiceTest extends TestCase {

    @Autowired
    private AccountServiceInterface accountService;

    private Account account;
    Long id;

    @Before
    public void setUp() throws Exception {
        account = new Account();
        account.setDateCreated(new Date());
        account.setSalt("random");
        account.setPasswordHash("askdahsdhi1o4o23p12-asd");
        account.setEmail("mail@mail.ro");
        account.setUsername("yozmo");
    }

    @After
    public void tearDown() throws Exception {
        account = null;
    }

    @Test
    public void a_testCreateAccount() throws Exception {

        Account testAccount = accountService.createAccount(account);
        Assert.assertNotNull(testAccount);
    }

    @Test
    public void ab_testUpdateAccount() throws Exception {

        account.setSalt("rand_str");
        Account accountDB = accountService.createAccount(account); // update

        Assert.assertTrue(accountService.findAll().size() == 1);
        Assert.assertEquals(accountDB.getSalt(), "rand_str");

    }

    @Test
    public void b_testFindById() throws Exception {

        Account ac1 = accountService.createAccount(account);

        Account dbAccount = accountService.findById(ac1.getId());
        Assert.assertTrue(account.equals(dbAccount));

    }

    @Test
    public void c_testFindAll() throws Exception {

        Assert.assertEquals(accountService.findAll().size(), 1);

    }

    @Test
    public void d_testDeleteAccount() throws Exception {
        List<Account> accts = accountService.findAll();
        for (Account acct: accts) {
            accountService.deleteAccount(acct.getId());
        }
        Assert.assertEquals(accountService.findAll().size(), 0);
    }

}
