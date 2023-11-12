package io.builders.bank.application.usecases.wallet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.out.persistence.UserPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateWalletUseCaseTest {

    @InjectMocks
    private CreateWalletUseCase createWalletUseCase;

    @Mock
    private UserPersistencePort userPersistencePort;

    @Mock
    private WalletPersistencePort walletPersistencePort;

    @Test
    @DisplayName("Persist a new wallet successfully")
    void createWalletSuccessfully() throws NotFoundException {

        final Long userId = 1L;
        final Wallet walletToPersist = mock(Wallet.class);
        final Wallet walletPersisted = mock(Wallet.class);

        when(walletToPersist.getUserId()).thenReturn(userId);
        when(this.walletPersistencePort.persistWallet(walletToPersist)).thenReturn(walletPersisted);

        final Wallet result = this.createWalletUseCase.createWallet(walletToPersist);

        verify(this.userPersistencePort).findUserById(userId);
        verify(this.walletPersistencePort).persistWallet(walletToPersist);

        assertThat(result).isEqualTo(walletPersisted);
    }

    @Test
    @DisplayName("Throws exception when the balance is not valid")
    void throwExceptionWhenNotValid() throws NotFoundException {

        final Long userId = 1L;
        final Double balance = -10.00;
        final Wallet walletToPersist = mock(Wallet.class);

        when(walletToPersist.getBalance()).thenReturn(balance);

        assertThrows(ApplicationException.class,
                () -> this.createWalletUseCase.createWallet(walletToPersist));

        verify(this.walletPersistencePort, never()).persistWallet(walletToPersist);
        verify(this.userPersistencePort, never()).findUserById(userId);
    }

}