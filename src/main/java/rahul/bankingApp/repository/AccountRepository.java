package rahul.bankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rahul.bankingApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
