package project0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDao implements Dao<Patient> {

    Connection connection;
    Patient patient;

    public PatientDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void update(Patient e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Patient e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void insert(Patient e) {
      
    }


    @Override
    public List<Patient> getAll() {

        List<Patient> list = new ArrayList<>();
        PreparedStatement pStatement;
        try {
            pStatement = connection.prepareStatement("select * from patients");
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                Patient temp = new Patient(rSet.getString("ssn"), rSet.getString("fname"), rSet.getString("lname"), rSet.getInt("age"));
                list.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("unable to execute get All method");
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Patient> getEligible() {
        List<Patient> list = new ArrayList<>();
        PreparedStatement pStatement;
        try {
            pStatement = connection.prepareStatement("Select * from patients where age = 50 or age > 50");
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                Patient temp = new Patient(rSet.getString("ssn"), rSet.getString("fname"), rSet.getString("lname"), rSet.getInt("age"));
                list.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("unable to execute getEligible method");
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public List<Patient> getNotElligible() {
        List<Patient> list = new ArrayList<>();
        PreparedStatement pStatement;
        try {
            pStatement = connection.prepareStatement("Select * from patients where age < 50");
            ResultSet rSet = pStatement.executeQuery();
            while (rSet.next()) {
                Patient temp = new Patient(rSet.getString("ssn"), rSet.getString("fname"), rSet.getString("lname"), rSet.getInt("age"));
                list.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("unable to execute getNotEllegible method");
            e.printStackTrace();
        }
        return list;
    }

}
