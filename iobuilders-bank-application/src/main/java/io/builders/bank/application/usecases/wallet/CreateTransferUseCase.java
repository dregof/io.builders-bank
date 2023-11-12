package io.builders.bank.application.usecases.wallet;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.in.wallet.CreateTransferPort;
import io.builders.bank.application.ports.out.persistence.TransferPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Transfer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static io.builders.bank.application.exception.Error.VALIDATION;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateTransferUseCase implements CreateTransferPort {

    @NonNull
    private WalletPersistencePort walletPersistencePort;

    @NonNull
    private TransferPersistencePort transferPersistencePort;

    @Override
    @Transactional
    public void createTransfer(final Transfer transfer) {
        try {
            validate(transfer);
            this.transferPersistencePort.persistTransfer(transfer);
            this.walletPersistencePort.addAmountToWallet(transfer.getDestinationWalletId(), transfer.getAmount());
            this.walletPersistencePort.withdrawAmountFromWallet(transfer.getOriginWalletId(), transfer.getAmount());
        } catch (final NotFoundException exception) {
            log.error(exception.getMessage(), exception);
            throw new ApplicationException(exception.getErrorCode(), exception.getMessage());
        }
    }

    private void validate(final Transfer transfer) {
        if (transfer.getAmount().compareTo(0.0) < 0) {
            log.error("Error trying to create a new transfer, the amount is negative: {}", transfer);
            throw new ApplicationException(VALIDATION,
                    "Error trying to create the transfer, the amount can not be negative");
        }

    }
}