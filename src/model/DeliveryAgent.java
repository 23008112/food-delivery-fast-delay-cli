package model;


public class DeliveryAgent {

    private int agentId;
    private String agentName;

    private int totalDeliveryTime;
    private int deliveredOrders;

    public DeliveryAgent(int agentId, String agentName) {
        this.agentId = agentId;
        this.agentName = agentName;

        this.totalDeliveryTime = 0;
        this.deliveredOrders = 0;
    }

    public int getAgentId() {
        return agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public int getDeliveredOrders() {
        return deliveredOrders;
    }

    public void completeDelivery(int actualTime) {

        deliveredOrders++;
        totalDeliveryTime += actualTime;
    }

    public double getAverageDeliveryTime() {

        if (deliveredOrders == 0) {
            return 0;
        }

        return (double) totalDeliveryTime / deliveredOrders;
    }
}