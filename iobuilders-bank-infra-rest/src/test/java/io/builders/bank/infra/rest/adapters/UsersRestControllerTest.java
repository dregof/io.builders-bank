package io.builders.bank.infra.rest.adapters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import io.builders.bank.application.ports.in.user.CreateUserPort;
import io.builders.bank.application.ports.in.user.FindUserByIdPort;
import io.builders.bank.domain.entities.User;
import io.builders.bank.infra.rest.api.model.UserInformationDTO;
import io.builders.bank.infra.rest.api.model.UserCreationRequestDTO;
import io.builders.bank.infra.rest.mappers.UserRestMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class UsersRestControllerTest {

    @InjectMocks
    private UsersRestController usersRestController;

    @Mock
    private UserRestMapper userRestMapper;

    @Mock
    private CreateUserPort createUserPort;

    @Mock
    private FindUserByIdPort findUserByIdPort;

    @Test
    @DisplayName("Create a new user successfully")
    void createUserSuccessfully() {

        final User userCreated = mock(User.class);
        final User userToCreate = mock(User.class);
        final UserInformationDTO responseDto = mock(UserInformationDTO.class);
        final UserCreationRequestDTO requestDto = mock(UserCreationRequestDTO.class);

        when(this.userRestMapper.toUser(requestDto)).thenReturn(userToCreate);
        when(this.createUserPort.createUser(userToCreate)).thenReturn(userCreated);
        when(this.userRestMapper.toUserInformationDto(userCreated)).thenReturn(responseDto);

        final ResponseEntity<UserInformationDTO> response = this.usersRestController.createUser(
                requestDto);

        verify(this.userRestMapper).toUser(requestDto);
        verify(this.createUserPort).createUser(userToCreate);
        verify(this.userRestMapper).toUserInformationDto(userCreated);

        assertThat(response.getStatusCode()).isEqualTo(OK);
        assertThat(response.getBody()).isEqualTo(responseDto);
    }

    @Test
    @DisplayName("Find a user by its identifier successfully")
    void findUserByIdSuccessfully() {

        final Long userId = 1L;
        final User user = mock(User.class);
        final UserInformationDTO responseDto = mock(UserInformationDTO.class);

        when(this.userRestMapper.toUserInformationDto(user)).thenReturn(responseDto);
        when(this.findUserByIdPort.findUserById(userId)).thenReturn(user);

        final ResponseEntity<UserInformationDTO> response = this.usersRestController.findUserById(
                userId);

        verify(this.findUserByIdPort).findUserById(userId);
        verify(this.userRestMapper).toUserInformationDto(user);

        assertThat(response.getStatusCode()).isEqualTo(OK);
        assertThat(response.getBody()).isEqualTo(responseDto);
    }

}