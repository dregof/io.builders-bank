package io.builders.bank.application.ports.out.persistence;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.domain.entities.Wallet;

public interface WalletPersistencePort {

    /**
     * Adds the amount indicated to the wallet with the identifier received.
     *
     * @param walletId Identifier of the wallet to add the money to.
     * @param amount   Amount of money to add.
     */
    void addAmountToWallet(Long walletId, Double amount) throws NotFoundException;

    /**
     * Withdraws the amount indicated to the wallet with the identifier received.
     *
     * @param walletId Identifier of the wallet to withdraw the money to.
     * @param amount   Amount of money to withdraw.
     */
    void withdrawAmountFromWallet(Long walletId, Double amount) throws NotFoundException;

    /**
     * Persist a new wallet with the information received.
     *
     * @param wallet Information of the wallet to persist.
     * @return The wallet persisted.
     */
    Wallet persistWallet(Wallet wallet);

    /**
     * Finds a wallet by its identifier.
     *
     * @param walletId Identifier of the wallet to search by.
     * @return The wallet found.
     */
    Wallet findWalletById(Long walletId) throws NotFoundException;

}