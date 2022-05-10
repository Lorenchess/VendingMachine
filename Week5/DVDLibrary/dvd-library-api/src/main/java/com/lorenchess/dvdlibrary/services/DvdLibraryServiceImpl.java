package com.lorenchess.dvdlibrary.services;

import com.lorenchess.dvdlibrary.entity.DvdLibraryEntity;
import com.lorenchess.dvdlibrary.model.DvdLibrary;
import com.lorenchess.dvdlibrary.repository.DvdLibraryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DvdLibraryServiceImpl implements DvdLibraryService{

    private DvdLibraryRepository dvdLibraryRepository;

    @Autowired
    public DvdLibraryServiceImpl(DvdLibraryRepository dvdLibraryRepository) {
        this.dvdLibraryRepository = dvdLibraryRepository;
    }

    @Override
    public DvdLibrary createDvd(DvdLibrary dvd) {
        DvdLibraryEntity dvdEntity = new DvdLibraryEntity(); //represents the rows in the table "dvd_library"

        BeanUtils.copyProperties(dvd, dvdEntity); //passes the data obtained throughout React & axios to the dvd object
        dvdLibraryRepository.save(dvdEntity);     //saves the data "persistence" in the database...
        return dvd; //now the object dvd contains the data passed by the frontend ...
    }

    @Override
    public List<DvdLibrary> getAllDvds() {
        List<DvdLibraryEntity> dvdLibraryEntities = dvdLibraryRepository.findAll();
        List<DvdLibrary> dvds = dvdLibraryEntities.stream().
                                                    map(dvd-> new DvdLibrary(dvd.getId(),
                                                    dvd.getDvdTitle(),dvd.getReleaseYear(),dvd.getDirector(),
                                                    dvd.getRating(),dvd.getNotes())).collect(Collectors.toList());
        return dvds;
    }

    @Override
    public boolean deleteDvd(int id) {
        DvdLibraryEntity dvd = dvdLibraryRepository.findById(id).get();
        dvdLibraryRepository.delete(dvd);
        return true;
    }

    @Override
    public DvdLibrary getDvdById(int id) {
        DvdLibraryEntity dvdEntity = dvdLibraryRepository.findById(id).get();
        DvdLibrary dvd = new DvdLibrary();
        BeanUtils.copyProperties(dvdEntity, dvd);
        return dvd;
    }

    @Override
    public DvdLibrary updateDvd(int id, DvdLibrary dvd) {
        DvdLibraryEntity dvdEntity = dvdLibraryRepository.findById(id).get();
        dvdEntity.setDvdTitle(dvd.getDvdTitle());
        dvdEntity.setReleaseYear(dvd.getReleaseYear());
        dvdEntity.setDirector(dvd.getDirector());
        dvdEntity.setRating(dvd.getRating());
        dvdEntity.setNotes(dvd.getNotes());

        dvdLibraryRepository.save(dvdEntity);
        return dvd;
    }
}
