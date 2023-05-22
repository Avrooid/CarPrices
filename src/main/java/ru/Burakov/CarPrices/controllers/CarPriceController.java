package ru.Burakov.CarPrices.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.Burakov.CarPrices.models.CarPrice;
import ru.Burakov.CarPrices.models.CarPriceRequest;
import ru.Burakov.CarPrices.repositories.CarPriceRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarPriceController {
    private final CarPriceRepository carPriceRepository;

    @PostMapping("/addCarPrice")
    public void addCarPrice(@RequestBody CarPrice carPrice) {
        carPriceRepository.save(carPrice);
    }

    @GetMapping("/carPrices")
    public List<CarPrice> getAllCarPrices() {
        return carPriceRepository.findAll();
    }

    @GetMapping("/carPrice")
    public CarPrice getCarPrice(@RequestBody CarPriceRequest carPriceRequest) {
        return carPriceRepository.findByCarName(carPriceRequest.getCarName());
    }
}
