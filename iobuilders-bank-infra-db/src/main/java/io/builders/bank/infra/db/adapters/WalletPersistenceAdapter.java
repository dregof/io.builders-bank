package io.builders.bank.infra.db.adapters;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.infra.db.entities.WalletEntity;
import io.builders.bank.infra.db.mappers.WalletMapper;
import io.builders.bank.infra.db.repositories.WalletRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WalletPersistenceAdapter implements WalletPersistencePort {

    @NonNull
    private WalletMapper walletMapper;

    @NonNull
    private WalletRepository walletRepository;

    @Override
    public Wallet persistWallet(final Wallet wallet) {
        final WalletEntity walletEntity = this.walletRepository.persistWallet(this.walletMapper.toWalletEntity(wallet));
        return this.walletMapper.toWallet(walletEntity);
    }

    @Override
    public Wallet findWalletById(final Long walletId) throws NotFoundException {
        return this.walletMapper.toWallet(this.walletRepository.findById(walletId));
    }

    @Override
    public void addAmountToWallet(final Long walletId, final Double amount) throws NotFoundException {
        this.walletRepository.modifyWalletBalance(walletId, amount, true);
    }

    @Override
    public void withdrawAmountFromWallet(final Long walletId, final Double amount) throws NotFoundException {
        this.walletRepository.modifyWalletBalance(walletId, amount, false);
    }
}
