package Day1.DVDLibraryLocalDateUpdate.ui;

import Day1.DVDLibraryLocalDateUpdate.dto.DVDLibrary;


import java.time.LocalDate;
import java.util.List;

public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. DVD List");
        io.print("2. Create New DVD");
        io.print("3. View a DVD");
        io.print("4. Update DVD");
        io.print("5. Remove a DVD");
        io.print("6. Exit Program");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    /**
     * Method called after user chose 2 Create New DVD.
     * User puts the data saved in variables that will set the values of the currentDVD.
     * @return a new DVD data that will be use by addDVD method from DAO implementation to save DVD in the HashMap present in DAO implementation
     */
    public DVDLibrary getNewDVDInfo() {
        String dvdTitle = io.readString("Please enter DVD title");
        String releaseDate = io.getUserReleaseDate("Please enter DVD release date in the format: mm/dd/yyyy");
        String mpaaRating = io.readString("Please enter MPAA Rating");;
        String directorName = io.readString("Please enter Director Name");;
        String studio = io.readString("Please enter Name of the Studio");;
        String userNote = io.readString("Please enter a Comment for the DVD");

        /*
         We create a new DVD called currentDVD, and add the title throughout the constructor, since is read only(has no setters)
         Then we use the setters to add the data type by User.
         */

        DVDLibrary currentDVD = new DVDLibrary(dvdTitle);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(mpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserNote(userNote);
        return currentDVD;
    }

    public void displayCreateDVDBanner() {
        io.print("*** Creating DVD ***");
    }

    public void displaySuccessBanner() {
        io.readString("DVD successfully created. Please press enter to continue");
    }

    /**
     * loops over the DVD List saved and displays the DVD list to the user.
     * @param dvdLibraryList
     */

    public void displayDVDList(List<DVDLibrary> dvdLibraryList) {
        for (var currentDVD : dvdLibraryList) {
            String dvdInfo = String.format("%s * %s * %s * %s * %s * %s",
                    currentDVD.getTitle(),
                    currentDVD.getReleaseDate(),
                    currentDVD.getMpaaRating(),
                    currentDVD.getDirectorName(),
                    currentDVD.getStudio(),
                    currentDVD.getUserNote());
            io.print(dvdInfo);
        }
        io.readString("Please press enter to continue");
    }

    public void displayAllDVDBanner() {
        io.print("*** Display All DVD ***");
    }

    public void displayDVDBanner () {
        io.print("*** Displaying DVD ***");
    }

    public String getDVDTitleChoice() {
        String userTitleInput = io.readString("Please enter the DVD title");

        return userTitleInput;
    }

    public void displayDVD(DVDLibrary dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getDirectorName());
            io.getUserReleaseDate(String.valueOf(dvd.getReleaseDate()));
            io.print(dvd.getStudio());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getUserNote());
        } else {
            io.print("There is not matching DVD in the library");
        }
        io.readString("Please press enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("*** Removing DVD ***");
    }

    public void displayRemoveDVDResult(DVDLibrary dvdToRemove) {
        if (dvdToRemove == null) {
            io.print("No DVD found in library");
        } else {
            io.print("DVD successfully removed from library");
        }
        io.readString("Please press enter to continue.");
    }

    public int printDVDFieldsAndGetSelection() {
        io.print("DVD FIELDS TO UPDATE");
        io.print("1. RELEASE DATE");
        io.print("2. MPAA RATING");
        io.print("3. DIRECTOR NAME");
        io.print("4. STUDIO");
        io.print("5. CUSTOMER COMMENTS");

        return io.readInt("Please select from the above choices.", 1, 5);
    }


    ////need to fix eliminate parameter....
    public String updatingDVDReleaseDate(String dvdTitle) {
        String releaseDate = io.getUserReleaseDate("Please enter DVD release date:");
        return releaseDate;
    }

    public String updatingMPAARating(String dvdTitle) {
        String mpaaRating = io.readString("Please enter DVD MPAA Rating:");
        return mpaaRating;
    }

    public String updatingDirectorName(String dvdTitle) {
        String directorName = io.readString("Please enter DVD Director Name:");
        return directorName;
    }

    public String updatingStudio(String dvdTitle) {
        String studio = io.readString("Please enter DVD Studio:");
        return studio;
    }

    public String updatingComments(String dvdTitle) {
        String comments = io.readString("Please enter DVD Comment:");
        return comments;
    }


    public void updateDVDFieldsResult() {
        io.print("DVD successfully updated!");
        io.readString("Please press enter to continue.");
    }

    public void displayUpdateDVDFailMessage() {
        io.print("Title not found in Library!");
    }


    public void displayDVDUpdateBanner() {
        io.print("*** Updating DVD ***");
    }


    public void displayExitMenuBanner() {
       io.print("Thank you for using our DVD library. Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("** ERROR ***");
        io.print(errorMsg);
    }













}
