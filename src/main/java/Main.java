import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("tasklist");
        DBConnector dbConnector;

        try {
            dbConnector = new DBConnector();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
