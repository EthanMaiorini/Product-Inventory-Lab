package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComicsTest {
    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Comics testComic = new Comics(7," ","DC",1,1,8.2,27.95f);
        testComic.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, testComic.getName());
    }

    @Test // (1)
    public void constructorTest(){

        // (2)
        int expectedId = 6;
        String expectedName = "Amazing Spiderman";
        String expectedPublisher = "Marvel";
        int expectedIssueNumber = 75;
        String expectedSport = "Tennnis";
        int expectedQty = 10;
        double expectedGrade = 8.5;
        float expectedPrice = 6.00f;

        // (3)
        Comics testComics = new Comics(expectedId, expectedName, expectedPublisher,
                expectedIssueNumber, expectedQty,expectedGrade,expectedPrice);

        // (4)
        Assertions.assertEquals(expectedId, testComics.getId());
        Assertions.assertEquals(expectedName, testComics.getName());
        Assertions.assertEquals(expectedPublisher, testComics.getPublisher());
        Assertions.assertEquals(expectedIssueNumber, testComics.getIssueNumber());
        Assertions.assertEquals(expectedQty, testComics.getQty());
        Assertions.assertEquals(expectedGrade, testComics.getGrade());
        Assertions.assertEquals(expectedPrice, testComics.getPrice());
    }
}
