package io.builders.bank.application.usecases.wallet;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.in.wallet.FindWalletByIdPort;
import io.builders.bank.application.ports.out.persistence.TransferPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Wallet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindWalletByIdUseCase implements FindWalletByIdPort {

    @NonNull
    private WalletPersistencePort walletPersistencePort;

    @NonNull
    private TransferPersistencePort transferPersistencePort;

    @Override
    public Wallet findWalletById(final Long walletId) {
        try {
            final Wallet wallet = this.walletPersistencePort.findWalletById(walletId);
            wallet.setTransfers(this.transferPersistencePort.findByWalletId(walletId));
            return wallet;
        } catch (final NotFoundException exception) {
            log.error(exception.getMessage(), exception);
            throw new ApplicationException(exception.getErrorCode(), exception.getMessage());
        }
    }

}