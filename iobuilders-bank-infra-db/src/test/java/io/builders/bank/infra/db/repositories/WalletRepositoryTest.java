package io.builders.bank.infra.db.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.infra.db.entities.WalletEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WalletRepositoryTest {

    @InjectMocks
    private WalletRepository walletRepository;

    @Test
    @DisplayName("Persist a new wallet and find it by its identifier")
    void persistAndFindSuccessfully() throws NotFoundException {

        final Long userId = 1L;
        final Double balance = 100.00;
        final WalletEntity wallet = WalletEntity.builder().userId(userId).balance(balance).build();

        final WalletEntity walletPersisted = this.walletRepository.persistWallet(wallet);

        assertThat(walletPersisted.getId()).isEqualTo(1L);

        final WalletEntity walletFound = this.walletRepository.findById(walletPersisted.getId());

        assertThat(walletFound.getId()).isEqualTo(1L);
        assertThat(walletFound.getUserId()).isEqualTo(userId);
        assertThat(walletFound.getBalance()).isEqualTo(balance);
    }

    @Test
    @DisplayName("Throws exception when the wallet does not exists")
    void throwExceptionWhenNotExists() {
        assertThrows(NotFoundException.class, () -> this.walletRepository.findById(1L));
    }

    @Test
    @DisplayName("Modify wallet´s amount successfully")
    void modifyAmountToWalletSuccessfully() throws NotFoundException {

        final Long userId = 1L;
        final Double balance = 100.00;
        final WalletEntity wallet = WalletEntity.builder().userId(userId).balance(balance).build();

        final WalletEntity walletPersisted = this.walletRepository.persistWallet(wallet);

        assertThat(walletPersisted.getId()).isEqualTo(1L);

        this.walletRepository.modifyWalletBalance(walletPersisted.getId(), 100.00, true);

        final WalletEntity walletFound = this.walletRepository.findById(walletPersisted.getId());
        assertThat(walletFound.getBalance()).isEqualTo(200.00);

        this.walletRepository.modifyWalletBalance(walletPersisted.getId(), 50.00, false);

        final WalletEntity secondWalletFound = this.walletRepository.findById(walletPersisted.getId());
        assertThat(secondWalletFound.getBalance()).isEqualTo(150.00);
    }

}