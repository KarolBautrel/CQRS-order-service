import com.fasterxml.jackson.core.JsonProcessingException;
import order.service.OrderService;
import order.subscriber.OrderSubscriber;
import redisService.RedisConnector;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, JsonProcessingException {

        OrderSubscriber orderSubscriber = new OrderSubscriber();

        orderSubscriber.checkEvent();




    }
}
