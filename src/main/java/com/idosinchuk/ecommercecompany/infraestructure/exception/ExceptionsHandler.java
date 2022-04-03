package com.idosinchuk.ecommercecompany.infraestructure.exception;

import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import com.idosinchuk.ecommercecompany.domain.exception.DateRequestWrongFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {

  public static final String MESSAGE = "Message";

  @ExceptionHandler(value = ConvertingObjectException.class)
  public ResponseEntity<Object> handlerConvertingObjectException(ConvertingObjectException e) {

    Map<String, Object> errors = new HashMap<>();
    errors.put(MESSAGE, e.getMessage());

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
  }

  @ExceptionHandler(value = DateRequestWrongFormatException.class)
  public ResponseEntity<Object> handlerDateRequestWrongFormatException(DateRequestWrongFormatException e) {

    Map<String, Object> errors = new HashMap<>();
    errors.put(MESSAGE, e.getMessage());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }
}
