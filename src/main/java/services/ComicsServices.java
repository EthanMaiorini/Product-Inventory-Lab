package services;

import models.Comics;
import utils.CSVUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    public void saveData() throws IOException {
        String csvFile = "/Users/ethan/dev/Product-Inventory-Lab/src/Comics.csv";
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));

        for (Comics s : inventory) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getPublisher());
            list.add(String.valueOf(s.getIssueNumber()));
            list.add(String.valueOf(s.getQty()));
            list.add(String.valueOf(s.getGrade()));
            list.add(String.valueOf(s.getPrice()));

            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }

    public void loadData(){
        String csvFile = "/Users/ethan/dev/Product-Inventory-Lab/src/Comics.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());

            while ((line = br.readLine()) != null) {
                // split line with comma
                String[] beer = line.split(csvSplitBy);

                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String publisher = beer[2];
                int issueNumber = Integer.parseInt(beer[3]);
                int qty = Integer.parseInt(beer[4]);
                double grade = Double.parseDouble(beer[5]);
                float price = Float.parseFloat(beer[6]);

                // (5)
                inventory.add(new Comics(id, name, publisher, issueNumber, qty, grade, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
