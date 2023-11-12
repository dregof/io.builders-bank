package io.builders.bank.infra.db.mappers;

import io.builders.bank.domain.entities.Transfer;
import io.builders.bank.infra.db.entities.TransferEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T14:49:46+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.21 (Microsoft)"
)
@Component
public class TransferMapperImpl implements TransferMapper {

    @Override
    public Transfer toTransfer(TransferEntity transferEntity) {
        if ( transferEntity == null ) {
            return null;
        }

        Transfer.TransferBuilder transfer = Transfer.builder();

        transfer.originWalletId( transferEntity.getOriginWalletId() );
        transfer.destinationWalletId( transferEntity.getDestinationWalletId() );
        transfer.amount( transferEntity.getAmount() );

        return transfer.build();
    }

    @Override
    public TransferEntity toTransferEntity(Transfer transfer) {
        if ( transfer == null ) {
            return null;
        }

        TransferEntity.TransferEntityBuilder transferEntity = TransferEntity.builder();

        transferEntity.originWalletId( transfer.getOriginWalletId() );
        transferEntity.destinationWalletId( transfer.getDestinationWalletId() );
        transferEntity.amount( transfer.getAmount() );

        return transferEntity.build();
    }

    @Override
    public List<Transfer> toTransferList(List<TransferEntity> transferEntity) {
        if ( transferEntity == null ) {
            return null;
        }

        List<Transfer> list = new ArrayList<Transfer>( transferEntity.size() );
        for ( TransferEntity transferEntity1 : transferEntity ) {
            list.add( toTransfer( transferEntity1 ) );
        }

        return list;
    }
}
