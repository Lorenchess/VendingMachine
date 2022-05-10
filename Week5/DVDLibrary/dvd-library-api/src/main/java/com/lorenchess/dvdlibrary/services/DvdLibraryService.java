package com.lorenchess.dvdlibrary.services;

import com.lorenchess.dvdlibrary.model.DvdLibrary;

import java.util.List;

public interface DvdLibraryService {
    DvdLibrary createDvd(DvdLibrary dvd);

    List<DvdLibrary> getAllDvds();

    boolean deleteDvd(int id);

    DvdLibrary getDvdById(int id);

    DvdLibrary updateDvd(int id, DvdLibrary dvd);
}
