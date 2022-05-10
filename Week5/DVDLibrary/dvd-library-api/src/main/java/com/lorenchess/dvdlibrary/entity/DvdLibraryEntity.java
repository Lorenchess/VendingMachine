package com.lorenchess.dvdlibrary.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "dvd")
public class DvdLibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dvdTitle;
    private String releaseYear;
    private String director;
    private String rating;
    private String notes;

}
