package com.evl.employeeaccounting.settings.controllers;

import com.evl.employeeaccounting.exeptions.ApplicationException;
import com.evl.employeeaccounting.settings.config.jwtToken.dto.JwtRequest;
import com.evl.employeeaccounting.settings.config.jwtToken.dto.JwtUserResponse;
import com.evl.employeeaccounting.settings.config.jwtToken.services.authenticateService.IAuthenticateService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin()
@RestController
@AllArgsConstructor
public class AuthenticationController {

    private final IAuthenticateService authenticateService;

    /**
     * Authentication (sign-in)
     */
    @RequestMapping(value = "authenticate", method = POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest request) {
        String login = request.getLogin();
        String password = request.getPassword();
        try {
            JwtUserResponse token = authenticateService.generateToken(login, password);
            return ResponseEntity.ok(token);
        } catch (ApplicationException e) {
            return ResponseEntity
                    .status(e.getCode())
                    .body(e.getMessage());
        }
    }
}
