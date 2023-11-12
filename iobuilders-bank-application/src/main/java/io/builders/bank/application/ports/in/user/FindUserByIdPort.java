package io.builders.bank.application.ports.in.user;

import io.builders.bank.domain.entities.User;

public interface FindUserByIdPort {

  /**
   * Finds a user by its identifier.
   *
   * @param userId Unique identifier of the user to search by.
   * @return The user found.
   */
  User findUserById(Long userId);

}
