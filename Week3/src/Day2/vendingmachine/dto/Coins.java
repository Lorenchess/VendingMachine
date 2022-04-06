package Day2.vendingmachine.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public enum Coins {
    QUARTER(new BigInteger("25")),
    DIME(new BigInteger("10")),
    NICKEL(new BigInteger("5")),
    PENNY(new BigInteger("1"));

    private BigInteger value;


    Coins(BigInteger value) {
        this.value = value;
    }

    public BigInteger getValue() {
        return value;
    }

}
