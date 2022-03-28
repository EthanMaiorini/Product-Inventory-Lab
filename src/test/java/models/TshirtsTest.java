package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TshirtsTest {
    @Test
    public void setNameTest() {
        // given (1)
        String expected = "OZWEEGO";

        // when (2)
        Tshirts testTshirt = new Tshirts();
        testTshirt.setName(expected);

        // then (3)
        Assertions.assertEquals(expected, testTshirt.getName());
    }
}
