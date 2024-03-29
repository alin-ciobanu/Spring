package ro.bets.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import ro.bets.config.InfrastructureConfig;
import ro.bets.domain.Account;

import java.util.Date;

/**
 * Created by yozmo on 2/25/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {InfrastructureConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TransactionConfiguration(defaultRollback=false)
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    private Account account;

    @Before
    public void setUp() throws Exception {

        account = new Account();
        account.setUsername("myFirstJpaTest");
        account.setEmail("test@hero.ro");
        account.setPasswordHash("asweqAS23DAweq123Jwda12o3");
        account.setSalt("random_string");
        account.setDateCreated(new Date(1991, 11, 16));

    }

    @Test
    public void testCreateAccount() throws Exception {

        Account testAccount = accountRepository.save(account);
        Assert.assertNotNull(testAccount.getId());

    }

    @Test
    public void testDeleteAccount() throws Exception {

        accountRepository.deleteAll();
        Assert.assertEquals(accountRepository.findAll().size(), 0);

    }

}
