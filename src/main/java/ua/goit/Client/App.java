package ua.goit.Client;

import ua.goit.Service.Service;

public class App {

    public static void main(String[] args) {

        Service service = new Service();

        String basket = "afhsfgfhd";
        double res = service.returnBasket(basket);
        System.out.println(res);

    }
}

