package rahul.bankingApp.service;

import rahul.bankingApp.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDTO);

    AccountDto getAccountById(Long id);

    AccountDto depositAmount(Long id, double depositAmount);

    AccountDto withdrawAmount(Long id, double withdrawalAmount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

    AccountDto updateDetails(Long id, String newName, String newEmail, String newAddress, String newPhoneNumber);
}
