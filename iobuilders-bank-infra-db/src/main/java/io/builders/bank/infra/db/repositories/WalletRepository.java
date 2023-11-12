package io.builders.bank.infra.db.repositories;

import static io.builders.bank.application.exception.Error.NOT_FOUND;
import static org.apache.commons.lang3.StringUtils.join;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.infra.db.entities.WalletEntity;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class WalletRepository {

    private final AtomicLong counter = new AtomicLong(0L);

    private final ConcurrentHashMap<Long, WalletEntity> wallets = new ConcurrentHashMap<>();

    public WalletEntity persistWallet(final WalletEntity walletEntity) {
        walletEntity.setId(this.counter.addAndGet(1));
        this.wallets.put(walletEntity.getId(), walletEntity);
        return walletEntity;
    }

    public WalletEntity findById(final Long walletId) throws NotFoundException {

        final WalletEntity walletEntity = this.wallets.get(walletId);

        if (walletEntity == null) {
            throw new NotFoundException(NOT_FOUND,
                    join("The wallet with ID ", walletId, " could not be found"));
        }

        return walletEntity;
    }

    public void modifyWalletBalance(final Long walletId, final Double amount,
                                    final boolean addAmount) throws NotFoundException {

        final WalletEntity walletEntity = this.wallets.computeIfPresent(walletId, (key, wallet) -> {
            if (addAmount) {
                wallet.setBalance(Double.sum(wallet.getBalance(), amount));
            } else {
                BigDecimal balance = new BigDecimal(Double.toString(wallet.getBalance()));
                BigDecimal amountToSubtract = new BigDecimal(Double.toString(amount));
                wallet.setBalance(balance.subtract(amountToSubtract).doubleValue());
            }
            return wallet;
        });

        if (walletEntity == null) {
            throw new NotFoundException(NOT_FOUND,
                    join("Error adding amount to wallet with ID ", walletId, " because it does not exists"));
        }

    }

}