package Day4.DVDLibrary.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DVDLibrary {
    private String title;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String userNote;

    public DVDLibrary(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

//    public void setReleaseDate(LocalDate releaseDate, DateTimeFormatter pattern) {
//        this.releaseDate = releaseDate;
//    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
