package BankAccount;

import java.math.BigDecimal;
import java.util.Currency;
import Exception.NegativeAmountException;

public class BankAccount {
  private int personId;
  private int accountNumber;
  private int bankAccountId;
  private final Currency currency;
  private BigDecimal amount;

  public BankAccount(int personId, int accountNumber, Currency currency, BigDecimal amount) {
    this.personId       = personId;
    this.accountNumber  = accountNumber;
    this.currency       = currency;
    this.amount         = amount;
  }

  public BankAccount(int personId, Currency currency, BigDecimal amount) {
    this.personId = personId;
    this.currency = currency;
    this.amount   = amount;
  }

  public Currency getCurrency() {
    return currency;
  }

  public int getPersonId() {
    return personId;
  }

  public BigDecimal getAmount(){
    return amount;
  }

 public void AddMoney(BigDecimal amount){
    if (amount.compareTo(BigDecimal.ZERO) < 0)
      throw new NegativeAmountException("", amount);
    else
      this.amount.add(amount);
 }
}
