package io.builders.bank.application.ports.out.persistence;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.domain.entities.User;

public interface UserPersistencePort {

    /**
     * Persists a new user with the information received.
     *
     * @param user Information of the user to persist.
     * @return The user created.
     */
    User persistUser(User user);

    /**
     * Finds a user by its identifier.
     *
     * @param userId Unique identifier of the user to search by.
     * @return User found.
     */
    User findUserById(Long userId) throws NotFoundException;

}