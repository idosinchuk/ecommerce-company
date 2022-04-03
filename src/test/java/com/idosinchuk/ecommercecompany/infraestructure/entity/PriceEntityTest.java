package com.idosinchuk.ecommercecompany.infraestructure.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriceEntityTest {

  @BeforeEach
  public void setUp() {
  }

  @Test
  void shouldReturnPriceEntity() {

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

    PriceEntity priceEntity = PriceEntity.of(priceDTO);

    assertEquals(priceDTO.getBrandId(), priceEntity.getBrandId());
    assertEquals(priceDTO.getStartDate(), priceEntity.getStartDate());
    assertEquals(priceDTO.getEndDate(), priceEntity.getEndDate());
    assertEquals(priceDTO.getPriceList(), priceEntity.getPriceList());
    assertEquals(priceDTO.getProductId(), priceEntity.getProductId());
    assertEquals(priceDTO.getPriority(), priceEntity.getPriority());
    assertEquals(priceDTO.getPrice(), priceEntity.getPrice());
    assertEquals(priceDTO.getCurrency(), priceEntity.getCurrency());
  }

  @Test
  void shouldThrowRuntimeException() {
    assertThrows(ConvertingObjectException.class, () -> PriceEntity.of((null)));
  }

}
