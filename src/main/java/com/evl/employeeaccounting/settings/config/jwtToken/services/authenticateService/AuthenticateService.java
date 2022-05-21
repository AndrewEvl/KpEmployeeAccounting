package com.evl.employeeaccounting.settings.config.jwtToken.services.authenticateService;

import com.evl.employeeaccounting.entityes.User;
import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.services.implimentation.UserService;
import com.evl.employeeaccounting.settings.config.jwtToken.dto.JwtUserResponse;
import com.evl.employeeaccounting.settings.config.jwtToken.services.JwtUserDetailsService;
import com.evl.employeeaccounting.settings.config.jwtToken.util.JwtTokenUtil;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticateService implements IAuthenticateService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    private final UserService userService;

    @Override
    public JwtUserResponse generateToken(@NotBlank String login, @NotBlank String password) {

        try {
            authenticate(login, password);
        } catch (Exception e) {
            throw new ApplicationException(HttpStatus.UNAUTHORIZED.value(), "Пользователь не найден");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        String token = jwtTokenUtil.generateToken(userDetails);
        Optional<User> userOptional = userService.findByLogin(login);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return JwtUserResponse
                    .builder()
                    .token(token)
                    .login(user.getLogin())
                    .id(user.getId())
                    .build();
        } else {
            throw new ApplicationException(HttpStatus.UNAUTHORIZED.value(), "Пользователь не найден");
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
