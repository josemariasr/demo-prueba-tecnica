package com.prueba.tecnica.app.models.dto;

import com.prueba.tecnica.app.enums.CurrencyIso;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PriceDto {

    @NotNull
    private Long brandId;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Long priceList;

    @NotNull
    private Long productId;

    @NotNull
    private Double price;



}
