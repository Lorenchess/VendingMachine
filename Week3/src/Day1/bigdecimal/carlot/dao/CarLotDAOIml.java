package Day1.bigdecimal.carlot.dao;

import Day1.bigdecimal.carlot.dto.Car;
import Day1.bigdecimal.carlot.dto.CarKey;
import Day1.bigdecimal.carlot.service.CarLotService;
import Day1.bigdecimal.carlot.service.NoSuchCarException;
import Day1.bigdecimal.carlot.service.OverpaidPriceException;
import Day1.bigdecimal.carlot.service.UnderpaidPriceException;

import java.math.BigDecimal;
import java.util.List;

public class CarLotDAOIml implements CarLotService {
    @Override
    public Car getACar(String VIN) {
        return null;
    }

    @Override
    public List<Car> getAllCars() {
        return null;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return null;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        return null;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        return null;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        return null;
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        return null;
    }
}
