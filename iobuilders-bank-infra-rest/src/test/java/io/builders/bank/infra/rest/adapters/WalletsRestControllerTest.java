package io.builders.bank.infra.rest.adapters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import io.builders.bank.application.ports.in.wallet.CreateDepositPort;
import io.builders.bank.application.ports.in.wallet.CreateTransferPort;
import io.builders.bank.application.ports.in.wallet.CreateWalletPort;
import io.builders.bank.application.ports.in.wallet.FindWalletByIdPort;
import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.domain.entities.Deposit;
import io.builders.bank.domain.entities.Transfer;
import io.builders.bank.infra.rest.api.model.DepositRequestDTO;
import io.builders.bank.infra.rest.api.model.TransferRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletCreationRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletInformationDTO;
import io.builders.bank.infra.rest.mappers.WalletRestMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class WalletsRestControllerTest {

    @InjectMocks
    private WalletsRestController walletsRestController;

    @Mock
    private WalletRestMapper walletRestMapper;

    @Mock
    private CreateWalletPort createWalletPort;

    @Mock
    private CreateDepositPort createDepositPort;

    @Mock
    private CreateTransferPort createTransferPort;

    @Mock
    private FindWalletByIdPort findWalletByIdPort;

    @Test
    @DisplayName("Create a new wallet successfully")
    void createWalletSuccessfully() {

        final Wallet walletCreated = mock(Wallet.class);
        final Wallet walletToCreate = mock(Wallet.class);
        final WalletInformationDTO responseDto = mock(WalletInformationDTO.class);
        final WalletCreationRequestDTO requestDto = mock(WalletCreationRequestDTO.class);

        when(this.walletRestMapper.toWallet(requestDto)).thenReturn(walletToCreate);
        when(this.createWalletPort.createWallet(walletToCreate)).thenReturn(walletCreated);
        when(this.walletRestMapper.toWalletInformationDto(walletCreated)).thenReturn(responseDto);

        final ResponseEntity<WalletInformationDTO> response = this.walletsRestController.createWallet(
                requestDto);

        verify(this.walletRestMapper).toWallet(requestDto);
        verify(this.createWalletPort).createWallet(walletToCreate);
        verify(this.walletRestMapper).toWalletInformationDto(walletCreated);

        assertThat(response.getStatusCode()).isEqualTo(OK);
        assertThat(response.getBody()).isEqualTo(responseDto);
    }

    @Test
    @DisplayName("Find a wallet by its identifier")
    void findWalletByIdSuccessfully() {

        final Long walletId = 1L;
        final Wallet wallet = mock(Wallet.class);
        final WalletInformationDTO responseDto = mock(WalletInformationDTO.class);

        when(this.walletRestMapper.toWalletInformationDto(wallet)).thenReturn(responseDto);
        when(this.findWalletByIdPort.findWalletById(walletId)).thenReturn(wallet);

        final ResponseEntity<WalletInformationDTO> response = this.walletsRestController.findWalletById(
                walletId);

        verify(this.findWalletByIdPort).findWalletById(walletId);
        verify(this.walletRestMapper).toWalletInformationDto(wallet);

        assertThat(response.getStatusCode()).isEqualTo(OK);
        assertThat(response.getBody()).isEqualTo(responseDto);
    }

    @Test
    @DisplayName("Create a new deposit successfully")
    void createDepositSuccessfully() {

        final Deposit deposit = mock(Deposit.class);
        final DepositRequestDTO requestDto = mock(DepositRequestDTO.class);

        when(this.walletRestMapper.toDeposit(requestDto)).thenReturn(deposit);

        final ResponseEntity<Void> response = this.walletsRestController.createDeposit(requestDto);

        verify(this.walletRestMapper).toDeposit(requestDto);
        verify(this.createDepositPort).createDeposit(deposit);

        assertThat(response.getStatusCode()).isEqualTo(OK);
    }

    @Test
    @DisplayName("Create a new transfer successfully")
    void createTransferenceSuccessfully() {

        final Transfer transfer = mock(Transfer.class);
        final TransferRequestDTO requestDto = mock(TransferRequestDTO.class);

        when(this.walletRestMapper.toTransfer(requestDto)).thenReturn(transfer);

        final ResponseEntity<Void> response = this.walletsRestController.createTransference(requestDto);

        verify(this.walletRestMapper).toTransfer(requestDto);
        verify(this.createTransferPort).createTransfer(transfer);

        assertThat(response.getStatusCode()).isEqualTo(OK);
    }

}