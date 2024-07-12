package rahul.bankingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String accountHolderName;
    private String accountHolderAddress;
    private String accountHolderEmail;
    private double balance;

}
