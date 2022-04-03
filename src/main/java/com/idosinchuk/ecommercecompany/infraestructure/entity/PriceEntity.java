package com.idosinchuk.ecommercecompany.infraestructure.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.domain.exception.ConvertingObjectException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = PriceEntity.PRICES_TABLE_NAME)
public class PriceEntity {

  public static final String PRICES_TABLE_NAME = "PRICES";

  public static final String ID_COLUMN_NAME = "ID";

  public static final String BRAND_ID_COLUMN_NAME = "BRAND_ID";

  public static final String START_DATE_COLUMN_NAME = "START_DATE";

  public static final String END_DATE_COLUMN_NAME = "END_DATE";

  public static final String PRICE_LIST_COLUMN_NAME = "PRICE_LIST";

  public static final String PRODUCT_ID_COLUMN_NAME = "PRODUCT_ID";

  public static final String PRIORITY_COLUMN_NAME = "PRIORITY";

  public static final String PRICE_COLUMN_NAME = "PRICE";

  public static final String CURR_COLUMN_NAME = "CURR";

  @Id
  @Column(name = ID_COLUMN_NAME)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = BRAND_ID_COLUMN_NAME)
  private long brandId;

  @Column(name = START_DATE_COLUMN_NAME)
  private OffsetDateTime startDate;

  @Column(name = END_DATE_COLUMN_NAME)
  private OffsetDateTime endDate;

  @Column(name = PRICE_LIST_COLUMN_NAME)
  private int priceList;

  @Column(name = PRODUCT_ID_COLUMN_NAME)
  private long productId;

  @Column(name = PRIORITY_COLUMN_NAME)
  private int priority;

  @Column(name = PRICE_COLUMN_NAME)
  private BigDecimal price;

  @Column(name = CURR_COLUMN_NAME)
  private String currency;

  public static PriceEntity of(Price priceDTO) {

    PriceEntity priceEntity;

    try {
      priceEntity = PriceEntity.builder()
          .id(priceDTO.getId())
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
      throw new ConvertingObjectException(Price.class.getName(), PriceEntity.class.getName());
    }
    return priceEntity;
  }

}
