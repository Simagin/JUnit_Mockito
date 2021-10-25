package ua.goit;

import org.junit.Test;
import ua.goit.Service.Service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AppTest {
    @Test
    public void returnBasketTest() {

        Service service = new Service();
        String name = null;
        String name1 = "1";
        String name2 = "a";

        assertEquals(service.returnBasket(name), 0d, 0);
        assertEquals(service.returnBasket(name1), 0d, 0);
        assertEquals(service.returnBasket(name2), 1.25D, 0);

    }
}
