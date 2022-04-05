package Day1.DVDLibraryLocalDateUpdate.dao;

import Day1.DVDLibraryLocalDateUpdate.dto.DVDLibrary;


import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDAO{
    public static final String DVD_FILE = "C:\\Users\\Ramon Lorente\\Desktop\\c184-Java-React\\Week2\\week-2-Lorenchess\\src\\Day4\\DVDLibrary\\dao\\dvd.txt";
    public static final String DELIMITER = "::";

    private Map<String, DVDLibrary> dvds = new HashMap<>();


    @Override
    public DVDLibrary addDVD(String dvdTitle, DVDLibrary dvd ) throws DVDLibraryDaoException {
        loadRoster();
        DVDLibrary newDVD =  dvds.put(dvdTitle, dvd);
        writeDVD();
        return newDVD;
    }

    @Override
    public List<DVDLibrary> getAllDVDs() throws DVDLibraryDaoException {
        loadRoster();
        return new ArrayList<>(dvds.values()); //creates an ArrayList of DVD on the fly
    }

    @Override
    public DVDLibrary getDVD(String dvdTitle) throws DVDLibraryDaoException {
        loadRoster();
        return dvds.get(dvdTitle);
    }


    @Override
    public DVDLibrary updateReleaseDate(String dvdTitle, String releaseDate) throws DVDLibraryDaoException {
        loadRoster();
        DVDLibrary title = dvds.get(dvdTitle);
        title.setReleaseDate(releaseDate);
        writeDVD();
        return title;
    }

    @Override
    public DVDLibrary updateMPAARating(String dvdTitle, String mpaaRating) throws DVDLibraryDaoException {
        loadRoster();
        DVDLibrary title = dvds.get(dvdTitle);
        title.setMpaaRating(mpaaRating);
        writeDVD();
        return title;
    }

    @Override
    public DVDLibrary updateDirectorName(String dvdTitle, String directorName) throws DVDLibraryDaoException {
        loadRoster();
        DVDLibrary title = dvds.get(dvdTitle);
        title.setDirectorName(directorName);
        writeDVD();
        return title;
    }

    @Override
    public DVDLibrary updateStudio(String dvdTitle, String studio) throws DVDLibraryDaoException {
        loadRoster();
        DVDLibrary title = dvds.get(dvdTitle);
        title.setStudio(studio);
        writeDVD();
        return title;
    }

    @Override
    public DVDLibrary updateCustomerNote(String dvdTitle, String customerNote) throws DVDLibraryDaoException {
        loadRoster();
        DVDLibrary title = dvds.get(dvdTitle);
        title.setUserNote(customerNote);
        writeDVD();
        return title;
    }

    @Override
    public Set<String> getAllDVDTitles() throws DVDLibraryDaoException {
        loadRoster();
        return new HashSet<>(dvds.keySet());
    }

    @Override
    public String checkedDVDTitleInLibrary(String title) throws DVDLibraryDaoException {
        Set<String> dvdTitles = getAllDVDTitles();
        if (dvdTitles.contains(title)){
            return title;
        } else {
            return null;
        }
    }

    @Override
    public DVDLibrary removeDVD(String dvdTitle) throws DVDLibraryDaoException {
        loadRoster();
        DVDLibrary removeDVD = dvds.remove(dvdTitle);
        writeDVD();
        return removeDVD;
    }

    private DVDLibrary unmarshallDVDLibrary(String dvdAsText){

        String[] dvdTokens = dvdAsText.split(DELIMITER);


        String dvdTitle = dvdTokens[0];

        // Which we can then use to create a new DVD object to satisfy
        // the requirements of the DVD library constructor.
        DVDLibrary dvdFromFile = new DVDLibrary(dvdTitle);

        // However, there are 5 remaining tokens that need to be set into the
        // new dvd library object. Do this manually by using the appropriate setters.

        // Index 1 - releaseDate
        dvdFromFile.setReleaseDate(dvdTokens[1]);

        // Index 2 - mpaaRating
        dvdFromFile.setMpaaRating(dvdTokens[2]);

        // Index 3 - directorName
        dvdFromFile.setDirectorName(dvdTokens[3]);

        // Index 4 - studio
        dvdFromFile.setStudio(dvdTokens[4]);

        // Index 5 - userNote
        dvdFromFile.setUserNote(dvdTokens[5]);

        // We have now created a dvd! Return it!
        return dvdFromFile;
    }

    private void loadRoster() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException(
                    "-_- Could not load dvd data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentDVD holds the most recent dvd unmarshalled
        DVDLibrary currentDVD;
        // Go through DVD_FILE line by line, decoding each line into a
        // DVD object by calling the unmarshallDVDLibrary method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a DVD
            currentDVD = unmarshallDVDLibrary(currentLine);

            // We are going to use the DVD title as the map key for our DVD object.
            // Put currentDVD into the map using dvd title as the key
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDVDLibrary(DVDLibrary aDVD){

        // Start with the dvd title, since that's supposed to be first.
        String dvdAsText = aDVD.getTitle() + DELIMITER;

        // add the rest of the properties in the correct order:

        // releaseDate
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;

        // mpaaRating
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;

        // directorName
        dvdAsText += aDVD.getDirectorName()+ DELIMITER;

        // studio
        dvdAsText += aDVD.getStudio()+ DELIMITER;

        // userNote
        dvdAsText += aDVD.getUserNote();

        // We have now turned a student to text! Return it!
        return dvdAsText;
    }

    private void writeDVD() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        // Write out the Student objects to the roster file.
        // We could just grab the student map,
        // get the Collection of Students and iterate over them, but we've
        // already created a method that gets a List of DVD, so
        // we'll reuse it.

        String dvdAsText;
        List<DVDLibrary> dvdList = this.getAllDVDs();
        for (DVDLibrary currentDVD : dvdList) {
            // turn a DVD into a String
            dvdAsText = marshallDVDLibrary(currentDVD);
            // write the DVD object to the file
            out.println(dvdAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
