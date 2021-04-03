package project0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VaccineMenu {

    public void show() throws IOException {
        boolean isOver = false;
        int option = 0;
        String fileName = "app/src/main/resources/myfile.csv";
        Scanner scanner = new Scanner(System.in);
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

            switch (option) {
            case 1:
                System.out.println("");
                System.out.println(lineBreak);
                ReadingFile(fileName);
                System.out.println(lineBreak);

                break;
            case 2:
                System.out.println("");
                System.out.println(lineBreak);
                elegibility(fileName);
                System.out.println(lineBreak);
                break;
            case 3:
                System.out.println("");
                System.out.println(lineBreak);
                noElegible(fileName);
                System.out.println(lineBreak);
                break;
            case 4:
                System.out.println("");
                System.out.println(lineBreak);
                System.out.println(lineBreak);
                break;
            case 5:
                System.out.println("");
                System.out.println(lineBreak);
                System.out.println("Finishing session..");
                System.out.println("Bye!");
                System.out.println(lineBreak);
                scanner.close();
                isOver = true;
                break;
            default:
                System.out.println("oh, Wrong option number! Please, try again. ");
                break;
            }
        } while (!isOver);
    }

    public void ReadingFile(String fileName) throws IOException {
        ReadFile2 file = new ReadFile2(fileName);
        ArrayList<String> arrLines = file.OpenFile();

        arrLines.forEach(e -> {
            System.out.println(e);
        });
    }

    public void elegibility(String fileName) throws IOException {
        ReadFile2 file = new ReadFile2(fileName);
        ArrayList<String> arrLines = file.OpenFile();
        ArrayList<String> patientFname = new ArrayList<>(arrLines.size());
        ArrayList<String> patientLname = new ArrayList<>(arrLines.size());
        ArrayList<Integer> patientAge = new ArrayList<>(arrLines.size());

        for (int i = 0; i < arrLines.size(); i++) {
            String singleLine = arrLines.get(i);
            String[] moreLines = singleLine.split(",");

            patientFname.add(moreLines[0]);
            patientLname.add(moreLines[1]);
            patientAge.add(Integer.parseInt(moreLines[2]));

            if (patientAge.get(i) > 50 || patientAge.get(i) == 50) {
                System.out.println(patientFname.get(i) + " " + patientLname.get(i) + " " + patientAge.get(i));
            }
        }
    }

    public void noElegible(String fileName) throws IOException {
        ReadFile2 file = new ReadFile2(fileName);
        ArrayList<String> arrLines = file.OpenFile();
        ArrayList<String> patientFname = new ArrayList<>(arrLines.size());
        ArrayList<String> patientLname = new ArrayList<>(arrLines.size());
        ArrayList<Integer> patientAge = new ArrayList<>(arrLines.size());

        for (int i = 0; i < arrLines.size(); i++) {
            String singleLine = arrLines.get(i);
            String[] moreLines = singleLine.split(",");

            patientFname.add(moreLines[0]);
            patientLname.add(moreLines[1]);
            patientAge.add(Integer.parseInt(moreLines[2]));

            if (patientAge.get(i) < 50) {
                System.out.println(patientFname.get(i) + " " + patientLname.get(i) + " " + patientAge.get(i));
            }
        }
    }

}
