package io.builders.bank.infra.db.adapters;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.application.ports.out.persistence.UserPersistencePort;
import io.builders.bank.domain.entities.User;
import io.builders.bank.infra.db.entities.UserEntity;
import io.builders.bank.infra.db.mappers.UserMapper;
import io.builders.bank.infra.db.repositories.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    @NonNull
    private UserMapper userMapper;

    @NonNull
    private UserRepository userRepository;

    @Override
    public User persistUser(final User user) {
        final UserEntity userEntity = this.userRepository.persistUser(this.userMapper.toUserEntity(user));
        return this.userMapper.toUser(userEntity);
    }

    @Override
    public User findUserById(final Long userId) throws NotFoundException {
        return this.userMapper.toUser(this.userRepository.findById(userId));
    }

}