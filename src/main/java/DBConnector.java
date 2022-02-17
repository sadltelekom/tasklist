import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
   private Connection connection;

    public DBConnector() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tasklist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                "Risteski1987");
    }
    public DBConnector(String password) throws SQLException {

        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tasklist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                password);
    }

    public Connection getConnection() {
        return connection;
    }
}
