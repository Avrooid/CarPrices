package ru.Burakov.CarPrices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Burakov.CarPrices.models.CarPrice;

public interface CarPriceRepository extends JpaRepository<CarPrice, Long> {
    CarPrice findByCarName(String carName);
}
