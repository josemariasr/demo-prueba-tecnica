package com.prueba.tecnica.app.controllers;

import com.prueba.tecnica.app.models.dto.PriceDto;
import com.prueba.tecnica.app.services.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/prices")
public class PriceRestController {

    private final PriceService priceService;

    public PriceRestController(PriceService priceService) {
        this.priceService = priceService;
    }

    @Operation(summary = "Get the price of a specific product on a specific date")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price was found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = PriceDto.class))}),
            @ApiResponse(responseCode = "404", description = "Price not found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<PriceDto> findByDateAndProductAndBrand(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, @RequestParam Long productId, @RequestParam Long brandId) {
        return ResponseEntity.of(priceService.findByDateAndProductAndBrand(date, productId, brandId));
    }

}
