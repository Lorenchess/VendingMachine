package Day4.DVDLibrary;

import Day4.DVDLibrary.controller.DVDLibraryController;
import Day4.DVDLibrary.dao.DVDLibraryDAO;
import Day4.DVDLibrary.dao.DVDLibraryDaoException;
import Day4.DVDLibrary.dao.DVDLibraryDaoFileImpl;
import Day4.DVDLibrary.ui.DVDLibraryView;
import Day4.DVDLibrary.ui.UserIO;
import Day4.DVDLibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) throws DVDLibraryDaoException {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView myView = new DVDLibraryView(io);
        DVDLibraryDAO myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myView, myDao);
        controller.run();
    }
}
