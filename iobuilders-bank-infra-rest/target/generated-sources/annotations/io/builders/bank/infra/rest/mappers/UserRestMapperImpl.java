package io.builders.bank.infra.rest.mappers;

import io.builders.bank.domain.entities.User;
import io.builders.bank.infra.rest.api.model.UserCreationRequestDTO;
import io.builders.bank.infra.rest.api.model.UserInformationDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-11T14:49:54+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.21 (Microsoft)"
)
@Component
public class UserRestMapperImpl implements UserRestMapper {

    @Override
    public User toUser(UserCreationRequestDTO userCreationRequestDTO) {
        if ( userCreationRequestDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( userCreationRequestDTO.getName() );
        user.email( userCreationRequestDTO.getEmail() );
        user.fiscalAddress( userCreationRequestDTO.getFiscalAddress() );
        user.nif( userCreationRequestDTO.getNif() );

        return user.build();
    }

    @Override
    public UserInformationDTO toUserInformationDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserInformationDTO userInformationDTO = new UserInformationDTO();

        userInformationDTO.setName( user.getName() );
        userInformationDTO.setEmail( user.getEmail() );
        userInformationDTO.setFiscalAddress( user.getFiscalAddress() );
        userInformationDTO.setNif( user.getNif() );
        userInformationDTO.setId( user.getId() );

        return userInformationDTO;
    }
}
