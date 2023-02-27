package order.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import dbConnection.OrderModel;
import order.events.OrderEvent;
import order.service.OrderService;
import redisService.RedisHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderPublisher {

    RedisHandler redisHandler;

    public OrderPublisher()  {
        this.redisHandler = new RedisHandler();
    }

    public void publishEvent(int carId, double orderPrice, String orderStatus) throws JsonProcessingException {
        OrderEvent orderEvent = new OrderEvent("order.created", "order.readmodel", carId, orderPrice, orderStatus);
        this.redisHandler.send_event(orderEvent);
    }


}
