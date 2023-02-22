package order.repository;

import car.Car;
import dbConnection.DBConnector;
import order.Order;

import java.sql.SQLException;
import java.util.Optional;

public class OrderRepository {

    DBConnector dbConnector;

    public OrderRepository() throws SQLException {
        this.dbConnector = new DBConnector();
        this.dbConnector.connect();
       // this.dbConnector.createTables();
    }

    public boolean findOrderByCarId(int id) throws SQLException {
        return this.dbConnector.exist(id);
    }

    public void createNewOrder(Car car) throws SQLException {
        System.out.println("ADding new order");
        this.dbConnector.insertRow(car.id, car.price, "ORDERED");
    }

    public void deleteOrder(int id) throws SQLException{
        System.out.println("Deleted order of "+ id);

    }


}
