package com.prueba.tecnica.app.models.entities;

import com.prueba.tecnica.app.enums.CurrencyIso;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "prices")
@Getter
@Setter
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id")
    @NotNull
    private Long brandId;

    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date startDate;

    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date endDate;

    @Column(name = "price_list")
    @NotNull
    private Long priceList;

    @Column(name = "product_id")
    @NotNull
    private Long productId;

    @NotNull
    private Long priority;

    @NotNull
    private Double price;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private CurrencyIso curr;

}
