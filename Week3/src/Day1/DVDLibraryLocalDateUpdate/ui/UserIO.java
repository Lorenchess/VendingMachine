package Day1.DVDLibraryLocalDateUpdate.ui;

import java.time.LocalDate;

public interface UserIO {
    int readInt(String prompt, int min, int max);
    String readString(String prompt);
    int readInt(String msgPrompt);
    void print(String msg);

    LocalDate printDate(LocalDate date);

    String getUserReleaseDate(String prompt);

}
