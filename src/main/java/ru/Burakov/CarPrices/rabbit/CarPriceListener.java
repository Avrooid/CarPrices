package ru.Burakov.CarPrices.rabbit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.Burakov.CarPrices.repositories.CarPriceRepository;

@Component
@EnableRabbit
@Slf4j
@RequiredArgsConstructor
public class CarPriceListener {
    private final CarPriceRepository carPriceRepository;

    @RabbitListener(queues = "queue1")
    public String getCarPrice(String message) {
        var car = carPriceRepository.findByCarName(message.replaceAll("\"", ""));
        String carName = "";
        if (car == null) {
            carName = "Такой машины нет в нашем списке цен";
        }
        else {
            carName = car.getPrice().toString();
        }
        log.info(carName);
        return carName;
    }
}
