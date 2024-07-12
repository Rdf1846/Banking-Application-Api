package rahul.bankingApp.service.impl;

import org.springframework.stereotype.Service;
import rahul.bankingApp.dto.AccountDto;
import rahul.bankingApp.entity.Account;
import rahul.bankingApp.mapper.AccountMapper;
import rahul.bankingApp.repository.AccountRepository;
import rahul.bankingApp.service.AccountService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDTO) {
        Account account = AccountMapper.mapAccountDtoToAccountJpaEntity(accountDTO);
        Account savedAccount = accountRepository.save(account);
        AccountDto accountDto = AccountMapper.mapAccountJpaEntityToAccountDto(savedAccount);
        return accountDTO;
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Bank account does not exist in db")
                );
        AccountDto accountDto = AccountMapper.mapAccountJpaEntityToAccountDto(account);
        return accountDto;
    }

    @Override
    public AccountDto depositAmount(Long id, double depositAmount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Bank account does not exist in db")
                );
        account.setBalance(account.getBalance() + depositAmount);
        Account savedAccount =accountRepository.save(account);
        AccountDto accountDto = AccountMapper.mapAccountJpaEntityToAccountDto(savedAccount);
        return accountDto;
    }

    @Override
    public AccountDto withdrawAmount(Long id, double withdrawalAmount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Bank account does not exist in db")
                );

        if(withdrawalAmount > account.getBalance())
        {
            throw new RuntimeException("Withdrawal amount is greater than account balance. Kindly enter accordingly");
        }

        account.setBalance(account.getBalance() - withdrawalAmount);
        Account savedAccount =accountRepository.save(account);
        AccountDto accountDto = AccountMapper.mapAccountJpaEntityToAccountDto(savedAccount);
        return accountDto;

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> allEntityList = accountRepository.findAll();
        List<AccountDto> allEntityDtoList = allEntityList.stream()
                                            .map((account) ->  AccountMapper.mapAccountJpaEntityToAccountDto(account))
                                            .collect(Collectors.toList());
        return allEntityDtoList;
    }

    @Override
    public void deleteAccount(Long id)
    {
        Account accountEntity = accountRepository
                                .findById(id)
                                .orElseThrow( () -> new RuntimeException("Account does not exist in database"));

        accountRepository.deleteById(id);

    }

    @Override
    public AccountDto updateDetails(Long id, String newName, String newEmail, String newAddress, String newPhoneNumber)
    {
        Account accountEntity = accountRepository
                            .findById(id)
                            .orElseThrow( () -> new RuntimeException("Account does not exist"));

        if(newName != null) {
            accountEntity.setAccountHolderName(newName);
        }
        if(newEmail != null) {
            accountEntity.setAccountHolderEmail(newEmail);
        }
        if(newAddress != null) {
            accountEntity.setAccountHolderAddress(newAddress);
        }
        if(newPhoneNumber != null) {
            accountEntity.setPhoneNumber(newPhoneNumber);
        }

        Account savedAccount = accountRepository.save(accountEntity);
        AccountDto accountDto = AccountMapper.mapAccountJpaEntityToAccountDto(savedAccount);

        return accountDto;
    }


}
