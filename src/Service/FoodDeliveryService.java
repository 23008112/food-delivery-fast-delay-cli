package Service;

import java.util.List;

import Repository.FoodDeliveryRepository;
import model.DeliveryAgent;
import model.Order;
import model.Restaurant;


public class FoodDeliveryService {

    private FoodDeliveryRepository repository;

    public FoodDeliveryService(FoodDeliveryRepository repository) {
        this.repository = repository;
    }

    public void addRestaurant(int id, String name) {

        Restaurant restaurant = new Restaurant(id, name);

        repository.addRestaurant(restaurant);
    }

    public void addDeliveryAgent(int id, String name) {

        DeliveryAgent agent = new DeliveryAgent(id, name);

        repository.addDeliveryAgent(agent);
    }

    public void placeOrder(int orderId,
                           int restaurantId,
                           int agentId,
                           int estimatedTime,
                           int actualTime) {

        Restaurant selectedRestaurant = null;
        DeliveryAgent selectedAgent = null;

        for (Restaurant r : repository.getRestaurants()) {

            if (r.getRestaurantId() == restaurantId) {
                selectedRestaurant = r;
                break;
            }
        }

        for (DeliveryAgent a : repository.getAgents()) {

            if (a.getAgentId() == agentId) {
                selectedAgent = a;
                break;
            }
        }

        if (selectedRestaurant == null || selectedAgent == null) {

            System.out.println("Invalid Restaurant or Agent");
            return;
        }

        Order order = new Order(
                orderId,
                selectedRestaurant,
                selectedAgent,
                estimatedTime,
                actualTime
        );

        repository.addOrder(order);

        selectedAgent.completeDelivery(actualTime);

        if (order.isDelayed()) {
            selectedRestaurant.incrementDelayCount();
        }

        System.out.println("Order Delivered Successfully");
    }

    public void showFastestDeliveryAgent() {

        List<DeliveryAgent> agents = repository.getAgents();

        if (agents.isEmpty()) {

            System.out.println("No Agents Available");
            return;
        }

        DeliveryAgent fastest = agents.get(0);

        for (DeliveryAgent agent : agents) {

            if (agent.getAverageDeliveryTime()
                    < fastest.getAverageDeliveryTime()) {

                fastest = agent;
            }
        }

        System.out.println("\n===== FASTEST DELIVERY AGENT =====");

        System.out.println(
                "Agent ID: " + fastest.getAgentId()
        );

        System.out.println(
                "Agent Name: " + fastest.getAgentName()
        );

        System.out.println(
                "Average Delivery Time: "
                        + fastest.getAverageDeliveryTime()
        );
    }

    public void showRestaurantDelayReport() {

        List<Restaurant> restaurants
                = repository.getRestaurants();

        restaurants.sort((r1, r2)
                -> r2.getDelayCount()
                - r1.getDelayCount());

        System.out.println(
                "\n===== RESTAURANT DELAY REPORT ====="
        );

        for (Restaurant r : restaurants) {

            System.out.println(
                    "Restaurant ID: "
                            + r.getRestaurantId()
                            + " | Name: "
                            + r.getRestaurantName()
                            + " | Delay Count: "
                            + r.getDelayCount()
            );
        }
    }
}
