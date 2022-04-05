package com.idosinchuk.ecommercecompany.infraestructure.adapter;

import java.time.OffsetDateTime;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.port.PriceRepository;
import com.idosinchuk.ecommercecompany.infraestructure.entity.PriceEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {
  
  private final PriceJpaRepository priceJpaRepository;

  @Override
  public Price findByProductIdBrandIdAndStartDate(long productId, long brandId, OffsetDateTime parsedDate) {
    log.debug("Find price in DB by productId {}, brandId {}, date{}", productId, brandId,
        parsedDate);

    var priceEntityOptional = priceJpaRepository.findByProductIdBrandIdAndStartDate(productId, brandId,
        parsedDate);
    var priceEntity = priceEntityOptional.orElse(new PriceEntity());

    log.debug("Received price: from DB for productId: {} brandId: {} and date: {}", priceEntity, brandId,
        parsedDate);
    return Price.of(priceEntity);
  }

}
