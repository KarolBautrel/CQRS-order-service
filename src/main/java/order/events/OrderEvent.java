package order.events;

import car.Car;
import order.Order;

public class OrderEvent {

    public String event;
    public String routing_key;
    public int carId;

    public double orderPrice;

    public String orderStatus;


    public OrderEvent(String event, String routing_key, int carId, double orderPrice, String orderStatus) {
        this.event = event;
        this.routing_key = routing_key;
        this.carId = carId;
        this.orderPrice = orderPrice;
        this.orderStatus = orderStatus;
    }
}
