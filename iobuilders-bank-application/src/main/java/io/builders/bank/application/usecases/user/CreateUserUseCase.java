package io.builders.bank.application.usecases.user;

import io.builders.bank.application.ports.in.user.CreateUserPort;
import io.builders.bank.application.ports.out.persistence.UserPersistencePort;
import io.builders.bank.domain.entities.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserUseCase implements CreateUserPort {

    @NonNull
    private UserPersistencePort userPersistencePort;

    @Override
    public User createUser(final User user) {
        return this.userPersistencePort.persistUser(user);
    }

}