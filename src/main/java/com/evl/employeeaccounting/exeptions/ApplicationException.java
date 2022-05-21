package com.evl.employeeaccounting.exeptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The class implements exception for the application error to be reported to the user directly.
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ApplicationException extends RuntimeException {

  private static final long serialVersionUID = -6772091593303257397L;

  private int code;

  public ApplicationException() {
  }

  public ApplicationException(int code, String message) {
    super(message);
    this.code = code;
  }
}
