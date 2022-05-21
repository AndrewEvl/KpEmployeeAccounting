package com.evl.employeeaccounting.settings.config.jwtToken.services;

import com.evl.employeeaccounting.entityes.User;
import com.evl.employeeaccounting.services.implimentation.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByLogin(login);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь с логином " + login + " не наден");
        } else {
            User user = userOptional.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getLogin(),
                    user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("Role")));
        }
    }
}
