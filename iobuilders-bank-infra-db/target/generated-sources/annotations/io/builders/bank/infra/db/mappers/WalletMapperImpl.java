package io.builders.bank.infra.db.mappers;

import io.builders.bank.domain.entities.Wallet;
import io.builders.bank.infra.db.entities.WalletEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T14:49:46+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.21 (Microsoft)"
)
@Component
public class WalletMapperImpl implements WalletMapper {

    @Override
    public Wallet toWallet(WalletEntity walletEntity) {
        if ( walletEntity == null ) {
            return null;
        }

        Wallet.WalletBuilder wallet = Wallet.builder();

        wallet.id( walletEntity.getId() );
        wallet.userId( walletEntity.getUserId() );
        wallet.balance( walletEntity.getBalance() );

        return wallet.build();
    }

    @Override
    public WalletEntity toWalletEntity(Wallet wallet) {
        if ( wallet == null ) {
            return null;
        }

        WalletEntity.WalletEntityBuilder walletEntity = WalletEntity.builder();

        walletEntity.id( wallet.getId() );
        walletEntity.userId( wallet.getUserId() );
        walletEntity.balance( wallet.getBalance() );

        return walletEntity.build();
    }
}
