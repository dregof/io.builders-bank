package io.builders.bank.infra.db.repositories;

import static io.builders.bank.application.exception.Error.NOT_FOUND;

import io.builders.bank.application.exception.NotFoundException;
import io.builders.bank.infra.db.entities.UserEntity;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final AtomicLong counter = new AtomicLong(0L);

    private final ConcurrentHashMap<Long, UserEntity> users = new ConcurrentHashMap<>();

    public UserEntity persistUser(final UserEntity userEntity) {
        userEntity.setId(this.counter.addAndGet(1));
        this.users.put(userEntity.getId(), userEntity);
        return userEntity;
    }

    public UserEntity findById(final Long userId) throws NotFoundException {

        final UserEntity userEntity = this.users.get(userId);

        if (userEntity == null) {
            throw new NotFoundException(NOT_FOUND,
                    StringUtils.join("The user with ID ", userId, " could not be found"));
        }

        return userEntity;
    }

}