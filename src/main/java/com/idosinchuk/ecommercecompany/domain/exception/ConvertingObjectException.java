package com.idosinchuk.ecommercecompany.domain.exception;

public class ConvertingObjectException extends RuntimeException {

  public ConvertingObjectException(String inicialObject, String finalObject) {
    super("There was an error converting object: " + inicialObject + " to " + finalObject);
  }
}
