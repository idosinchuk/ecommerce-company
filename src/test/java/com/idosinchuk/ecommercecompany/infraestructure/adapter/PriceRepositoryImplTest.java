package com.idosinchuk.ecommercecompany.infraestructure.adapter;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.infraestructure.entity.PriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PriceRepositoryImplTest {

  @Mock
  PriceJpaRepository priceJpaRepository;

  private PriceRepositoryImpl priceRepositoryImpl;

  public PriceRepositoryImplTest() {
  }

  @BeforeEach
  public void setUp() {
    this.priceRepositoryImpl = new PriceRepositoryImpl(priceJpaRepository);
  }

  @Test
  void shouldFindPrice() {

    var productId = 35455L;
    var brandId = 1L;
    var date = "2020-06-16-00.00.00";
    var parsedDate = Price.parseDateTime(date);

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

    when(priceJpaRepository.findByProductIdBrandIdAndStartDate(productId, brandId, parsedDate)).thenReturn(Optional.of(priceEntity));

    priceRepositoryImpl.findByProductIdBrandIdAndStartDate(productId, brandId, parsedDate);

    verify(priceJpaRepository, times(1)).findByProductIdBrandIdAndStartDate(productId, brandId, parsedDate);
  }

}
