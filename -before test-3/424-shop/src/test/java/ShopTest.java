import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ShopTest {

    @Test
    public void test1(){
        double tax =0;

        Shop shop = new DonutShop();
        shop.buyInventory("Donuts");

        tax =shop.calculateSalesTax();
        assertEquals(0.15,tax,0.0001);
    }

    @Test
    public void test2(){
        double tax =0;

        Shop shop = new PizzaShop();
        shop.buyInventory("Pizza");


        tax =shop.calculateSalesTax();
        assertEquals(0.25,tax,0.0001);
    }

    @Test
    public void test3(){
        double tax =0;

        Shop shop = new DonutShop();

        tax =shop.calculateSalesTax();
        assertEquals(0.0,tax,0.0001);
    }

    @Test
    public void test4(){
        double tax =0;

        DonutShop shop = new DonutShop();

        assertEquals("Sweat Donut",shop.getName());
    }

    @Test
    public void test5(){
        double tax =0;
        boolean hasItem = false;

        Shop shop = new DonutShop();
        hasItem=shop.buyInventory("Calzone");

        assertFalse(hasItem);
    }

}
