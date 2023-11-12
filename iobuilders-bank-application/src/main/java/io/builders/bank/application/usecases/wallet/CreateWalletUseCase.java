package io.builders.bank.application.usecases.wallet;

import static io.builders.bank.application.exception.Error.VALIDATION;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.in.wallet.CreateWalletPort;
import io.builders.bank.application.ports.out.persistence.UserPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Wallet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateWalletUseCase implements CreateWalletPort {

    @NonNull
    private WalletPersistencePort walletPersistencePort;

    @NonNull
    private UserPersistencePort userPersistencePort;

    @Override
    public Wallet createWallet(final Wallet wallet) {
        validate(wallet);
        return this.walletPersistencePort.persistWallet(wallet);
    }

    private void validate(final Wallet wallet) {
        if (wallet.getBalance().compareTo(0.0) < 0) {
            log.error("Error trying to create a new wallet, the balance is negative: {}", wallet);
            throw new ApplicationException(VALIDATION,
                    "Error trying to create the wallet, the balance can not be negative");
        }

        try {
            this.userPersistencePort.findUserById(wallet.getUserId());
        } catch (NotFoundException e) {
            log.error("Error, the owner specified for the wallet, with the ID {}, does not exists",
                    wallet.getUserId());
            throw new ApplicationException(VALIDATION,
                    "Error trying to create the wallet, the owner specified does not exists");
        }
    }

}