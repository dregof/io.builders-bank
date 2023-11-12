package io.builders.bank.application.ports.in.wallet;

import io.builders.bank.domain.entities.Wallet;

public interface CreateWalletPort {

  /**
   * Creates a wallet with the received information.
   *
   * @param wallet The wallet information to create a new one.
   * @return The created wallet.
   */
  Wallet createWallet(Wallet wallet);

}
