package redisService;

import com.fasterxml.jackson.core.JsonProcessingException;
import order.events.OrderEvent;

import java.util.List;

public class RedisHandler {

    RedisConnector redisConnector;

    public RedisHandler(){
        this.redisConnector = new RedisConnector();
    }

    public List<String> get_event(){
        return this.redisConnector.get_lrange("events_storage");
    }

    public void send_event(OrderEvent orderEvent) throws JsonProcessingException {
        this.redisConnector.set_lrange("events_storage", orderEvent);
    }

}
