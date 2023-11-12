package io.builders.bank.application.usecases.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.out.persistence.UserPersistencePort;
import io.builders.bank.domain.entities.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindUserByIdUseCaseTest {

    @InjectMocks
    private FindUserByIdUseCase findUserByIdUseCase;

    @Mock
    private UserPersistencePort userPersistencePort;

    @Test
    @DisplayName("Find a user by its ID successfully")
    void findUserByIdSuccessfully() throws NotFoundException {

        final Long userId = 1L;
        final User user = mock(User.class);

        when(this.userPersistencePort.findUserById(userId)).thenReturn(user);

        final User result = this.findUserByIdUseCase.findUserById(userId);

        verify(this.userPersistencePort).findUserById(userId);

        assertThat(result).isEqualTo(user);
    }

    @Test
    @DisplayName("Throw exception when the user to find does not exists")
    void throwExceptionWhenNotExists() throws NotFoundException {

        final Long userId = 1L;

        when(this.userPersistencePort.findUserById(userId)).thenThrow(NotFoundException.class);

        assertThrows(ApplicationException.class, () -> this.findUserByIdUseCase.findUserById(userId));

        verify(this.userPersistencePort).findUserById(userId);
    }

}