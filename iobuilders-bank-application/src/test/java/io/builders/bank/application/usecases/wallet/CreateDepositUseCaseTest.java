package io.builders.bank.application.usecases.wallet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.out.persistence.TransferPersistencePort;
import io.builders.bank.application.ports.out.persistence.WalletPersistencePort;
import io.builders.bank.domain.entities.Deposit;
import io.builders.bank.domain.entities.Transfer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateDepositUseCaseTest {

    @InjectMocks
    private CreateDepositUseCase createDepositUseCase;

    @Mock
    private WalletPersistencePort walletPersistencePort;

    @Mock
    private TransferPersistencePort transferPersistencePort;

    @Test
    @DisplayName("Create a new deposit successfully")
    void createDepositSuccessfully() throws NotFoundException {

        final Long walletId = 1L;
        final Double amount = 10.00;
        final Deposit deposit = mock(Deposit.class);

        when(deposit.getAmount()).thenReturn(amount);
        when(deposit.getDestinationWalletId()).thenReturn(walletId);

        this.createDepositUseCase.createDeposit(deposit);

        verify(this.walletPersistencePort).addAmountToWallet(walletId, amount);
        verify(this.transferPersistencePort).persistTransfer(any(Transfer.class));
    }

    @Test
    @DisplayName("Throws exception when the wallet does not exists")
    void throwExceptionWhenWalletNotExists() throws NotFoundException {

        final Long walletId = 1L;
        final Double amount = 10.00;
        final Deposit deposit = mock(Deposit.class);

        when(deposit.getAmount()).thenReturn(amount);
        when(deposit.getDestinationWalletId()).thenReturn(walletId);
        doThrow(NotFoundException.class).when(this.walletPersistencePort)
                .addAmountToWallet(walletId, amount);

        assertThrows(ApplicationException.class, () -> this.createDepositUseCase.createDeposit(deposit));

        verify(this.walletPersistencePort).addAmountToWallet(walletId, amount);
        verify(this.transferPersistencePort, never()).persistTransfer(any(Transfer.class));
    }

    @Test
    @DisplayName("Throws exception when the amount is not valid")
    void throwExceptionWhenNotValid() throws NotFoundException {

        final Long walletId = 1L;
        final Double amount = -10.00;
        final Deposit deposit = mock(Deposit.class);

        when(deposit.getAmount()).thenReturn(amount);

        assertThrows(ApplicationException.class, () -> this.createDepositUseCase.createDeposit(deposit));

        verify(this.walletPersistencePort, never()).addAmountToWallet(walletId, amount);
        verify(this.transferPersistencePort, never()).persistTransfer(any(Transfer.class));
    }
}