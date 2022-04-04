import io.Console;
import models.Comics;
import services.ComicsServices;
import services.TshirtServices;

import java.util.Scanner;

public class App {
    private ComicsServices comicsService = new ComicsServices(); // (1)
    private TshirtServices tshirtServices = new TshirtServices();

    public static void main(String... args){
        App application = new App(); // (2)
        application.init();  // (3)
    }

    public void init(){
        Scanner sc = new Scanner(System.in);
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        Console.printWelcome();
        Console.printChoiceScreen();
        int choice = sc.nextInt();
        if(choice == 1){
            //run comics
            Console.inventoryChoiceScreen();
            runComicMethods(sc.nextInt());
        }else if (choice == 2){
            // run Tshirts
        }else System.out.println("Enter a valid choice.");
    }

    private void runComicMethods(int nextInt) {
        Scanner scanner = new Scanner(System.in);
        while(nextInt != 6){
            if(nextInt == 1) {
                //create comic
                createNewComic();
                //comicsService.create();
            }else if (nextInt == 2){
                //findAll
                printAllComics();
            }else if(nextInt == 3){
                //update
            }else if(nextInt == 4){
                //delete
                deleteComics();
            }else if (nextInt == 5) {
                //get info find
                findComic();
            }
            Console.inventoryChoiceScreen();
            nextInt = scanner.nextInt();
        }
    }

    private void findComic() {
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Which comic id would you like to see info on:");
        comicsService.findComics(id);
    }

    private void deleteComics() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which comic id would you like to delete: ");
        int delete = scanner.nextInt();
        comicsService.delete(delete);
    }

    private void printAllComics() {
        Comics[] comics = comicsService.findAllComics();
        for(Comics c : comics)
            System.out.println(c.toString());
    }

    private void createNewComic() {
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
        comicsService.create(name,pub,num,grade,qty,price);
    }
}
