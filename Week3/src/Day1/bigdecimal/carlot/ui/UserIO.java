package Day1.bigdecimal.carlot.ui;

import java.math.BigDecimal;

public interface UserIO {
    String readString(String prompt);
    BigDecimal readBigDecimal(String msgPrompt);
    void print(String msg);

    int readInt(String prompt, int min, int max);
    int readInt(String prompt);

}
