package rahul.bankingApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahul.bankingApp.dto.AccountDto;
import rahul.bankingApp.service.AccountService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //create new bank account Rest api
    @PostMapping()
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //get account rest api - to fetch account details based on id, if exist
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id)
    {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    //deposit amount rest api
    @PutMapping("/{id}/depositAmount")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id,@RequestBody Map<String, Double> request)
    {
        double amountToDeposit = request.get("depositAmount");
        AccountDto accountDto = accountService.depositAmount(id, amountToDeposit);
        return  ResponseEntity.ok(accountDto);
    }

    //withdraw amount rest api
    @PutMapping("/{id}/withdrawAmount")
    public ResponseEntity<AccountDto> withdrawAmount(@PathVariable Long id,@RequestBody Map<String, Double> request)
    {
        double amountToWithdraw = request.get("withdrawalAmount");
        AccountDto accountDto = accountService.withdrawAmount(id, amountToWithdraw);
        return  ResponseEntity.ok(accountDto);
    }

    //fetch all account details rest api
    @GetMapping("/getAllAccounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts()
    {
        List<AccountDto> accountDtoList =accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtoList);

    }

    //delete bank account rest api
    @DeleteMapping("/{id}/deleteAccount")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id)
    {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account successfully deleted from db. Happy Banking :)");
    }

    //update name,email,address and mobile phone in bank account rest api
    @PutMapping("/{id}/updateDetails")
    public ResponseEntity<AccountDto> updateName(@PathVariable Long id,@RequestBody Map<String, String> request)
    {
        String newName = request.get("updatedAccountHolderName");
        String newEmail = request.get("updatedEmail");
        String newAddress = request.get("updatedAddress");
        String newPhone = request.get("updatedPhoneNumber");

        AccountDto accountDto = accountService.updateDetails(id, newName, newEmail, newAddress, newPhone);
        return ResponseEntity.ok(accountDto);

    }


}
