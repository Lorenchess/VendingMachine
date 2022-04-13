package Day4.DVDLibrary.ui;

public interface UserIO {
    int readInt(String prompt, int min, int max);
    String readString(String prompt);
    int readInt(String msgPrompt);
    void print(String msg);
}
