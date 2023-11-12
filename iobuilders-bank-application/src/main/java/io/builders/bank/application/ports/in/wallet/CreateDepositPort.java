package io.builders.bank.application.ports.in.wallet;

import io.builders.bank.domain.entities.Deposit;

public interface CreateDepositPort {

  /**
   * Creates a new deposit to a wallet.
   *
   * @param deposit Deposit information with the destiny wallet id where deposit the money amount.
   */
  void createDeposit(Deposit deposit);

}
