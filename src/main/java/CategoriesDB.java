import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDB {
    private Connection connection;

    public CategoriesDB(Connection connection) {
        this.connection = connection;
    }
    public List<Categories> getAllCategories() throws SQLException {

        List<Categories> categoriesList = new ArrayList<>();

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM categories";

        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {

            Categories categories =new Categories(
                    result.getLong("ID"),
                    result.getString("Category")
            );
        }
        return categoriesList;
    }
}
