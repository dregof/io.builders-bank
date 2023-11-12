package io.builders.bank.infra.db.mappers;

import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.infra.db.entities.WalletEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WalletMapper {

    Wallet toWallet(WalletEntity walletEntity);

    WalletEntity toWalletEntity(Wallet wallet);

}