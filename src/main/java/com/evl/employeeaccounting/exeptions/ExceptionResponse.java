package com.evl.employeeaccounting.exeptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class ExceptionResponse {

    private String message;
}
