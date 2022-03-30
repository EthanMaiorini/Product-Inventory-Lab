package services;

import models.Comics;
import models.Tshirts;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TshirtServices {
    private static int nextId = 1;  // (1)

    private static List<Tshirts> inventory = new ArrayList<>();  // (2)

    public static Tshirts create(String expectedName, String expectedBrand, int expectedSize, Color expectedColor, int expectedQty, float expectedPrice) {
        Tshirts createdTshirt = new Tshirts(nextId++, expectedName, expectedBrand, expectedSize, expectedColor, expectedQty, expectedPrice);

        // (3)
        inventory.add(createdTshirt);

        // (4)
        return createdTshirt;
    }
}
