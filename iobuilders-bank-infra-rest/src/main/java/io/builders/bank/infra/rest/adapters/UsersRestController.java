package io.builders.bank.infra.rest.adapters;

import io.builders.bank.application.ports.in.user.CreateUserPort;
import io.builders.bank.application.ports.in.user.FindUserByIdPort;
import io.builders.bank.domain.entities.User;
import io.builders.bank.infra.rest.api.UsersApi;
import io.builders.bank.infra.rest.api.model.UserInformationDTO;
import io.builders.bank.infra.rest.api.model.UserCreationRequestDTO;
import io.builders.bank.infra.rest.mappers.UserRestMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UsersRestController implements UsersApi {

    @NonNull
    private UserRestMapper userRestMapper;

    @NonNull
    private CreateUserPort createUserPort;

    @NonNull
    private FindUserByIdPort findUserByIdPort;

    @Override
    public ResponseEntity<UserInformationDTO> createUser(final UserCreationRequestDTO userCreationRequestDTO) {
        final User user = this.createUserPort.createUser(this.userRestMapper.toUser(userCreationRequestDTO));
        return ResponseEntity.ok(this.userRestMapper.toUserInformationDto(user));
    }

    @Override
    public ResponseEntity<UserInformationDTO> findUserById(final Long userId) {
        final User user = this.findUserByIdPort.findUserById(userId);
        return ResponseEntity.ok(this.userRestMapper.toUserInformationDto(user));
    }
}