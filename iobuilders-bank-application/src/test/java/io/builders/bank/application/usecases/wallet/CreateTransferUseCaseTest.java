package io.builders.bank.application.usecases.wallet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.out.persistence.TransferPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Transfer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateTransferUseCaseTest {

    @InjectMocks
    private CreateTransferUseCase createTransferUseCase;

    @Mock
    private WalletPersistencePort walletPersistencePort;

    @Mock
    private TransferPersistencePort transferPersistencePort;

    @Test
    @DisplayName("Create a new transfer successfully")
    void createTransferSuccessfully() throws NotFoundException {

        final Double amount = 10.00;
        final Long originWalletId = 1L;
        final Long destinationWalletId = 2L;
        final Transfer transfer = mock(Transfer.class);

        when(transfer.getAmount()).thenReturn(amount);
        when(transfer.getOriginWalletId()).thenReturn(originWalletId);
        when(transfer.getDestinationWalletId()).thenReturn(destinationWalletId);

        this.createTransferUseCase.createTransfer(transfer);

        verify(this.transferPersistencePort).persistTransfer(transfer);
        verify(this.walletPersistencePort).addAmountToWallet(destinationWalletId, amount);
        verify(this.walletPersistencePort).withdrawAmountFromWallet(originWalletId, amount);
    }

    @Test
    @DisplayName("Throws exception when the origin wallet does not exists")
    void throwExceptionWhenWalletNotExists() throws NotFoundException {

        final Double amount = 10.00;
        final Long originWalletId = 1L;
        final Long destinationWalletId = 2L;
        final Transfer transfer = mock(Transfer.class);

        when(transfer.getAmount()).thenReturn(amount);
        when(transfer.getDestinationWalletId()).thenReturn(destinationWalletId);
        doThrow(NotFoundException.class).when(this.walletPersistencePort)
                .addAmountToWallet(destinationWalletId, amount);

        assertThrows(ApplicationException.class, () -> this.createTransferUseCase.createTransfer(transfer));

        verify(this.transferPersistencePort).persistTransfer(transfer);
        verify(this.walletPersistencePort).addAmountToWallet(destinationWalletId, amount);
        verify(this.walletPersistencePort, never()).withdrawAmountFromWallet(originWalletId, amount);
    }

    @Test
    @DisplayName("Throws exception when the amount is not valid")
    void throwExceptionWhenNotValid() throws NotFoundException {

        final Double amount = -10.00;
        final Long originWalletId = 1L;
        final Long destinationWalletId = 2L;
        final Transfer transfer = mock(Transfer.class);

        when(transfer.getAmount()).thenReturn(amount);

        assertThrows(ApplicationException.class, () -> this.createTransferUseCase.createTransfer(transfer));

        verify(this.transferPersistencePort, never()).persistTransfer(transfer);
        verify(this.walletPersistencePort, never()).addAmountToWallet(destinationWalletId, amount);
        verify(this.walletPersistencePort, never()).withdrawAmountFromWallet(originWalletId, amount);
    }

}