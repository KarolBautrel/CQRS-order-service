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
        this.dbConnector.createTables();
    }

    public boolean findOrderByCarId(int id) throws SQLException {
        return this.dbConnector.exist(id);
    }

    public boolean createNewOrder(Car car) throws SQLException {
        if (this.findOrderByCarId(car.id)){
            System.out.println("Order with this ID is in database");
            return false;
        }
        this.dbConnector.insertRow(car.id, car.price, "ORDERED");
        return true;
    }

    public void deleteOrder(int car_id) throws SQLException{
        this.dbConnector.delete(car_id);
        System.out.println("Deleted order of "+ car_id);

    }


}
