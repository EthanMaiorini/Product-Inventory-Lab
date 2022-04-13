package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class TshirtsTest {
    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Tshirts testTshirt = new Tshirts(3," ","Hanes",3,"Black",3,5.98f);
        testTshirt.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, testTshirt.getName());
    }

    @Test // (1)
    public void constructorTest(){

        // (2)
        int expectedId = 6;
        String expectedName = "Amazing Spiderman";
        String expectedBrand = "Marvel";
        int expectedSize = 75;
        String expectedColor = "Black";
        int expectedQty = 10;
        float expectedPrice = 6.00f;

        // (3)
        Tshirts testTshirts = new Tshirts(expectedId, expectedName, expectedBrand,
                expectedSize, expectedColor, expectedQty, expectedPrice);

        // (4)
        Assertions.assertEquals(expectedId, testTshirts.getId());
        Assertions.assertEquals(expectedName, testTshirts.getName());
        Assertions.assertEquals(expectedBrand, testTshirts.getBrand());
        Assertions.assertEquals(expectedSize, testTshirts.getSize());
        Assertions.assertEquals(expectedQty, testTshirts.getQty());
        Assertions.assertEquals(expectedColor, testTshirts.getColor());
        Assertions.assertEquals(expectedPrice, testTshirts.getPrice());
    }
}
