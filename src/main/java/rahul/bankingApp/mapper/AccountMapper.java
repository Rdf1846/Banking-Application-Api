package rahul.bankingApp.mapper;

import rahul.bankingApp.dto.AccountDto;
import rahul.bankingApp.entity.Account;

public class AccountMapper {
    public static Account mapAccountDtoToAccountJpaEntity(AccountDto accountDto)
    {
        Account account = new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getAccountHolderAddress(),
                accountDto.getAccountHolderEmail(),
                accountDto.getBalance()
        );
        return account;
    }

    public static AccountDto mapAccountJpaEntityToAccountDto(Account account)
    {
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getAccountHolderAddress(),
                account.getAccountHolderEmail(),
                account.getBalance()
        );
        return accountDto;
    }

}
