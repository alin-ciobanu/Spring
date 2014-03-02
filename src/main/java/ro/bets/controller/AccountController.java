package ro.bets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.bets.domain.Account;
import ro.bets.service.AccountServiceInterface;

import java.util.List;

/**
 * Created by yozmo on 2/28/14.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountServiceInterface accountService;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Account getAccount (@RequestParam("id") Long id) {
        return accountService.findById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Account createAccount (@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public Account updateAccount (@RequestBody Account account) {
        return accountService.updateAccount(account);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
//    @ResponseBody
    public void deleteAccount (@RequestParam("id") Long id) {
        accountService.deleteAccount(id);
    }

}
