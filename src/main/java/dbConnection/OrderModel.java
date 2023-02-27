package dbConnection;

public class OrderModel {
    int car_id;
    double price;
    String status;


    public OrderModel(int car_id, double price, String status) {
        this.car_id = car_id;
        this.price = price;
        this.status = status;
    }
}
