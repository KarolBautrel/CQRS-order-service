package order.events;

import car.Car;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventReceived {

        public String routing_key;
        public String event;

        public Car car;

}
