package io.builders.bank.infra.rest.mappers;

import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.domain.entities.Deposit;
import io.builders.bank.domain.entities.Transfer;
import io.builders.bank.infra.rest.api.model.DepositRequestDTO;
import io.builders.bank.infra.rest.api.model.TransferRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletCreationRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletInformationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface WalletRestMapper {

    @Mapping(source = "ownerId", target = "userId")
    Wallet toWallet(WalletCreationRequestDTO creationRequestDto);

    @Mapping(source = "userId", target = "ownerId")
    @Mapping(source = "transfers", target = "movements")
    WalletInformationDTO toWalletInformationDto(Wallet wallet);

    Deposit toDeposit(DepositRequestDTO depositRequestDto);

    Transfer toTransfer(TransferRequestDTO transferRequestDto);

}