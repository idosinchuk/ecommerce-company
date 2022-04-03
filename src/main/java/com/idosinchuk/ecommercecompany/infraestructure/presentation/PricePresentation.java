package com.idosinchuk.ecommercecompany.infraestructure.presentation;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PricePresentation {

  @Schema(name = "Brand identifier", description = "Foreign key of the group string.", example = "BRAND1")
  private final long brandId;

  @Schema(name = "End date", description = "End date range in which the indicated rate price applies.", example = "2020-12-31-23.59.59")
  private final OffsetDateTime endDate;

  @Schema(name = "Start date", description = "Start date range in which the indicated rate price applies.", example = "2020-06-14-00.00.00")
  private final OffsetDateTime startDate;

  @JsonIgnore
  @Schema(name = "Price list", description = "Identifier of the applicable price list.", example = "1")
  private final int priceList;

  @Schema(name = "Product identifier", description = "Product code identifier.", example = "35455")
  private final long productId;

  @JsonIgnore
  @Schema(name = "Priority",
      description = "Pricing Disambiguator. If two rates coincide in a range of dates, the one with the highest priority (highest "
          + "numerical value) is applied.",
      example = "1")
  private final int priority;

  @Schema(name = "Price", description = "Final sale price.", example = "35.40")
  private final BigDecimal price;

  @JsonIgnore
  @Schema(name = "Currency", description = "ISO of the currency.", example = "EUR")
  private final String currency;

  public static PricePresentation of(Price priceDTO) {

    PricePresentation pricePresentation;

    try {
      pricePresentation = PricePresentation.builder()
          .brandId(priceDTO.getBrandId())
          .startDate(priceDTO.getStartDate())
          .endDate(priceDTO.getEndDate())
          .priceList(priceDTO.getPriceList())
          .productId(priceDTO.getProductId())
          .priority(priceDTO.getPriority())
          .price(priceDTO.getPrice())
          .currency(priceDTO.getCurrency())
          .build();
    } catch (Exception e) {
      throw new ConvertingObjectException(Price.class.getName(), PricePresentation.class.getName());
    }

    return pricePresentation;
  }
}
