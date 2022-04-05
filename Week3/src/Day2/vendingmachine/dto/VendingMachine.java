package Day2.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class VendingMachine {
    private String name;
    private BigDecimal price;

    public VendingMachine(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VendingMachine)) return false;
        VendingMachine product = (VendingMachine) o;
        return getName().equals(product.getName()) && getPrice().equals(product.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
