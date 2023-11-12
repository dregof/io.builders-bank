package io.builders.bank.application.usecases.wallet;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.in.wallet.CreateDepositPort;
import io.builders.bank.application.ports.out.persistence.TransferPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Deposit;
import io.builders.bank.domain.entities.Transfer;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static io.builders.bank.application.exception.Error.VALIDATION;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateDepositUseCase implements CreateDepositPort {

    @NonNull
    private WalletPersistencePort walletPersistencePort;

    @NonNull
    private TransferPersistencePort transferPersistencePort;

    @Override
    public void createDeposit(final Deposit deposit) {
        try {
            validate(deposit);
            this.walletPersistencePort.addAmountToWallet(deposit.getDestinationWalletId(), deposit.getAmount());
            this.transferPersistencePort.persistTransfer(Transfer.builder()
                    .destinationWalletId(deposit.getDestinationWalletId())
                    .amount(deposit.getAmount())
                    .build());
        } catch (final NotFoundException exception) {
            log.error(exception.getMessage(), exception);
            throw new ApplicationException(exception.getErrorCode(), exception.getMessage());
        }
    }

    private void validate(final Deposit deposit) {

        if (deposit.getAmount().compareTo(0.0) < 0) {
            log.error("Error trying to create a new deposit, the amount is negative: {}", deposit);
            throw new ApplicationException(VALIDATION,
                    "Error trying to create the deposit, the amount can not be negative");
        }

    }

}