package services;

import models.Comics;

import java.util.ArrayList;
import java.util.List;

public class ComicsServices {
    private static int nextId = 1;  // (1)

    private static List<Comics> inventory = new ArrayList<>();  // (2)

    public static Comics create(String expectedName, String expectedPublisher, int expectedIssueNumber, double expectedGrade, int expectedQty, float expectedPrice) {
        Comics createdComic = new Comics(nextId++, expectedName, expectedPublisher, expectedIssueNumber, expectedQty, expectedGrade, expectedPrice);

        // (3)
        inventory.add(createdComic);

        // (4)
        return createdComic;
    }

    //read
    public Comics findComics(int id) {
        // should take an int and return an object with that id, if exists
         Comics comic;
         for(Comics c: inventory){
             if(c.getId() == id)
                 return c;
         }
         return null;
    }

    public int getId(Comics name){
        int x = inventory.indexOf(name);
        Comics comic = inventory.get(x);
        return comic.getId();
    }

    //read all
    public Comics[] findAllComics() {
        // should return a basic array copy of the ArrayList
        Comics[] result = new Comics[inventory.size()];
        int x =0;
        for(Comics c : inventory) {
            result[x] = c;
            x++;
        }
        return result;
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        Comics comic = findComics(id);
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
