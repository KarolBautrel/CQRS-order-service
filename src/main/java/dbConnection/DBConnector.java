package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public void createOrderTables() throws SQLException {

        Statement statement = connection.createStatement();
        try{
        statement.execute("create table orders (car_id int, price double, status string);");
    }catch (SQLException e){
            System.out.println("TABLE ALREADY EXISTS");
        }

    }


    public OrderModel getOrderById(int car_id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM orders WHERE orders.car_id = '%s'".formatted(car_id));

        OrderModel orderModel = new OrderModel(
                resultSet.getInt("car_id"),
                resultSet.getDouble("price"),
                resultSet.getString("status")
        );
        System.out.println(orderModel.price);
        return orderModel;
    }
    public void insertOrderRow(int car_id, double price, String status) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into orders values('%s', '%s', '%s');".formatted(car_id, price, status));
    }

    public void updateStatus(int car_id, String status) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE orders SET status = '%s' WHERE car_id='%s'".formatted(status, car_id));
    }

    public boolean exist(int car_id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT EXISTS(SELECT * FROM orders WHERE orders.car_id = '%s');".formatted(car_id));
        return resultSet.getBoolean(1);
    }

    public void delete(int car_id) throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM orders WHERE orders.car_id = '%s';".formatted(car_id));
    }

}
