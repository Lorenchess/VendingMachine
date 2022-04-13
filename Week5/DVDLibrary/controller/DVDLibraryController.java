package Day4.DVDLibrary.controller;

import Day4.DVDLibrary.dao.DVDLibraryDAO;
import Day4.DVDLibrary.dao.DVDLibraryDaoException;
import Day4.DVDLibrary.dto.DVDLibrary;
import Day4.DVDLibrary.ui.DVDLibraryView;


import java.util.List;

public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDAO dao;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryDAO dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepRunning = true;
        int menuSelection = 0;

        try{
            while (keepRunning) {

                menuSelection = getMenuSelection(); //returns an integer from user selection

                switch (menuSelection) {
                    case 1:
                        listOfDVD();
                        break;
                    case 2:
                        createDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        updateDVD();
                        break;
                    case 5:
                        removeDVD();
                        break;
                    case 6:
                        keepRunning = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMenuMessage();
        }catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    //Important to notice that Controller delegate the actions to the concrete implementation classes view and dao(reference variables)
    private void createDVD() throws DVDLibraryDaoException {
        view.displayCreateDVDBanner();
        DVDLibrary newDVD = view.getNewDVDInfo(); //new DVD returned and saved in newDVD variable.
        dao.addDVD(newDVD.getTitle(), newDVD);   //adding the new DVD to the Map saved in DAO implementation.
        view.displaySuccessBanner(); //displays the successful message that the DVD was created.
    }

    private void listOfDVD() throws DVDLibraryDaoException {
        view.displayAllDVDBanner();
        List<DVDLibrary> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVDLibrary dvd = dao.getDVD(dvdTitle);
        view.displayDVD(dvd);
    }

    private void updateDVD() throws DVDLibraryDaoException {
        int fieldSelection = 0;
        DVDLibrary updatedDVD = null;
        view.displayDVDUpdateBanner();
        String dvdTitle = view.getDVDTitleChoice();
        dvdTitle = dao.checkedDVDTitleInLibrary(dvdTitle);
        if (dvdTitle != null) {
            fieldSelection = view.printDVDFieldsAndGetSelection();

            switch (fieldSelection) {
                case 1:
                    updatedDVD= dao.updateReleaseDate(dvdTitle,view.updatingDVDReleaseDate(dvdTitle));
                    break;
                case 2:
                    updatedDVD= dao.updateMPAARating(dvdTitle, view.updatingMPAARating(dvdTitle)) ;
                    break;
                case 3:
                    updatedDVD= dao.updateDirectorName(dvdTitle, view.updatingDirectorName(dvdTitle));
                    break;
                case 4:
                    updatedDVD= dao.updateStudio(dvdTitle, view.updatingStudio(dvdTitle));
                    break;
                case 5:
                    updatedDVD= dao.updateCustomerNote(dvdTitle, view.updatingComments(dvdTitle));
                    break;
                default:
                    unknownCommand();
            }

            view.updateDVDFieldsResult();
        } else {
            view.displayUpdateDVDFailMessage();
            getMenuSelection();
        }
    }



    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String dvdTitle = view.getDVDTitleChoice();
        DVDLibrary removedDVD = dao.removeDVD(dvdTitle);
        view.displayRemoveDVDResult(removedDVD);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMenuMessage() {
        view.displayExitMenuBanner();
    }












}

