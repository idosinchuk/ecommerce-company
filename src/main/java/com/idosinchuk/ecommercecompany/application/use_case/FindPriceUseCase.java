package com.idosinchuk.ecommercecompany.application.use_case;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.port.PriceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class FindPriceUseCase {

  private final PriceRepository priceRepository;

  @Cacheable(cacheNames = "prices", key = "{#productId, #brandId, #date}")
  public Price findPrice(long productId, long brandId, String date) {

    Price.isValidDate(date);
    var parsedDate = Price.parseDateTime(date);

    return priceRepository.findByProductIdBrandIdAndStartDate(productId, brandId, parsedDate);
  }
}
