package com.evl.employeeaccounting.repositories;

import com.evl.employeeaccounting.entityes.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User> {

    Optional<User> findByLogin (@Param("login") String login);
}
