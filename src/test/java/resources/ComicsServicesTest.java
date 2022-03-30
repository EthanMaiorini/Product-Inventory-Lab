package resources;

import models.Comics;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.ComicsServices;

public class ComicsServicesTest {
    @Test
    public void createTest(){

        // (1)
        String expectedName = "Amazing Spider-man";
        String expectedPublisher = "Marvel";
        int expectedIssueNumber = 10;
        int expectedQty = 10;
        double expectedGrade = 7.5;
        float expectedPrice = 80.00f;

        // (2)
        ComicsServices comicService = new ComicsServices();
        Comics testComic = ComicsServices.create(expectedName, expectedPublisher,
                expectedIssueNumber, expectedGrade, expectedQty, expectedPrice);

        // (3)
        int actualId = testComic.getId();
        String actualName = testComic.getName();
        String actualPublisher = testComic.getPublisher();
        int actualIssueNumber = testComic.getIssueNumber();
        double actualGrade = testComic.getGrade();
        int actualQty = testComic.getQty();
        float actualPrice = testComic.getPrice();

        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedPublisher, actualPublisher);
        Assertions.assertEquals(expectedIssueNumber, actualIssueNumber);
        Assertions.assertEquals(expectedGrade, actualGrade);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);

    }

    @Test
    public void findComicsTest(){
        // (1)
        String expectedName = "Amazing Spider-man";
        String expectedPublisher = "Marvel";
        int expectedIssueNumber = 10;
        int expectedQty = 10;
        double expectedGrade = 7.5;
        float expectedPrice = 80.00f;

        // (2)
        ComicsServices comicService = new ComicsServices();
        Comics testComic = ComicsServices.create(expectedName, expectedPublisher,
                expectedIssueNumber, expectedGrade, expectedQty, expectedPrice);

        // (3)
        Comics actualComic = comicService.findComics(testComic.getId());
        int actualId = actualComic.getId();
        String actualName = actualComic.getName();
        String actualPublisher = actualComic.getPublisher();
        int actualIssueNumber = actualComic.getIssueNumber();
        double actualGrade = actualComic.getGrade();
        int actualQty = actualComic.getQty();
        float actualPrice = actualComic.getPrice();


        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedPublisher, actualPublisher);
        Assertions.assertEquals(expectedIssueNumber, actualIssueNumber);
        Assertions.assertEquals(expectedGrade, actualGrade);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void findAllComicsTest(){
        // (1)
        String expectedName = "Amazing Spider-man";
        String expectedPublisher = "Marvel";
        int expectedIssueNumber = 10;
        int expectedQty = 10;
        double expectedGrade = 7.5;
        float expectedPrice = 80.00f;

        // (2)
        ComicsServices comicService = new ComicsServices();
        Comics testComic = ComicsServices.create(expectedName, expectedPublisher,
                expectedIssueNumber, expectedGrade, expectedQty, expectedPrice);

        // (3)
        Comics[] actualComic = comicService.findAllComics();
        int actualId = actualComic[0].getId();
        String actualName = actualComic[0].getName();
        String actualPublisher = actualComic[0].getPublisher();
        int actualIssueNumber = actualComic[0].getIssueNumber();
        double actualGrade = actualComic[0].getGrade();
        int actualQty = actualComic[0].getQty();
        float actualPrice = actualComic[0].getPrice();


        // (4)
        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedPublisher, actualPublisher);
        Assertions.assertEquals(expectedIssueNumber, actualIssueNumber);
        Assertions.assertEquals(expectedGrade, actualGrade);
        Assertions.assertEquals(expectedQty, actualQty);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void deleteTest(){
        String expectedName = "Amazing Spider-man";
        String expectedPublisher = "Marvel";
        int expectedIssueNumber = 10;
        int expectedQty = 10;
        double expectedGrade = 7.5;
        float expectedPrice = 80.00f;

        // (2)
        ComicsServices comicService = new ComicsServices();
        Comics testComic = ComicsServices.create(expectedName, expectedPublisher,
                expectedIssueNumber, expectedGrade, expectedQty, expectedPrice);

        // (3)
        int getInt = comicService.getId(testComic);
        Boolean actualComic = comicService.delete(getInt);



        // (4)
       Assertions.assertTrue(actualComic);
       //Assertions.assertEquals(true,);
    }

}
