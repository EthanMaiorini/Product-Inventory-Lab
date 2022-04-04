package io;

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

}

