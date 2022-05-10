package com.lorenchess.dvdlibrary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DvdLibrary {
    private int id;
    private String dvdTitle;
    private String releaseYear;
    private String director;
    private String rating;
    private String notes;
}
