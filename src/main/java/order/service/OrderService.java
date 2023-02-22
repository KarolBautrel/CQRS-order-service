package order.service;

import car.Car;
import order.publisher.OrderPublisher;
import order.repository.OrderRepository;

public class OrderService {

    OrderRepository orderRepository;
    OrderPublisher orderPublisher;

    public OrderService(){
        this.orderPublisher=new OrderPublisher();
        this.orderRepository = new OrderRepository();

    }

    public void updateOrderStatus(Car car){
        this.orderRepository.findOrderByCarId(car.id);
    }

}
