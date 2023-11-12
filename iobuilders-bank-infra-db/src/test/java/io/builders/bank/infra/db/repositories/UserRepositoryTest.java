package io.builders.bank.infra.db.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.infra.db.entities.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @InjectMocks
    private UserRepository userRepository;

    @Test
    @DisplayName("Persist a new user and find it by its identifier")
    void persistAndFindSuccessfully() throws NotFoundException {

        final String name = "Rafael Nadal";
        final String email = "rafa.nadal@gmail.com";
        final UserEntity user = UserEntity.builder().name(name).email(email).build();

        final UserEntity userPersisted = this.userRepository.persistUser(user);

        assertThat(userPersisted.getId()).isEqualTo(1L);

        final UserEntity userFound = this.userRepository.findById(userPersisted.getId());

        assertThat(userFound.getId()).isEqualTo(1L);
        assertThat(userFound.getName()).isEqualTo(name);
        assertThat(userFound.getEmail()).isEqualTo(email);
    }

    @Test
    @DisplayName("Throws exception when the user does not exists")
    void throwExceptionWhenNotExists() {
        assertThrows(NotFoundException.class, () -> this.userRepository.findById(1L));
    }

}