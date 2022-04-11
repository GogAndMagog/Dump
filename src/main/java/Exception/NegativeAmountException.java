package Exception;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public class NegativeAmountException extends Error{
  String amount;

  public String getAmount() {
    return amount;
  }

  public  NegativeAmountException(String message, @NotNull BigDecimal amount)
  {
    super(message);
    this.amount = amount.toString();
  }
}
