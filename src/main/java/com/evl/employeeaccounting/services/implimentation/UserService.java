package com.evl.employeeaccounting.services.implimentation;

import com.evl.employeeaccounting.entityes.User;
import com.evl.employeeaccounting.repositories.UserRepository;
import com.evl.employeeaccounting.services.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService extends AbstractService<User, UserRepository> {

    public UserService(UserRepository repository) {
        super(repository);
    }

    public Optional<User> findByLogin (String login){
        return repository.findByLogin(login);
    }
}
