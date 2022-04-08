package vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class VendingMachine {
    private String name;
    private BigDecimal price;
    private int totalUnits;


    public VendingMachine(String name) {
        this.name = name;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendingMachine)) return false;
        VendingMachine that = (VendingMachine) o;
        return getTotalUnits() == that.getTotalUnits() && getName().equals(that.getName()) && getPrice().equals(that.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getTotalUnits());
    }

    @Override
    public String toString() {
        return "Product: " + name +
                ", Price: $" + price;
    }
}
