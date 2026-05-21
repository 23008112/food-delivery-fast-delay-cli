package Repository;

import model.DeliveryAgent;
import model.Order;
import model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryRepository {

    private List<Restaurant> restaurants;
    private List<DeliveryAgent> agents;
    private List<Order> orders;

    public FoodDeliveryRepository() {

        restaurants = new ArrayList<>();
        agents = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void addDeliveryAgent(DeliveryAgent agent) {
        agents.add(agent);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public List<DeliveryAgent> getAgents() {
        return agents;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
