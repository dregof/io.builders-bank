package io.builders.bank.application.ports.out.persistence;

import io.builders.bank.domain.entities.Transfer;

import java.util.List;

public interface TransferPersistencePort {

    /**
     * Persists a new transfer with the information received.
     *
     * @param transfer The information of the transfer to persist.
     */
    void persistTransfer(Transfer transfer);

    /**
     * Finds the list of transfer associated to the wallet identifier received.
     *
     * @param walletId The identifier of the wallet to search by.
     * @return The list of transfers found.
     */
    List<Transfer> findByWalletId(Long walletId);

}