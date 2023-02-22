package order.subscriber;

import car.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbConnection.DBConnector;
import order.Order;
import order.service.OrderService;
import redisService.RedisHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderSubscriber {

    OrderService orderService;
    RedisHandler redisHandler;


    public OrderSubscriber() {
       this.orderService = new OrderService();
       this.redisHandler = new RedisHandler();
    }
    ObjectMapper objectMapper = new ObjectMapper();


    public void checkEvent() throws JsonProcessingException {
        List<String> events = this.redisHandler.get_event();
        for (String event: events){

            Order order = objectMapper.readValue(event, Order.class);
            if (order.routing_key.equals("order")){
                switch (order.event){
                    case "car_ordered":
                        this.orderService.updateOrderStatus(order.car);
                }
            }


        }

    }


}
