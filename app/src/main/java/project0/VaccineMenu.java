package project0;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class VaccineMenu {
//constructor 
VaccineMenu() {
}

/**
 * this is my main menu: 
 * @throws IOException
 */
public void show() throws IOException {

    boolean isOver = false; 
    int option = 0; 
    // String fileName = "C:/Users/user/IdeaProjects/Revature/project0/app/src/main/resources/textFile.txt";
    String fileName = "app/src/main/resources/textFile.txt";
    Scanner scanner  = new Scanner(System.in); 
    String lineBreak = "##################################################################";

    System.out.println(lineBreak);
    System.out.println("WELCOME TO THE COVID VACCINE CENTER!");
    System.out.println("1. To upload and see the list of names requesting a COVID vaccine ");
    System.out.println("2. See names of people who are eligible to get a COVID vaccine");
    System.out.println("3. See names of people in the waiting list for the vaccine");
    System.out.println("4. Export list of names to get COVID vaccine");
    System.out.println("5. Exit Menu");
    System.out.println(lineBreak);

    do {
        System.out.println("Please enter a number");
        option = scanner.nextInt(); 
        // option = option1;  

        switch(option) {
            case 1: 
                System.out.println("");
                System.out.println("##################################################################");
                VaccineMenu.ReadingFile(fileName); 
                System.out.println("##################################################################");

            break; 
            case 2: 
                System.out.println("");
                System.out.println("##################################################################");
                VaccineMenu.elegibility(fileName);
                System.out.println("##################################################################");
            break; 
            case 3: 
                System.out.println("");
                System.out.println("##################################################################");
                VaccineMenu.noElegible(fileName);
                System.out.println("##################################################################");
            break; 
            case 4: 
                System.out.println("");
                System.out.println("##################################################################");
                System.out.println("##################################################################");
            break; 
            case 5: 
                System.out.println("");
                System.out.println("##################################################################");
                System.out.println("Finishing session..");
                System.out.println("Bye!");
                System.out.println("##################################################################");
                scanner.close();
                isOver = true; 
            break; 
            default:
                System.out.println("oh, Wrong option number! Please, try again. "); 
                break; 
        }
    } while (!isOver);
}


//boiler plate code  = repeated code

/**
 * this method passes the text file name so it can read it and print it in the console
 * @param fileName
 */
public static void ReadingFile (String fileName) throws IOException {

    ReadFile file = new ReadFile(fileName); 
    String[] arrLines = file.OpenFile();
        
    for(int i=0; i<arrLines.length; i++) { 
        System.out.println(arrLines[i]);
    }             
}

/**
 * this method veryfies who is eligible to get a vaccine according to their ages
 * @param fileName
 * @throws IOException
 */
public static void elegibility (String fileName) throws IOException {

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    ReadFile file = new ReadFile(fileName);
    String[] arrLines = file.OpenFile(); 
    
    for(int i=0; i<arrLines.length; i++) {
        String line = arrLines[i]; 
        String[] parts = line.split(": ", 2);

        String key = parts[0];
        int value = Integer.parseInt(parts[1]);
        map.put(key, value); 

        if (value > 50) System.out.println(key + ":" + map.get(key));
        
    }
}

/**
 * this method veryfies who is NOT eligible to get a vaccine according to their ages
 * @param fileName
 * @throws IOException
 */
public static void noElegible (String fileName) throws IOException {

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    ReadFile file = new ReadFile(fileName);
    String[] arrLines = file.OpenFile(); 
    
    for(int i=0; i<arrLines.length; i++) {
        String line = arrLines[i]; 
        String[] parts = line.split(": ", 2);

        String key = parts[0];
        int value = Integer.parseInt(parts[1]);
        map.put(key, value); 

        if (value < 50) System.out.println(key + ":" + map.get(key));      
    }
}

// eliminate two for loops and use the first for loop; 

}

