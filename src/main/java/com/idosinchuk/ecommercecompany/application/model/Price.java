package com.idosinchuk.ecommercecompany.application.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import com.idosinchuk.ecommercecompany.domain.exception.DateRequestWrongFormatException;
import com.idosinchuk.ecommercecompany.infraestructure.entity.PriceEntity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
public class Price {

  public static final String DATE_TIME_FORMAT = "yyyy-MM-dd-HH.mm.ss";

  private final OffsetDateTime startDate;

  private final OffsetDateTime endDate;

  private final int priceList;

  private final long productId;

  private final int priority;

  private final BigDecimal price;

  private final String currency;

  private final long id;

  private final long brandId;

  public static Price of(PriceEntity priceEntity) {

    Price priceResponse;

    try {
      priceResponse = Price.builder()
          .id(priceEntity.getId())
          .brandId(priceEntity.getBrandId())
          .startDate(priceEntity.getStartDate())
          .endDate(priceEntity.getEndDate())
          .priceList(priceEntity.getPriceList())
          .productId(priceEntity.getProductId())
          .priority(priceEntity.getPriority())
          .price(priceEntity.getPrice())
          .currency(priceEntity.getCurrency())
          .build();
    } catch (Exception e) {
      throw new ConvertingObjectException(PriceEntity.class.getName(), Price.class.getName());
    }

    return priceResponse;
  }

  public static void isValidDate(final String date) {
    try {
      var formatter = new DateTimeFormatterBuilder()
          .parseCaseInsensitive()
          .append(DateTimeFormatter.ofPattern("yyyy-MM-dd-hh.mm.ss"))
          .toFormatter(Locale.ENGLISH);

      formatter.parse(date);
    } catch (DateTimeParseException e) {
      log.error("The entered format of the date: {} is wrong" + date);
      throw new DateRequestWrongFormatException(date);
    }
  }

  public static OffsetDateTime parseDateTime(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).withZone(ZoneOffset.UTC);
    return OffsetDateTime.parse(date, formatter);
  }
}
