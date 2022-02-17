import java.sql.*;
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
            categoriesList.add(categories);
        }
        return categoriesList;
    }
    public long addCategoryToDB(Categories categorie) throws SQLException {
        String sql = " INSERT INTO categories VALUES(default,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,categorie.getCategory());

        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        long key = 0;
        while (rs.next()) {
            key = rs.getLong(1);
        }

        return key;

    }
    public int updateCategoriesDBFromObject(Categories categorie) throws SQLException {
        String sql = "UPDATE categories SET category = ? WHERE id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,categorie.getCategory());
        preparedStatement.setLong(2,categorie.getId());

        return preparedStatement.executeUpdate();

    }

    public int deleteCategoriesDBFromObject(Categories categorie) throws SQLException {
        String sql = "DELETE FROM categories WHERE id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,categorie.getId());

        return preparedStatement.executeUpdate();

    }
    public int deleteCategoriesDBFromId(long id) throws SQLException {
        String sql = "DELETE FROM categories WHERE id = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,id);

        return preparedStatement.executeUpdate();

    }

}
