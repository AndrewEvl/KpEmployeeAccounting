package com.evl.employeeaccounting.settings.config.jwtToken.services.authenticateService;

import com.evl.employeeaccounting.settings.config.jwtToken.dto.JwtUserResponse;

public interface IAuthenticateService {

    JwtUserResponse generateToken(String login, String password);

}
