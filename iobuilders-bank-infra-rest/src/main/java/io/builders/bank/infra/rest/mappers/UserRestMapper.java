package io.builders.bank.infra.rest.mappers;

import io.builders.bank.domain.entities.User;
import io.builders.bank.infra.rest.api.model.UserInformationDTO;
import io.builders.bank.infra.rest.api.model.UserCreationRequestDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserRestMapper {

    User toUser(UserCreationRequestDTO userCreationRequestDTO);

    UserInformationDTO toUserInformationDto(User user);

}