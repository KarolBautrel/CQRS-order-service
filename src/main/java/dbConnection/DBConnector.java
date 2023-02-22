package dbConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DBConnector {
    private Connection connection;
    public DBConnector() {
    }
    public void connect() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:sqlite:orders.db");
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
    public void createTables() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("create table orders (car_id int, price double, status string);");
    }

    public void insertRow(int car_id, double price, String status) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into orders values('%s', '%s', '%s');".formatted(car_id, price, status));
    }

    public boolean exist(int car_id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT EXISTS(SELECT * FROM orders WHERE order.car_id = '%s');".formatted(car_id));
        return resultSet.getBoolean(1);
    }

    public void delete(int car_id) throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM orders WHERE orders.car.id = '%s');".formatted(car_id));
    }

}
