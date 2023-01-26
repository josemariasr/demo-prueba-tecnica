package com.prueba.tecnica.app.repositories;

import com.prueba.tecnica.app.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findFirstByStartDateBeforeAndEndDateAfterAndProductIdAndBrandIdOrderByPriorityDesc(Date startDate, Date endDate, Long productId, Long brandId);


}
