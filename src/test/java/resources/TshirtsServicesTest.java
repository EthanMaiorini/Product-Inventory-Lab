package resources;

import models.Comics;
import models.Tshirts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.ComicsServices;
import services.TshirtServices;

import java.awt.*;

public class TshirtsServicesTest {

    @Test
    public void createTest(){

        // (1)
        String expectedName = "Amazing Spider-man";
        String expectedBrand = "Marvel";
        int expectedSize = 10;
        int expectedQty = 10;
        Color expectedColor = Color.BLACK;
        float expectedPrice = 80.00f;

        // (2)
        TshirtServices tshirtService = new TshirtServices();
        Tshirts testTshirts = TshirtServices.create(expectedName, expectedBrand,
                expectedSize, expectedColor, expectedQty, expectedPrice);

        // (3)
        int actualId = testTshirts.getId();
        String actualName = testTshirts.getName();
        String actualBrand = testTshirts.getBrand();
        int actualSize = testTshirts.getSize();
        Color actualColor = testTshirts.getColor();
        int actualQty = testTshirts.getQty();
        float actualPrice = testTshirts.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedColor, actualColor);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);

    }
}
