package ua.goit.Service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTest {

    @Test
    public void basketTest() {
        Service service = new Service();
        String name = null;
        String name1 = "sss";
        String name2 = "a";

        assertNotNull(service.filterBasket(name));
        assertNotEquals(service.filterBasket(name1), name1);
        assertEquals(service.filterBasket(name2), "A");

    }
}