import com.fasterxml.jackson.core.JsonProcessingException;
import order.subscriber.OrderSubscriber;

import java.sql.SQLException;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws SQLException, JsonProcessingException, InterruptedException {

        OrderSubscriber orderSubscriber = new OrderSubscriber();

        while (true){
            TimeUnit.SECONDS.sleep(1);
            orderSubscriber.checkEvent();
        }





    }
}
