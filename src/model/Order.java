package model;

public class Order {

    private int orderId;

    private Restaurant restaurant;
    private DeliveryAgent deliveryAgent;

    private int estimatedTime;
    private int actualTime;

    private String status;

    public Order(int orderId,
                 Restaurant restaurant,
                 DeliveryAgent deliveryAgent,
                 int estimatedTime,
                 int actualTime) {

        this.orderId = orderId;
        this.restaurant = restaurant;
        this.deliveryAgent = deliveryAgent;

        this.estimatedTime = estimatedTime;
        this.actualTime = actualTime;

        this.status = "DELIVERED";
    }

    public boolean isDelayed() {
        return actualTime > estimatedTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public DeliveryAgent getDeliveryAgent() {
        return deliveryAgent;
    }
}
