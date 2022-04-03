package com.idosinchuk.ecommercecompany.application.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import com.idosinchuk.ecommercecompany.domain.exception.DateRequestWrongFormatException;
import com.idosinchuk.ecommercecompany.infraestructure.entity.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriceResponseTest {

  @BeforeEach
  public void setUp() {
  }

  @Test
  void shouldReturnPriceDTO() {

    var priceEntity = PriceEntity.builder()
        .id(1L)
        .brandId(1L)
        .startDate(Price.parseDateTime("2020-06-14-00.00.00"))
        .endDate(Price.parseDateTime("2020-12-31-23.59.59"))
        .priceList(1)
        .productId(35455L)
        .priority(0)
        .price(new BigDecimal("35.50"))
        .currency("EUR")
        .build();

    var priceDTO = Price.of(priceEntity);

    assertEquals(priceEntity.getBrandId(), priceDTO.getBrandId());
    assertEquals(priceEntity.getStartDate(), priceDTO.getStartDate());
    assertEquals(priceEntity.getEndDate(), priceDTO.getEndDate());
    assertEquals(priceEntity.getPriceList(), priceDTO.getPriceList());
    assertEquals(priceEntity.getProductId(), priceDTO.getProductId());
    assertEquals(priceEntity.getPriority(), priceDTO.getPriority());
    assertEquals(priceEntity.getPrice(), priceDTO.getPrice());
    assertEquals(priceEntity.getCurrency(), priceDTO.getCurrency());
  }

  @Test
  void shouldThrowConvertingObjectExceptionWhenOfPriceEntity() {
    assertThrows(ConvertingObjectException.class, () -> Price.of(null));
  }

  @Test
  void shouldThrowConvertingObjectExceptionWhenDateFormatIsWrong() {
    var date = "20.20-06-167-00.00-00";
    assertThrows(DateRequestWrongFormatException.class, () -> Price.isValidDate(date));
  }
}
