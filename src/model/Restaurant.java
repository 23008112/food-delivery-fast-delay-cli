package model;

public class Restaurant {

    private int restaurantId;
    private String restaurantName;
    private int delayCount;

    public Restaurant(int restaurantId, String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.delayCount = 0;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getDelayCount() {
        return delayCount;
    }

    public void incrementDelayCount() {
        delayCount++;
    }
}