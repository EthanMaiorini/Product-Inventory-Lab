package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComicsTest {
    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Comics testComic = new Comics();
        testComic.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, testComic.getName());
    }
}
