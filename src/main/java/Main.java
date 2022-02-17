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

        taskArrayList = taskDB.getAllTasksFilterByTitle("My");

        for(Task task:taskArrayList) {
            System.out.println(task);
        }

        CategoriesDB categoriesDB = new CategoriesDB(dbConnector.getConnection());

        List<Categories> categoriesArrayList = new ArrayList<>();
        categoriesArrayList = categoriesDB.getAllCategories();

        for(Categories category: categoriesArrayList) {
            System.out.println(category);
        }

        Task newTask = new Task(2,"Finish our software","Make some working code maybe",null,null,false);
        long newTaskToBedeletedlater = taskDB.addTaskToDB(newTask);

        Task changeTask = new Task(1,1,"My First Task", "It i not so nice",null,null,false);

        taskDB.updateTaskFromDB(changeTask);

        taskDB.deleteTaskFromDB(newTaskToBedeletedlater);
      
        Categories newCategorie = new Categories("Something else");

       long id = categoriesDB.addCategoryToDB(newCategorie);

       Categories toChangeCategory = new Categories(id, "Something something");

       categoriesDB.updateCategoriesDBFromObject(toChangeCategory);

       categoriesDB.deleteCategoriesDBFromId(5L);



    }
}