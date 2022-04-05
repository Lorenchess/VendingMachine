package Day1.DVDLibraryLocalDateUpdate;

import Day1.DVDLibraryLocalDateUpdate.controller.DVDLibraryController;
import Day1.DVDLibraryLocalDateUpdate.dao.DVDLibraryDAO;
import Day1.DVDLibraryLocalDateUpdate.dao.DVDLibraryDaoException;
import Day1.DVDLibraryLocalDateUpdate.dao.DVDLibraryDaoFileImpl;
import Day1.DVDLibraryLocalDateUpdate.ui.DVDLibraryView;
import Day1.DVDLibraryLocalDateUpdate.ui.UserIO;
import Day1.DVDLibraryLocalDateUpdate.ui.UserIOConsoleImpl;


public class App {
    public static void main(String[] args) throws DVDLibraryDaoException {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(io);
        DVDLibraryDAO myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myView, myDao);
        controller.run();
    }
}
