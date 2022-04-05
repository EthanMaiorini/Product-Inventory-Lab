package io;

import models.Comics;
import services.ComicsServices;
import services.TshirtServices;

import java.awt.*;
import java.util.Scanner;

public class Console {
        public static void printWelcome(){
            System.out.println("" +
                    "**************************************************\n" +
                    "***           Welcome and Bienvenue            ***\n" +
                    "***                    to                      ***\n" +
                    "***          ZipCo Inventory Manager           ***\n" +
                    "**************************************************\n");
        }

        public static void printChoiceScreen(){
            System.out.println("Which Product would you like to work with?");
            System.out.println("1. Comics 2. Tshirts");
        }

        public static void inventoryChoiceScreen(){
            System.out.println("What would you like to do?");
            System.out.println("1. Add Products");
            System.out.println("2. Print existing products");
            System.out.println("3. Update products");
            System.out.println("4. Delete products");
            System.out.println("5. Get info from inventory");
            System.out.println("6. Exit");

        }

    public static void createNewComic(ComicsServices comicsServices) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a comic name: ");
        String name = scanner.next();
        System.out.println("Please enter the publisher: ");
        String pub = scanner.next();
        System.out.println("Please enter the issue number: ");
        int num = scanner.nextInt();
        System.out.println("Please enter the grade: ");
        double grade = scanner.nextDouble();
        System.out.println("Please enter the quantity number: ");
        int qty = scanner.nextInt();
        System.out.println("Please enter the price: ");
        float price = scanner.nextFloat();
        comicsServices.create(name,pub,num,grade,qty,price);
    }

    public static int deleteComics() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which comic id would you like to delete: ");
        int delete = scanner.nextInt();
        return delete;
    }

    public static int findComic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which comic id would you like to see info on:");
        int id = scanner.nextInt();
        return id;
    }

    public static void createNewTshirt(TshirtServices tshirtsServices) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a Tshirt name: ");
        String name = scanner.next();
        System.out.println("Please enter Brand: ");
        String pub = scanner.next();
        System.out.println("Please enter the size: ");
        int num = scanner.nextInt();
        System.out.println("Please enter the color: ");
        Color color = Color.decode(scanner.next());
        System.out.println("Please enter the quantity number: ");
        int qty = scanner.nextInt();
        System.out.println("Please enter the price: ");
        float price = scanner.nextFloat();
        tshirtsServices.create(name,pub,num,color,qty,price);
    }

    public static int deleteTshirts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Tshirt id would you like to delete: ");
        int delete = scanner.nextInt();
        return delete;
    }

    public static int findTshirt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which comic id would you like to see info on:");
        int id = scanner.nextInt();
        return id;
    }

    public static void changeTshirtQty(TshirtServices tshirtService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which tshirt id would you like to change the inventory for?");
        int id = scanner.nextInt();
        System.out.println("What would you like to change the inventory to?");
        int amount = scanner.nextInt();
        tshirtService.changeInventory(id,amount);
    }

    public static void changeComicQty(ComicsServices comicsService) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which comic id would you like to change the inventory for?");
        int id = scanner.nextInt();
        System.out.println("What would you like to change the inventory to?");
        int amount = scanner.nextInt();
        comicsService.changeInventory(id,amount);
    }
}

