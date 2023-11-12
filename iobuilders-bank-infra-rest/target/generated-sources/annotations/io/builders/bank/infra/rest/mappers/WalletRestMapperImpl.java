package io.builders.bank.infra.rest.mappers;

import io.builders.bank.domain.entities.Deposit;
import io.builders.bank.domain.entities.Transfer;
import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.infra.rest.api.model.DepositRequestDTO;
import io.builders.bank.infra.rest.api.model.TransferRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletCreationRequestDTO;
import io.builders.bank.infra.rest.api.model.WalletInformationDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T14:49:54+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.21 (Microsoft)"
)
@Component
public class WalletRestMapperImpl implements WalletRestMapper {

    @Override
    public Wallet toWallet(WalletCreationRequestDTO creationRequestDto) {
        if ( creationRequestDto == null ) {
            return null;
        }

        Wallet.WalletBuilder wallet = Wallet.builder();

        wallet.userId( creationRequestDto.getOwnerId() );
        wallet.balance( creationRequestDto.getBalance() );

        return wallet.build();
    }

    @Override
    public WalletInformationDTO toWalletInformationDto(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        WalletInformationDTO walletInformationDTO = new WalletInformationDTO();

        walletInformationDTO.setOwnerId( wallet.getUserId() );
        walletInformationDTO.setMovements( transferListToTransferRequestDTOList( wallet.getTransfers() ) );
        walletInformationDTO.setBalance( wallet.getBalance() );
        walletInformationDTO.setId( wallet.getId() );

        return walletInformationDTO;
    }

    @Override
    public Deposit toDeposit(DepositRequestDTO depositRequestDto) {
        if ( depositRequestDto == null ) {
            return null;
        }

        Deposit.DepositBuilder deposit = Deposit.builder();

        deposit.destinationWalletId( depositRequestDto.getDestinationWalletId() );
        deposit.amount( depositRequestDto.getAmount() );

        return deposit.build();
    }

    @Override
    public Transfer toTransfer(TransferRequestDTO transferRequestDto) {
        if ( transferRequestDto == null ) {
            return null;
        }

        Transfer.TransferBuilder transfer = Transfer.builder();

        transfer.originWalletId( transferRequestDto.getOriginWalletId() );
        transfer.destinationWalletId( transferRequestDto.getDestinationWalletId() );
        transfer.amount( transferRequestDto.getAmount() );

        return transfer.build();
    }

    protected TransferRequestDTO transferToTransferRequestDTO(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        TransferRequestDTO transferRequestDTO = new TransferRequestDTO();

        transferRequestDTO.setOriginWalletId( transfer.getOriginWalletId() );
        transferRequestDTO.setDestinationWalletId( transfer.getDestinationWalletId() );
        transferRequestDTO.setAmount( transfer.getAmount() );

        return transferRequestDTO;
    }

    protected List<TransferRequestDTO> transferListToTransferRequestDTOList(List<Transfer> list) {
        if ( list == null ) {
            return null;
        }

        List<TransferRequestDTO> list1 = new ArrayList<TransferRequestDTO>( list.size() );
        for ( Transfer transfer : list ) {
            list1.add( transferToTransferRequestDTO( transfer ) );
        }

        return list1;
    }
}
