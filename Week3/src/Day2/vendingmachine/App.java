package Day2.vendingmachine;


import Day2.vendingmachine.controller.VendingMachineController;
import Day2.vendingmachine.dao.VendingMachineAuditDao;
import Day2.vendingmachine.dao.VendingMachineAuditFileImpl;
import Day2.vendingmachine.dao.VendingMachineDao;
import Day2.vendingmachine.dao.VendingMachineDaoFileImpl;
import Day2.vendingmachine.service.VendingMachineServiceLayer;
import Day2.vendingmachine.service.VendingMachineServiceLayerImpl;
import Day2.vendingmachine.ui.UserIO;
import Day2.vendingmachine.ui.UserIOConsoleImpl;
import Day2.vendingmachine.ui.VendingMachineView;

public class App {
    public static void main(String[] args) {
        // Instantiate the UserIO implementation
        UserIO myIo = new UserIOConsoleImpl();

        // Instantiate the View and wire the UserIO implementation into it
        VendingMachineView myView = new VendingMachineView(myIo);

        // Instantiate the DAO
        VendingMachineDao myDao = new VendingMachineDaoFileImpl();

        //// Instantiate the Audit DAO
        VendingMachineAuditDao myAuditDao = new VendingMachineAuditFileImpl();

        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);

        // Instantiate the Controller and wire the Service Layer into it
        VendingMachineController controller = new VendingMachineController(myView,myService);

        // Kick off the Controller
        controller.run();
    }
}
