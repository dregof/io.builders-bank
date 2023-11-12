package io.builders.bank.infra.db.adapters;

import io.builders.bank.application.ports.out.persistence.TransferPersistencePort;
import io.builders.bank.domain.entities.Transfer;
import io.builders.bank.infra.db.mappers.TransferMapper;
import io.builders.bank.infra.db.repositories.TransferRepository;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransferPersistenceAdapter implements TransferPersistencePort {

    @NonNull
    private TransferMapper transferMapper;

    @NonNull
    private TransferRepository transferRepository;

    @Override
    public void persistTransfer(final Transfer transfer) {
        this.transferRepository.persistTransfer(this.transferMapper.toTransferEntity(transfer));
    }

    @Override
    public List<Transfer> findByWalletId(final Long walletId) {
        return this.transferMapper.toTransferList(this.transferRepository.findTransfersByWalletId(walletId));
    }

}