package io.builders.bank.infra.db.mappers;

import io.builders.bank.domain.entities.Transfer;
import io.builders.bank.infra.db.entities.TransferEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface TransferMapper {

    Transfer toTransfer(TransferEntity transferEntity);

    TransferEntity toTransferEntity(Transfer transfer);

    List<Transfer> toTransferList(List<TransferEntity> transferEntity);

}