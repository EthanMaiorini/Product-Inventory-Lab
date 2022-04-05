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

    public Tshirts findTshirts(int id) {
        // should take an int and return an object with that id, if exists
        Tshirts comic;
        for(Tshirts c: inventory){
            if(c.getId() == id)
                return c;
        }
        return null;
    }

    public int getId(Tshirts name){
        int x = inventory.indexOf(name);
        Tshirts comic = inventory.get(x);
        return comic.getId();
    }

    //read all
    public Tshirts[] findAllTshirts() {
        // should return a basic array copy of the ArrayList
        Tshirts[] result = new Tshirts[inventory.size()];
        int x =0;
        for(Tshirts c : inventory) {
            result[x] = c;
            x++;
        }
        return result;
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        Tshirts comic = findTshirts(id);
        if(comic != null) {
            inventory.remove(comic);
            return true;
        }
        return false;
    }

    public void changeInventory(int id, int amount){
        inventory.get(id).setQty(amount);
    }
}
