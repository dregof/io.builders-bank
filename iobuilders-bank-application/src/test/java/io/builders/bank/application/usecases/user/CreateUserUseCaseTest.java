package io.builders.bank.application.usecases.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.builders.bank.application.ports.out.persistence.UserPersistencePort;
import io.builders.bank.domain.entities.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {

    @InjectMocks
    private CreateUserUseCase createUserUseCase;

    @Mock
    private UserPersistencePort userPersistencePort;

    @Test
    @DisplayName("Create a new user successfully")
    void createUserSuccessfully() {

        final User userToPersist = mock(User.class);
        final User userPersisted = mock(User.class);

        when(this.userPersistencePort.persistUser(userToPersist)).thenReturn(userPersisted);

        final User result = this.createUserUseCase.createUser(userToPersist);

        verify(this.userPersistencePort).persistUser(userToPersist);

        assertThat(result).isEqualTo(userPersisted);
    }

}