package order.service;

import car.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import dbConnection.OrderModel;
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

    public void createOrder(Car car) throws JsonProcessingException, SQLException {
        if(this.orderRepository.createNewOrder(car)){
            this.orderPublisher.publishEvent(car.id, car.price, "ORDERED");

        };
    }

    public void cancelOrder(int car_id) throws  SQLException{
       if (this.orderRepository.findOrderByCarId(car_id)){
            this.orderRepository.updateStatusOrder(car_id, "CANCELED");
           System.out.println("ORDER UPDATED");
       };
    }

    public OrderModel getOrderById(int car_id) throws SQLException {
        return this.orderRepository.getOrderById(3);
    }

}
