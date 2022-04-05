package Day1.bigdecimal.carlot.service;

import Day1.bigdecimal.carlot.dao.CarLotDAO;
import Day1.bigdecimal.carlot.dto.Car;
import Day1.bigdecimal.carlot.dto.CarKey;

import java.math.BigDecimal;
import java.util.List;

public class CarLotServiceIml implements CarLotService{
    private CarLotDAO dao;

    public CarLotServiceIml(CarLotDAO dao) {
        this.dao = dao;
    }

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
