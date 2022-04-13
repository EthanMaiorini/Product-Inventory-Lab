package services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import models.Comics;
import models.Tshirts;
import utils.CSVUtils;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TshirtServices {
    private static int nextId = 1;  // (1)

    private static List<Tshirts> inventory = new ArrayList<>();  // (2)

    public static Tshirts create(String expectedName, String expectedBrand, int expectedSize, String expectedColor, int expectedQty, float expectedPrice) {
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

    public int getIndex(String name){
        int x = 0;
        for(Tshirts c: inventory){
            if(c.getName().equals(name))
                return x;
            x++;
        }
        return -1;
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
        Tshirts c = findTshirts(id);
        int x = getIndex(c.getName());
        inventory.get(x).setQty(amount);
    }

    public void saveData() throws IOException {
        String csvFile = "/Users/ethan/Desktop/Tshirts.csv";
        FileWriter writer = new FileWriter(csvFile); //(1)

        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));  // (2)

//        for (Tshirts s : inventory) {
//            List<String> list = new ArrayList<>(); // (3)
//            list.add(String.valueOf(s.getId()));
//            list.add(s.getName());
//            list.add(s.getBrand());
//            list.add(String.valueOf(s.getSize()));
//            list.add(String.valueOf(s.getColor()));
//            list.add(String.valueOf(s.getQty()));
//            list.add(String.valueOf(s.getPrice()));
//
//            CSVUtils.writeLine(writer, list);
//        }
        writer.flush();
        writer.close();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer1 = mapper.writer(new DefaultPrettyPrinter());
        writer1.writeValue(new File("tshirts.json"), inventory);
    }

    public void loadData() throws IOException {
        String csvFile = "/Users/ethan/dev/Product-Inventory-Lab/Tshirts.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());

//            while ((line = br.readLine()) != null) {
//                // split line with comma
//                String[] beer = line.split(csvSplitBy);
//
//                int id = Integer.parseInt(beer[0]);
//                String name = beer[1];
//                String brand = beer[2];
//                int size = Integer.parseInt(beer[3]);
//                Color color = Color.decode(beer[4]);
//                int qty = Integer.parseInt(beer[5]);
//                float price = Float.parseFloat(beer[6]);
//
//                // (5)
//                inventory.add(new Tshirts(id, name, brand, size, color, qty, price));
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        this.inventory = objectMapper.readValue(new File("tshirts.json"), new TypeReference<List<Tshirts>>(){});
    }
}
