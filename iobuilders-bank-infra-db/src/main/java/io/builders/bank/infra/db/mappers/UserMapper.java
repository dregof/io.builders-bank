package io.builders.bank.infra.db.mappers;

import io.builders.bank.domain.entities.User;
import io.builders.bank.infra.db.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}