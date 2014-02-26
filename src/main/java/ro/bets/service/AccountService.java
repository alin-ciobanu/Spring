package ro.bets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.bets.domain.Account;
import ro.bets.repository.AccountRepository;

import java.util.List;

/**
 * Created by yozmo on 2/25/14.
 */
@Service
@Transactional(readOnly = true)
public class AccountService implements AccountServiceInterface {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findById(Long idAccount) {
        return accountRepository.findOne(idAccount);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteAccount(Long idAccount) {
        accountRepository.delete(idAccount);
    }
}
