package io.builders.bank.application.ports.in.user;

import io.builders.bank.domain.entities.User;

public interface CreateUserPort {

  /**
   * Creates the user with the received information.
   *
   * @param user The user information to create a new one.
   * @return The created user.
   */
  User createUser(User user);

}
