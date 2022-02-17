import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDB {


    private final Connection connection;

    public TaskDB(Connection connection) {
        this.connection = connection;
    }

    private List<Task> getAllTasksBy(String orderBy) throws SQLException {

        List<Task> tasks = new ArrayList<>();

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM tasks ORDER BY " + orderBy;

        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            Task task = new Task(
                    result.getLong("id"),
                    result.getLong("category_id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getTimestamp("created_date"),
                    result.getTimestamp("due_date"),
                    result.getBoolean("done")
            );
//            System.out.println(result.getDate("created_date"));
//            System.out.println(result.getDate("due_date"));

            tasks.add(task);
        }

        return tasks;
    }

    public List<Task> getAllTasksByCategory() throws SQLException {

        List<Task> tasks = new ArrayList<>();

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM tasks JOIN categories ON tasks.category_id =categories.id ORDER BY categories.category";

        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            Task task = new Task(
                    result.getLong("id"),
                    result.getLong("category_id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getTimestamp("created_date"),
                    result.getTimestamp("due_date"),
                    result.getBoolean("done")
            );

            tasks.add(task);
        }

        return tasks;
    }

    public List<Task> getAllTasksByTitle() throws SQLException {
        return getAllTasksBy("title");
    }

    public List<Task> getAllTasksByCreatedDate() throws SQLException {
        return getAllTasksBy("created_date");
    }

    public List<Task> getAllTasksByDueDate() throws SQLException {
        return getAllTasksBy("due_date");
    }

    public List<Task> getAllTasksFilterByCategory(String filter) throws SQLException {

        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks JOIN categories ON tasks.category_id =categories.id WHERE categories.category LIKE ? ORDER BY categories.category";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "%" + filter + "%");
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Task task = new Task(
                    result.getLong("id"),
                    result.getLong("category_id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getTimestamp("created_date"),
                    result.getTimestamp("due_date"),
                    result.getBoolean("done")
            );

            tasks.add(task);
        }

        return tasks;
    }

    public List<Task> getAllTasksFilterByTitle(String filter) throws SQLException {

        List<Task> tasks = new ArrayList<>();

        String sql = "SELECT * FROM tasks WHERE title LIKE ? ORDER BY title";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "%" + filter + "%");
        ResultSet result = preparedStatement.executeQuery();

        while (result.next()) {
            Task task = new Task(
                    result.getLong("id"),
                    result.getLong("category_id"),
                    result.getString("title"),
                    result.getString("description"),
                    result.getTimestamp("created_date"),
                    result.getTimestamp("due_date"),
                    result.getBoolean("done")
            );

            tasks.add(task);
        }

        return tasks;
    }


}
