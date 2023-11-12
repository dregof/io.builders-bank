package io.builders.bank.infra.db.mappers;

import io.builders.bank.domain.entities.User;
import io.builders.bank.infra.db.entities.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T14:49:46+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.21 (Microsoft)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userEntity.getId() );
        user.name( userEntity.getName() );
        user.email( userEntity.getEmail() );
        user.fiscalAddress( userEntity.getFiscalAddress() );
        user.nif( userEntity.getNif() );

        return user.build();
    }

    @Override
    public UserEntity toUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.id( user.getId() );
        userEntity.name( user.getName() );
        userEntity.email( user.getEmail() );
        userEntity.fiscalAddress( user.getFiscalAddress() );
        userEntity.nif( user.getNif() );

        return userEntity.build();
    }
}
