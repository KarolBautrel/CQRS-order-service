package order.repository;

import car.Car;
import dbConnection.DBConnector;
import dbConnection.OrderModel;
import order.Order;

import java.sql.SQLException;
import java.util.Optional;

public class OrderRepository {

    DBConnector dbConnector;

    public OrderRepository() throws SQLException {
        this.dbConnector = new DBConnector();
        this.dbConnector.connect();
        this.dbConnector.createOrderTables();
    }

    public boolean findOrderByCarId(int id) throws SQLException {
        return this.dbConnector.exist(id);
    }

    public  boolean createNewOrder(Car car) throws SQLException {
        if (this.findOrderByCarId(car.id)){
            System.out.println("Order with this ID is in database, updating status");
            this.dbConnector.updateStatus(car.id, "ORDERDER");
            return true;
        }
        this.dbConnector.insertOrderRow(car.id, car.price, "ORDERED");
        return true;
    }

    public void updateStatusOrder(int car_id,String status ) throws SQLException {
        this.dbConnector.updateStatus(car_id, status);
    }
    public void deleteOrder(int car_id) throws SQLException{
        this.dbConnector.delete(car_id);
        System.out.println("Deleted order of "+ car_id);

    }

    public OrderModel getOrderById(int car_id) throws SQLException {
        return this.dbConnector.getOrderById(3);
    }
}
