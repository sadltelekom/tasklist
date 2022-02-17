import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Please give your DB password ");
        Scanner input = new Scanner(System.in);

        String password = input.nextLine();

        DBConnector dbConnector;

        try {
            dbConnector = new DBConnector(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}