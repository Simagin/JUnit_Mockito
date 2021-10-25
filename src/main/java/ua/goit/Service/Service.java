package ua.goit.Service;

import ua.goit.Price.Price;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Service {

    private static final Map<String, Price> priceMap = new HashMap<>();

    static {
        priceMap.put("A", new Price("A", 1.25D, 3, 3.00d));
        priceMap.put("B", new Price("B", 4.25D));
        priceMap.put("C", new Price("C", 1.00D, 6, 5.00d));
        priceMap.put("D", new Price("D", 0.75D));
    }

    public double returnBasket(String basket) {

        String finalBasket = filterBasket(basket);

        if (!finalBasket.equals("Basket is empty") && !finalBasket.equals("")) {

            Map<String, Long> basketQuantity = Arrays.stream(finalBasket.split(""))
                    .map(key -> priceMap.get(key))
                    .collect(Collectors.groupingBy(price -> price.getName(),
                            Collectors.mapping(Price::getName, Collectors.counting())));

            return basketQuantity.entrySet().stream()
                    .mapToDouble(d -> formsThePrice(priceMap.get(d.getKey()), d.getValue()))
                    .sum();
        } else return 0;
    }

    private double formsThePrice(Price price, Long count) {

        if (count < 1) {
            throw new RuntimeException("Bag is empty");
        }
        if (count < price.getPromotionalQuantity()) {
            return count * price.getPrice();
        }
        return (count / price.getPromotionalQuantity()) * price.getPromotionalPrice()
                + (count % price.getPromotionalQuantity()) * price.getPrice();
    }

    protected String filterBasket(String basket) {

        if (basket == null || basket.isEmpty()) return "Basket is empty";

        else return Arrays.stream(basket.toUpperCase().split(""))
                .filter(key -> priceMap.containsKey(key))
                .collect(Collectors.joining());
    }
}
