package io.builders.bank.application.usecases.wallet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.out.persistence.TransferPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.domain.entities.Transfer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindWalletByIdUseCaseTest {

    @InjectMocks
    private FindWalletByIdUseCase findWalletByIdUseCase;

    @Mock
    private WalletPersistencePort walletPersistencePort;

    @Mock
    private TransferPersistencePort transferPersistencePort;

    @Test
    @DisplayName("Find a wallet with its movements by its ID successfully")
    void findWalletByIdSuccessfully() throws NotFoundException {

        final Long walletId = 1L;
        final Wallet wallet = mock(Wallet.class);
        final Transfer firstTransfer = mock(Transfer.class);
        final Transfer secondTransfer = mock(Transfer.class);
        final List<Transfer> transfers = List.of(firstTransfer, secondTransfer);

        when(this.walletPersistencePort.findWalletById(walletId)).thenReturn(wallet);
        when(this.transferPersistencePort.findByWalletId(walletId)).thenReturn(transfers);

        final Wallet result = this.findWalletByIdUseCase.findWalletById(walletId);

        verify(this.walletPersistencePort).findWalletById(walletId);
        verify(this.transferPersistencePort).findByWalletId(walletId);

        assertThat(result).isEqualTo(wallet);
    }

    @Test
    @DisplayName("Throw exception when the wallet to find does not exists")
    void throwExceptionWhenNotExists() throws NotFoundException {

        final Long walletId = 1L;

        when(this.walletPersistencePort.findWalletById(walletId)).thenThrow(
                NotFoundException.class);

        assertThrows(ApplicationException.class, () -> this.findWalletByIdUseCase.findWalletById(walletId));

        verify(this.walletPersistencePort).findWalletById(walletId);
        verify(this.transferPersistencePort, never()).findByWalletId(walletId);
    }

}