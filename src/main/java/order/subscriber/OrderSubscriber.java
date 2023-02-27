package order.subscriber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import order.events.EventReceived;
import order.service.OrderService;
import redisService.RedisHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderSubscriber {

    OrderService orderService;
    RedisHandler redisHandler;


    public OrderSubscriber() throws SQLException {
       this.orderService = new OrderService();
       this.redisHandler = new RedisHandler();
    }
    ObjectMapper objectMapper = new ObjectMapper();


    public void checkEvent() throws JsonProcessingException, SQLException {
        List<String> events = this.redisHandler.get_event();
        for (String event: events){

            EventReceived eventReceived = objectMapper.readValue(event, EventReceived.class);
               if (eventReceived.event.equals("car_ordered")) {
                       this.orderService.createOrder(eventReceived.car);
                       this.redisHandler.remove_event_from_list(event);

               }
               if (eventReceived.event.equals("car_cancelled")){
                        this.orderService.cancelOrder(eventReceived.car.id);
                        this.redisHandler.remove_event_from_list(event);



            }


        }

    }


}
