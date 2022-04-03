package com.idosinchuk.ecommercecompany;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootTest
@EnableCaching
class EcommerceCompanyApplicationTests {

  @Test
  void contextLoads() {
    EcommerceCompanyApplication.main(new String[]{});
  }

}