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
        String expectedColor = "Black";
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
        String actualColor = testTshirts.getColor();
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

    @Test
    public void findComicsTest(){
        // (1)
        String expectedName = "Amazing Spider-man";
        String expectedBrand = "Marvel";
        int expectedSize = 10;
        int expectedQty = 10;
        String expectedColor = "Black";
        float expectedPrice = 80.00f;

        // (2)
        TshirtServices tshirtsService = new TshirtServices();
        Tshirts testTshirts = TshirtServices.create(expectedName, expectedBrand,
                expectedSize, expectedColor, expectedQty, expectedPrice);

        // (3)
        Tshirts actualTshirts = tshirtsService.findTshirts(testTshirts.getId());
        int actualId = actualTshirts.getId();
        String actualName = actualTshirts.getName();
        String actualBrand = actualTshirts.getBrand();
        String actualColor = actualTshirts.getColor();
        int actualSize = actualTshirts.getSize();
        int actualQty = actualTshirts.getQty();
        float actualPrice = actualTshirts.getPrice();


        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedColor, actualColor);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void findAllComicsTest(){
        // (1)
        String expectedName = "Amazing Spider-man";
        String expectedBrand = "Marvel";
        int expectedSize = 10;
        int expectedQty = 10;
        String expectedColor = "Black";
        float expectedPrice = 80.00f;

        // (2)
        TshirtServices tshirtsService = new TshirtServices();
        Tshirts testTshirts = TshirtServices.create(expectedName, expectedBrand,
                expectedSize, expectedColor, expectedQty, expectedPrice);

        // (3)
        Tshirts[] actualTshirts = tshirtsService.findAllTshirts();
        int actualId = actualTshirts[0].getId();
        String actualName = actualTshirts[0].getName();
        String actualBrand = actualTshirts[0].getBrand();
        String actualColor = actualTshirts[0].getColor();
        int actualSize = actualTshirts[0].getSize();
        int actualQty = actualTshirts[0].getQty();
        float actualPrice = actualTshirts[0].getPrice();


        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedColor, actualColor);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void deleteTest(){
        String expectedName = "Amazing Spider-man";
        String expectedBrand = "Marvel";
        int expectedSize = 10;
        int expectedQty = 10;
        String expectedColor = "Black";
        float expectedPrice = 80.00f;

        // (2)
        TshirtServices tshirtsService = new TshirtServices();
        Tshirts testTshirts = TshirtServices.create(expectedName, expectedBrand,
                expectedSize, expectedColor, expectedQty, expectedPrice);

        // (3)
        int getInt = tshirtsService.getId(testTshirts);
        Boolean actualTshirt = tshirtsService.delete(getInt);



        // (4)
        Assertions.assertTrue(actualTshirt);
        //Assertions.assertEquals(true,);
    }

}
