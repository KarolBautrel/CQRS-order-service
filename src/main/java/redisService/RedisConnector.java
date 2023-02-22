
package redisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaworks.redis.*;
import order.events.OrderEvent;

import java.util.List;

public class RedisConnector {

   public RedisConnection<String, String> connection;

     public RedisConnector(){
        RedisClient redisClient = new RedisClient(RedisURI.create("redis://localhost:6379"));
        this.connection = redisClient.connect();
    }

    public  List<String> get_lrange(String key){
       return  this.connection.lrange(key,0, -1);
    }
    public  void set_lrange(String key, OrderEvent orderEvent) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonOrderEvent = objectMapper.writeValueAsString(orderEvent);
        this.connection.lpush(key, jsonOrderEvent);
    }





}
