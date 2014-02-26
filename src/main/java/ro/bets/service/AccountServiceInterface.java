package ro.bets.service;

import ro.bets.domain.Account;

import java.util.List;

/**
 * Created by yozmo on 2/25/14.
 */
public interface AccountServiceInterface {

    Account createAccount (Account account);

    Account findById (Long idAccount);

    List<Account> findAll();

    void  deleteAccount (Long idAccount);

}