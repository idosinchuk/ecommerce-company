package com.idosinchuk.ecommercecompany.infraestructure.presentation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PricePresentationTest {

  @BeforeEach
  public void setUp() {
  }

  @Test
  void shouldReturnPricePresentation() {

    Price priceDTO = Price.builder()
        .id(1)
        .brandId(1)
        .startDate(Price.parseDateTime("2020-06-14-00.00.00"))
        .endDate(Price.parseDateTime("2020-12-31-23.59.59"))
        .priceList(1)
        .productId(35455)
        .priority(0)
        .price(new BigDecimal("35.50"))
        .currency("EUR")
        .build();

    PricePresentation pricePresentation = PricePresentation.of(priceDTO);

    assertEquals(priceDTO.getBrandId(), pricePresentation.getBrandId());
    assertEquals(priceDTO.getStartDate(), pricePresentation.getStartDate());
    assertEquals(priceDTO.getEndDate(), pricePresentation.getEndDate());
    assertEquals(priceDTO.getPriceList(), pricePresentation.getPriceList());
    assertEquals(priceDTO.getProductId(), pricePresentation.getProductId());
    assertEquals(priceDTO.getPriority(), pricePresentation.getPriority());
    assertEquals(priceDTO.getPrice(), pricePresentation.getPrice());
    assertEquals(priceDTO.getCurrency(), pricePresentation.getCurrency());
  }

  @Test
  void shouldThrowConvertingObjectExceptionWhenOfPricePresentation() {
    assertThrows(ConvertingObjectException.class, () -> PricePresentation.of(null));
  }
}
