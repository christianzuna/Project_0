package project0;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VaccineMenu {

    public Connection connection;
    public String fileName = "app/src/main/resources/myfile.csv";

    public void show() throws IOException {
        boolean isOver = false;
        int option = 0;
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
                connectingDB(connection, fileName);
                System.out.println(lineBreak);

                break;
            case 2:
                System.out.println("");
                System.out.println(lineBreak);
                // PatientDao.elegibility(fileName);
                System.out.println(lineBreak);
                break;
            case 3:
                System.out.println("");
                System.out.println(lineBreak);
                // noElegible(fileName);
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

    public void connectingDB(Connection connection, String filename) throws IOException {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";

        try {
            ReadFile2 file = new ReadFile2(fileName);
            ArrayList<String> arrLines = file.OpenFile();
            connection = DriverManager.getConnection(url, username, password);

            for (int i = 0; i < arrLines.size(); i++) {
                String singleLine = arrLines.get(i);
                String[] moreLines = singleLine.split(",");
                PreparedStatement pStatement = connection
                        .prepareStatement("insert into patients(ssn, fname, lname, age) values (?, ?, ?, ?)");

                Patient tempPatient = new Patient(moreLines[0], moreLines[1], moreLines[2],
                        Integer.parseInt(moreLines[3]));
                pStatement.setString(1, tempPatient.getSsn());
                pStatement.setString(2, tempPatient.getFname());
                pStatement.setString(3, tempPatient.getLname());
                pStatement.setInt(4, tempPatient.getAge());
                pStatement.executeUpdate();
            }

            PatientDao pDao = new PatientDao(connection);
            List<Patient> list = pDao.getAll();
            list.forEach(str -> System.out.println(str));
            

        } catch (SQLException e) {
            System.err.println("DATABASE connection interrupted " + e);
        }
    }

}
