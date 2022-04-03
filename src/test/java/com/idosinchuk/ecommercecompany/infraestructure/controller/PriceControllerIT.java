package com.idosinchuk.ecommercecompany.infraestructure.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import com.idosinchuk.ecommercecompany.application.model.Price;
import com.idosinchuk.ecommercecompany.application.use_case.FindPriceUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PriceController.class)
class PriceControllerIT {

  private String findPriceUrlEndpoint;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private FindPriceUseCase findPriceUseCase;

  @BeforeEach
  public void setUp() {
    findPriceUrlEndpoint = "http://localhost:8080/price/find";
  }

  @Test
  void findPriceShouldReturn200OkWhenProductIdAndGroupIdAndDateArePresent() throws Exception {

    Mockito.when(findPriceUseCase.findPrice(anyLong(), anyLong(), anyString())).thenReturn(Price.builder()
        .id(1L)
        .brandId(1L)
        .startDate(Price.parseDateTime("2020-06-14-00.00.00"))
        .endDate(Price.parseDateTime("2020-12-31-23.59.59"))
        .priceList(1)
        .productId(35455L)
        .priority(0)
        .price(new BigDecimal("35.50"))
        .currency("EUR")
        .build());

    mockMvc.perform(get(findPriceUrlEndpoint)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .param("productId", "35455")
            .param("brandId", "1")
            .param("date", "2020-06-16-00.00.00"))
        .andExpect(jsonPath("$").exists())
        .andExpect(status().isOk());
  }

}
