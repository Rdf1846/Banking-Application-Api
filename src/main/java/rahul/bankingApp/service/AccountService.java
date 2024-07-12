package rahul.bankingApp.service;

import rahul.bankingApp.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDTO);

    AccountDto getAccountById(Long id);
}
