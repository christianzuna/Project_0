package project0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class AppTest {
    @Test void appHasArray() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";

        Connection connection;
        connection = DriverManager.getConnection(url, username, password);

        PatientDao classUnderTest = new PatientDao(connection);
        assertNotNull(classUnderTest.getEligible(), "method should return an array");
    }

    @Test void appHasArray2() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "password";

        Connection connection;
        connection = DriverManager.getConnection(url, username, password);

        PatientDao classUnderTest = new PatientDao(connection);
        assertNotNull(classUnderTest.getNotElligible(), "method should return an array");
    }
}
