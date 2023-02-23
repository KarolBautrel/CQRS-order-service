package redisService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import order.events.EventReceived;
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

    public void remove_event_from_list(String event) throws JsonProcessingException {

        this.redisConnector.lrem_list("events_storage", event);
    }
}
