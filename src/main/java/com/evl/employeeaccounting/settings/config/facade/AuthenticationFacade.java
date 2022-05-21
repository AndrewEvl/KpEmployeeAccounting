package com.evl.employeeaccounting.settings.config.facade;

import org.springframework.security.core.Authentication;

public interface AuthenticationFacade {
    Authentication getAuthentication();
}
