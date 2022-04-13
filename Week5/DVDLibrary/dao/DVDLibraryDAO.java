package Day4.DVDLibrary.dao;

import Day4.DVDLibrary.dto.DVDLibrary;


import java.util.List;
import java.util.Set;


public interface DVDLibraryDAO {
    DVDLibrary addDVD(String dvdTitle, DVDLibrary dvd) throws DVDLibraryDaoException;
    List<DVDLibrary> getAllDVDs() throws DVDLibraryDaoException;
    DVDLibrary getDVD(String dvdTitle) throws DVDLibraryDaoException;
    DVDLibrary removeDVD(String dvdTitle) throws DVDLibraryDaoException;
    DVDLibrary updateReleaseDate(String dvdTitle, String releaseDate) throws DVDLibraryDaoException;
    DVDLibrary updateMPAARating(String dvdTitle, String releaseDate) throws DVDLibraryDaoException;
    DVDLibrary updateDirectorName(String dvdTitle, String releaseDate) throws DVDLibraryDaoException;
    DVDLibrary updateStudio(String dvdTitle, String releaseDate) throws DVDLibraryDaoException;
    DVDLibrary updateCustomerNote(String dvdTitle, String releaseDate) throws DVDLibraryDaoException;
    Set<String> getAllDVDTitles() throws DVDLibraryDaoException;
    String checkedDVDTitleInLibrary(String title) throws DVDLibraryDaoException;


}
