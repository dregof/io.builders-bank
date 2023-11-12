package io.builders.bank.application.usecases.user;

import io.builders.bank.application.exception.ApplicationException;
import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.in.user.FindUserByIdPort;
import io.builders.bank.application.ports.out.persistence.UserPersistencePort;
import io.builders.bank.domain.entities.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindUserByIdUseCase implements FindUserByIdPort {

    @NonNull
    private UserPersistencePort userPersistencePort;

    @Override
    public User findUserById(final Long userId) {
        try {
            return this.userPersistencePort.findUserById(userId);
        } catch (final NotFoundException exception) {
            log.error(exception.getMessage(), exception);
            throw new ApplicationException(exception.getErrorCode(), exception.getMessage());
        }
    }

}