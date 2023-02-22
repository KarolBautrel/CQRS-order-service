package order.subscriber;

import dbConnection.DBConnector;
import order.service.OrderService;
import redisService.RedisHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderSubscriber {

    OrderService orderService;
    RedisHandler redisHandler;
    OrderSubscriber() throws SQLException {
       this.orderService = new OrderService();
       this.redisHandler = new RedisHandler();
    }

    public void checkEvent(){
        List<String> events = this.redisHandler.get_event();
        System.out.println(events);
        
    }


}
