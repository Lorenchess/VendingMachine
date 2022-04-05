package Day1.bigdecimal.carlot.dao;

import Day1.bigdecimal.carlot.dto.Car;

import java.util.List;

public interface CarLotDAO {
    Car addCar(String VIN, Car car);

    Car getCar(String VIN);
    List<Car> getCars();

    void editCar(String VIN, Car car);

    Car removeCar(String VIN);
}
