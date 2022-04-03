package com.idosinchuk.ecommercecompany.domain.port;

import java.time.OffsetDateTime;

import com.idosinchuk.ecommercecompany.application.model.Price;

public interface PriceRepository {

  Price findByProductIdBrandIdAndStartDate(long productId, long brandId, OffsetDateTime date);
}
