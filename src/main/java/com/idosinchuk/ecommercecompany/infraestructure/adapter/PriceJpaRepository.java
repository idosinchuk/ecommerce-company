package com.idosinchuk.ecommercecompany.infraestructure.adapter;

import com.idosinchuk.ecommercecompany.infraestructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;

@Repository
public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long> {

  @Query(
      value = "SELECT * FROM Prices WHERE product_id = :productId AND brand_id = :brandId AND start_date < :parsedDate AND end_date > :parsedDate order by priority DESC limit 1",
      nativeQuery = true)
  Optional<PriceEntity> findByProductIdBrandIdAndStartDate(Long productId, Long brandId, OffsetDateTime parsedDate);
}
