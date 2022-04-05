package Day1.bigdecimal.carlot.service;

import Day1.bigdecimal.carlot.dto.Car;
import Day1.bigdecimal.carlot.dto.CarKey;

import java.math.BigDecimal;
import java.util.List;

public interface CarLotService {
    Car getACar(String VIN);
    List<Car> getAllCars();
    List<Car> getCarsByColor(String color);
    List<Car> getCarsInBudget(BigDecimal maxPrice);
    List<Car> getCarByMakeAndModel(String make, String model);

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
            throws NoSuchCarException;

    CarKey sellCar(String VIN, BigDecimal cashPaid)
            throws NoSuchCarException,
            OverpaidPriceException,
            UnderpaidPriceException;
}
