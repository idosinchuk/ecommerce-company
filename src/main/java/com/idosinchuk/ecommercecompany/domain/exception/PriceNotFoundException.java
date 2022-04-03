package com.idosinchuk.ecommercecompany.domain.exception;

public class PriceNotFoundException extends RuntimeException {

  public PriceNotFoundException(Long productId, Long groupId, String date) {
    super("Price was not found for productId: " + productId + " groupId: " + groupId + " and date: " + date);
  }
}
