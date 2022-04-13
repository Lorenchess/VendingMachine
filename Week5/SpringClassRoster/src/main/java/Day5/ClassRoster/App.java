package Day5.ClassRoster;

import Day5.ClassRoster.DAO.ClassRosterAuditDao;
import Day5.ClassRoster.DAO.ClassRosterAuditDaoFileImpl;
import Day5.ClassRoster.DAO.ClassRosterDao;
import Day5.ClassRoster.DAO.ClassRosterDaoFileImpl;
import Day5.ClassRoster.UI.ClassRosterView;
import Day5.ClassRoster.UI.UserIO;
import Day5.ClassRoster.UI.UserIOConsoleImpl;
import Day5.ClassRoster.controller.ClassRosterController;
import Day5.ClassRoster.service.ClassRosterServiceLayer;
import Day5.ClassRoster.service.ClassRosterServiceLayerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

    public static void main(String[] args) {
         //Instantiate the UserIO implementation
//        UserIO myIo = new UserIOConsoleImpl();
//
//         //Instantiate the View and wire the UserIO implementation into it
//        ClassRosterView myView = new ClassRosterView(myIo);
//
//         //Instantiate the DAO
//        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
//
//         //Instantiate the Audit DAO
//        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
//
//         //Instantiate the Service Layer and wire the DAO and Audit DAO into it
//        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao,myAuditDao);
//
//         //Instantiate the Controller and wire the Service Layer into it
//        ClassRosterController controller = new ClassRosterController(myService, myView);
//
//        // Kick off the Controller
//        controller.run();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);

        controller.run();





    }


}
