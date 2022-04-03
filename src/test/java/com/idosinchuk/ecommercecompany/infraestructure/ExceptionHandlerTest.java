package com.idosinchuk.ecommercecompany.infraestructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import com.idosinchuk.ecommercecompany.domain.exception.DateRequestWrongFormatException;
import com.idosinchuk.ecommercecompany.infraestructure.entity.PriceEntity;
import com.idosinchuk.ecommercecompany.infraestructure.exception.ExceptionsHandler;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class ExceptionHandlerTest {

  @Test
  void shouldReturn500InternalErrorWhenThrownConvertingObjectException() {
    var handler = new ExceptionsHandler();
    var response =
        handler.handlerConvertingObjectException(new ConvertingObjectException(PriceEntity.class.getName(), Price.class.getName()));
    assertNotNull(response);
    assertNotNull(response.getBody());
    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
  }

  @Test
  void shouldReturn400BadRequestWhenDateRequestWrongFormatException() {
    var handler = new ExceptionsHandler();
    var response = handler.handlerDateRequestWrongFormatException(new DateRequestWrongFormatException("20.20-06-167-00.00-00"));
    assertNotNull(response);
    assertNotNull(response.getBody());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
}
