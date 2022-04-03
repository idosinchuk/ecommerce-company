package com.idosinchuk.ecommercecompany.application.use_case;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.port.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FindPriceUseCaseTest {

  @Mock
  PriceRepository priceRepository;

  private FindPriceUseCase findPriceUseCase;

  public FindPriceUseCaseTest() {
  }

  @BeforeEach
  public void setUp() {
    this.findPriceUseCase = new FindPriceUseCase(priceRepository);
  }

  @Test
  void shouldGetTransactionStatus() {

    var productId = 35455L;
    var brandId = 1L;
    var date = "2020-06-16-00.00.00";
    var parsedDate = Price.parseDateTime(date);

    var priceResponse = Price.builder()
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

    when(priceRepository.findByProductIdBrandIdAndStartDate(productId, brandId, parsedDate)).thenReturn(priceResponse);

    findPriceUseCase.findPrice(productId, brandId, date);

    verify(priceRepository, times(1)).findByProductIdBrandIdAndStartDate(productId, brandId, parsedDate);
  }

}
