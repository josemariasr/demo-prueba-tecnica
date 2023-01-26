package com.prueba.tecnica.app.controllers;

import com.prueba.tecnica.app.models.dto.PriceDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PriceRestControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    void testFindByDateAndProductAndBrand_1() {

        client.get().uri("/api/prices?date=2020-06-14 10:00:00&productId=35455&brandId=1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceDto.class)
                .consumeWith(response -> {

                    PriceDto priceDto = response.getResponseBody();

                    Date date = new GregorianCalendar(2020, Calendar.JUNE, 14, 14, 0, 0).getTime();

                    assertNotNull(priceDto);
                    assertEquals(priceDto.getBrandId(), 1L);
                    assertTrue(priceDto.getStartDate().before(date));
                    assertTrue(priceDto.getEndDate().after(date));
                    assertEquals(priceDto.getPriceList(), 1L);
                    assertEquals(priceDto.getProductId(), 35455);
                    assertEquals(priceDto.getPrice(), 35.5);

                });

    }

    @Test
    void testFindByDateAndProductAndBrand_2() {

        client.get().uri("/api/prices?date=2020-06-14 16:00:00&productId=35455&brandId=1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceDto.class)
                .consumeWith(response -> {

                    PriceDto priceDto = response.getResponseBody();

                    Date date = new GregorianCalendar(2020, Calendar.JUNE, 14, 16, 0, 0).getTime();

                    assertNotNull(priceDto);
                    assertEquals(priceDto.getBrandId(), 1L);
                    assertTrue(priceDto.getStartDate().before(date));
                    assertTrue(priceDto.getEndDate().after(date));
                    assertEquals(priceDto.getPriceList(), 2L);
                    assertEquals(priceDto.getProductId(), 35455);
                    assertEquals(priceDto.getPrice(), 25.45);

                });

    }

    @Test
    void testFindByDateAndProductAndBrand_3() {

        client.get().uri("/api/prices?date=2020-06-14 21:00:00&productId=35455&brandId=1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceDto.class)
                .consumeWith(response -> {

                    PriceDto priceDto = response.getResponseBody();

                    Date date = new GregorianCalendar(2020, Calendar.JUNE, 14, 21, 0, 0).getTime();

                    assertNotNull(priceDto);
                    assertEquals(priceDto.getBrandId(), 1L);
                    assertTrue(priceDto.getStartDate().before(date));
                    assertTrue(priceDto.getEndDate().after(date));
                    assertEquals(priceDto.getPriceList(), 1L);
                    assertEquals(priceDto.getProductId(), 35455);
                    assertEquals(priceDto.getPrice(), 35.5);

                });

    }

    @Test
    void testFindByDateAndProductAndBrand_4() {

        client.get().uri("/api/prices?date=2020-06-15 10:00:00&productId=35455&brandId=1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceDto.class)
                .consumeWith(response -> {

                    PriceDto priceDto = response.getResponseBody();

                    Date date = new GregorianCalendar(2020, Calendar.JUNE, 15, 10, 0, 0).getTime();

                    assertNotNull(priceDto);
                    assertEquals(priceDto.getBrandId(), 1L);
                    assertTrue(priceDto.getStartDate().before(date));
                    assertTrue(priceDto.getEndDate().after(date));
                    assertEquals(priceDto.getPriceList(), 3L);
                    assertEquals(priceDto.getProductId(), 35455);
                    assertEquals(priceDto.getPrice(), 30.5);

                });

    }

    @Test
    void testFindByDateAndProductAndBrand_5() {

        client.get().uri("/api/prices?date=2020-06-15 21:00:00&productId=35455&brandId=1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody(PriceDto.class)
                .consumeWith(response -> {

                    PriceDto priceDto = response.getResponseBody();

                    Date date = new GregorianCalendar(2020, Calendar.JUNE, 21, 10, 0, 0).getTime();

                    assertNotNull(priceDto);
                    assertEquals(priceDto.getBrandId(), 1L);
                    assertTrue(priceDto.getStartDate().before(date));
                    assertTrue(priceDto.getEndDate().after(date));
                    assertEquals(priceDto.getPriceList(), 4L);
                    assertEquals(priceDto.getProductId(), 35455);
                    assertEquals(priceDto.getPrice(), 38.95);

                });

    }

}