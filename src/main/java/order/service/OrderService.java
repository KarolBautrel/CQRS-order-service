package order.service;

import car.Car;
import order.publisher.OrderPublisher;
import order.repository.OrderRepository;

import java.sql.SQLException;

public class OrderService {

    OrderRepository orderRepository;
    OrderPublisher orderPublisher;

    public OrderService() throws SQLException {
        this.orderPublisher=new OrderPublisher();
        this.orderRepository = new OrderRepository();

    }

    public boolean checkOrderStatusExists(Car car) throws SQLException {
        return this.orderRepository.findOrderByCarId(car.id);
    }

    public void createOrderStatus(Car car) throws SQLException {
        this.orderRepository.createNewOrder(car);
    }

    public void cancelOrder(int id) throws  SQLException{
        this.orderRepository.deleteOrder(id);
    }

}
