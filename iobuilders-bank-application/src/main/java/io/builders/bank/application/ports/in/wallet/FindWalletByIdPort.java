package io.builders.bank.application.ports.in.wallet;

import io.builders.bank.domain.entities.Wallet;

public interface FindWalletByIdPort {

  /**
   * Finds a wallet by its identifier.
   *
   * @param walletId Unique identifier of the wallet to search by.
   * @return The wallet found.
   */
  Wallet findWalletById(Long walletId);

}
