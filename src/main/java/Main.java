import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.print("Please give your DB password ");
        Scanner input = new Scanner(System.in);

        String password = input.nextLine();

        DBConnector dbConnector = null;

        try {
            dbConnector = new DBConnector(password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Task> taskArrayList = new ArrayList<>();
        TaskDB taskDB = new TaskDB(dbConnector.getConnection());

        taskArrayList = taskDB.getAllTasksByTitle();

        for(Task task:taskArrayList) {
            System.out.println(task);
        }

        CategoriesDB categoriesDB = new CategoriesDB(dbConnector.getConnection());

        List<Categories> categoriesArrayList = new ArrayList<>();
        categoriesArrayList = categoriesDB.getAllCategories();

        for(Categories category: categoriesArrayList) {
            System.out.println(category);
        }

    }
}