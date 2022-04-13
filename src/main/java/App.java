import io.Console;
import models.Comics;
import models.Tshirts;
import services.ComicsServices;
import services.TshirtServices;

import java.io.IOException;
import java.util.Scanner;

public class App {
    private ComicsServices comicsService = new ComicsServices(); // (1)
    private TshirtServices tshirtServices = new TshirtServices();

    public static void main(String... args) throws IOException {
        App application = new App(); // (2)
        application.init();  // (3)
    }

    public void init() throws IOException {
        Scanner sc = new Scanner(System.in);
        //
         comicsService.loadData();
      //  tshirtServices.loadData();
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
            Console.inventoryChoiceScreen();
            runTshirtMethods(sc.nextInt());
        }else System.out.println("Enter a valid choice.");
        comicsService.saveData();
        tshirtServices.saveData();
    }

    private void runTshirtMethods(int nextInt) {
        Scanner scanner = new Scanner(System.in);
        while(nextInt != 6){
            if(nextInt == 1) {
                //create comic
                Console.createNewTshirt(tshirtServices);
                //comicsService.create();
            }else if (nextInt == 2){
                //findAll
                Tshirts[] tshirts = tshirtServices.findAllTshirts();
                for(Tshirts c : tshirts)
                    System.out.println(c.toString());
            }else if(nextInt == 3){
                //update
                Console.changeTshirtQty(tshirtServices);
            }else if(nextInt == 4){
                //delete
                int delete = Console.deleteTshirts();
                comicsService.delete(delete);
            }else if (nextInt == 5) {
                //get info find
                int id = Console.findTshirt();
                System.out.println(tshirtServices.findTshirts(id).toString());
            }
            Console.inventoryChoiceScreen();
            nextInt = scanner.nextInt();
        }
    }

    private void runComicMethods(int nextInt) {
        Scanner scanner = new Scanner(System.in);
        while(nextInt != 6){
            if(nextInt == 1) {
                //create comic
                Console.createNewComic(comicsService);
                //comicsService.create();
            }else if (nextInt == 2){
                //findAll
                Comics[] comics = comicsService.findAllComics();
                for(Comics c : comics)
                    System.out.println(c.toString());
            }else if(nextInt == 3){
                //update
                Console.changeComicQty(comicsService);
            }else if(nextInt == 4){
                //delete
                int delete = Console.deleteComics();
                comicsService.delete(delete);
            }else if (nextInt == 5) {
                //get info find
               int id = Console.findComic();
                System.out.println(comicsService.findComics(id).toString());
            }
            Console.inventoryChoiceScreen();
            nextInt = scanner.nextInt();
        }
    }








}
