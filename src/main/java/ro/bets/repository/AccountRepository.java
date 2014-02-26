package ro.bets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.bets.domain.Account;

/**
 * Created by yozmo on 2/25/14.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
