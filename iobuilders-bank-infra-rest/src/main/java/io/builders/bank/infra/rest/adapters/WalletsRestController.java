package io.builders.bank.infra.rest.adapters;

import io.builders.bank.application.ports.in.wallet.CreateDepositPort;
import io.builders.bank.application.ports.in.wallet.CreateTransferPort;
import io.builders.bank.application.ports.in.wallet.CreateWalletPort;
import io.builders.bank.application.ports.in.wallet.FindWalletByIdPort;
import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.infra.rest.api.WalletsApi;
import io.builders.bank.infra.rest.api.model.DepositRequestDTO;
import io.builders.bank.infra.rest.api.model.TransferRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletCreationRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletInformationDTO;
import io.builders.bank.infra.rest.mappers.WalletRestMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WalletsRestController implements WalletsApi {

    @NonNull
    private WalletRestMapper walletRestMapper;

    @NonNull
    private CreateWalletPort createWalletPort;

    @NonNull
    private CreateDepositPort createDepositPort;

    @NonNull
    private CreateTransferPort createTransferPort;

    @NonNull
    private FindWalletByIdPort findWalletByIdPort;

    @Override
    public ResponseEntity<WalletInformationDTO> createWallet(final WalletCreationRequestDTO walletCreationRequestDTO) {
        final Wallet wallet = this.createWalletPort.createWallet(
                this.walletRestMapper.toWallet(walletCreationRequestDTO));
        return ResponseEntity.ok(this.walletRestMapper.toWalletInformationDto(wallet));
    }

    @Override
    public ResponseEntity<WalletInformationDTO> findWalletById(final Long walletId) {
        final Wallet wallet = this.findWalletByIdPort.findWalletById(walletId);
        return ResponseEntity.ok(this.walletRestMapper.toWalletInformationDto(wallet));
    }

    @Override
    public ResponseEntity<Void> createDeposit(final DepositRequestDTO depositRequestDto) {
        this.createDepositPort.createDeposit(this.walletRestMapper.toDeposit(depositRequestDto));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> createTransference(final TransferRequestDTO transferRequestDto) {
        this.createTransferPort.createTransfer(this.walletRestMapper.toTransfer(transferRequestDto));
        return ResponseEntity.ok().build();
    }

}