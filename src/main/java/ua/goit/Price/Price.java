package ua.goit.Price;

import java.util.Objects;

public class Price {

    private String name;
    private double price;
    private int promotionalQuantity;
    private double promotionalPrice;

    public Price() {
    }

    public Price(String name, Double price) {

      this.name = name;
      this.price = price;
      this.promotionalQuantity = 1;
      this.promotionalPrice = price;

    }

    public Price(String name, double price, int promotionalQuantity, double promotionalPrice) {
        this.name = name;
        this.price = price;
        this.promotionalQuantity = promotionalQuantity;
        this.promotionalPrice = promotionalPrice;
    }

    public int getPromotionalQuantity() {
        return promotionalQuantity;
    }

    public double getPromotionalPrice() {
        return promotionalPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0 && promotionalQuantity == price1.promotionalQuantity && Double.compare(price1.promotionalPrice, promotionalPrice) == 0 && name.equals(price1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, promotionalQuantity, promotionalPrice);
    }

    @Override
    public String toString() {
        return "Price{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", promotionalQuantity=" + promotionalQuantity +
                ", promotionalPrice=" + promotionalPrice +
                '}';
    }

}
