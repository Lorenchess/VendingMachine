package com.lorenchess.dvdlibrary.repository;

import com.lorenchess.dvdlibrary.entity.DvdLibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DvdLibraryRepository extends JpaRepository<DvdLibraryEntity, Integer> {
    //extends all the CRUD methods...proxi??
}
