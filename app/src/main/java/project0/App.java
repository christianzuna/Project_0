package project0;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        VaccineMenu mainMenu = new VaccineMenu();
        try {
            mainMenu.show();
        } catch (IOException e) {
            System.out.println("unable to open menu");
            e.printStackTrace();
        }  
    }
}
