package com.evl.employeeaccounting.settings.config.jwtToken.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@Accessors(chain = true)
public class JwtUserResponse  implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private final String login;
    private final Integer role;
    private final Long id;
}
