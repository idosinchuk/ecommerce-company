package com.idosinchuk.ecommercecompany.infraestructure.controller;

import com.idosinchuk.ecommercecompany.application.use_case.FindPriceUseCase;
import com.idosinchuk.ecommercecompany.infraestructure.presentation.PricePresentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Price Controller", description = "Controller for Prices operations.")
@RestController
@Slf4j
@RequestMapping(value = {"/price"})
@RequiredArgsConstructor
public class PriceController{

  private final FindPriceUseCase findPriceUseCase;

  @Operation(description = "This endpoint, will return information price by productId, brandId and date.")
  @ResponseBody
  @GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PricePresentation> findPrice(
      @RequestParam() long productId,
      @RequestParam() long brandId, @RequestParam() String date
  ) {

    log.debug("Starts find price endpoint with date {}, productId{} and brandId {}", productId, brandId, date);

    var priceDTO = findPriceUseCase.findPrice(productId, brandId, date);

    var pricePresentation = PricePresentation.of(priceDTO);

    log.debug("Ends findPrice endpoint successfully: {}", pricePresentation);

    return ResponseEntity.ok().body(pricePresentation);

  }
}
