
import java.util.Scanner;

import Repository.FoodDeliveryRepository;
import Service.FoodDeliveryService;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FoodDeliveryRepository repository
                = new FoodDeliveryRepository();

        FoodDeliveryService service
                = new FoodDeliveryService(repository);

        while (true) {

            System.out.println("\n===== FOOD DELIVERY SYSTEM =====");

            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Delivery Agent");
            System.out.println("3. Place Order");
            System.out.println("4. Fastest Delivery Agent");
            System.out.println("5. Restaurant Delay Report");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Restaurant ID: ");
                    int restaurantId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Restaurant Name: ");
                    String restaurantName = sc.nextLine();

                    service.addRestaurant(
                            restaurantId,
                            restaurantName
                    );

                    break;

                case 2:

                    System.out.print("Enter Agent ID: ");
                    int agentId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Agent Name: ");
                    String agentName = sc.nextLine();

                    service.addDeliveryAgent(
                            agentId,
                            agentName
                    );

                    break;

                case 3:

                    System.out.print("Enter Order ID: ");
                    int orderId = sc.nextInt();

                    System.out.print("Enter Restaurant ID: ");
                    int rId = sc.nextInt();

                    System.out.print("Enter Agent ID: ");
                    int aId = sc.nextInt();

                    System.out.print(
                            "Enter Estimated Delivery Time: "
                    );

                    int estimatedTime = sc.nextInt();

                    System.out.print(
                            "Enter Actual Delivery Time: "
                    );

                    int actualTime = sc.nextInt();

                    service.placeOrder(
                            orderId,
                            rId,
                            aId,
                            estimatedTime,
                            actualTime
                    );

                    break;

                case 4:

                    service.showFastestDeliveryAgent();

                    break;

                case 5:

                    service.showRestaurantDelayReport();

                    break;

                case 6:

                    System.out.println("Exiting...");
                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}