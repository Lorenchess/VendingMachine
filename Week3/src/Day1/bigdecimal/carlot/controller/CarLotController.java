package Day1.bigdecimal.carlot.controller;

import Day1.bigdecimal.carlot.dto.Car;
import Day1.bigdecimal.carlot.dto.CarKey;
import Day1.bigdecimal.carlot.service.CarLotService;
import Day1.bigdecimal.carlot.ui.CarLotView;

import java.util.List;

public class CarLotController {
   private CarLotService service;
   private CarLotView view;

    public CarLotController(CarLotService service, CarLotView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        carList();
                        break;
                    case 2:
                        viewCar();
                        break;
                    case 3:
                        carsListByColor();
                        break;
                    case 4:
                        carsByPrice();
                        break;
                    case 5:
                        carsByMakeAndModel();
                        break;
                    case 6:
                        sellingACar();
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        }catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private List<Car> carList() {
        return null;
    }

    private Car viewCar() {
        return null;
    }

    private List<Car> carsListByColor() {
        return null;
    }

    private List<Car> carsByPrice() {
        return null;
    }

    private List<Car> carsByMakeAndModel() {
        return null;
    }

    private CarKey sellingACar() {
      return null;
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }



















}
