package io.builders.bank.application.ports.in.wallet;

import io.builders.bank.domain.entities.Transfer;

public interface CreateTransferPort {

  /**
   * Creates a new transfer between two wallets.
   *
   * @param transfer Transfer information with the wallets ids and the amount involved in.
   */
  void createTransfer(Transfer transfer);

}
