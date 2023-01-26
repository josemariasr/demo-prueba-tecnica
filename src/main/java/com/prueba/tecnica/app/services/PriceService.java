package com.prueba.tecnica.app.services;

import com.prueba.tecnica.app.models.dto.PriceDto;

import java.util.Date;
import java.util.Optional;

public interface PriceService {

    /**
     * method that searches for the price of a specific product on a specific date
     * @param date the date
     * @param productId the id of the product
     * @param brandId the id of the brand
     * @return the price
     */
    Optional<PriceDto> findByDateAndProductAndBrand(Date date, Long productId, Long brandId);

}
