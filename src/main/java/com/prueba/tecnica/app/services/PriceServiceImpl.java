package com.prueba.tecnica.app.services;

import com.prueba.tecnica.app.models.dto.PriceDto;
import com.prueba.tecnica.app.repositories.PriceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

import static com.prueba.tecnica.app.utils.DtoUtils.map;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    /**
     * @inheritDoc
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PriceDto> findByDateAndProductAndBrand(Date date, Long productId, Long brandId) {
        return priceRepository.findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(
                date, date, productId, brandId
        ).map(price -> map(price, PriceDto.class));
    }

}
