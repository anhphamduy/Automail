package automail;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

// import java.util.UUID;

/**
 * Represents a mail item
 */
public class MailItem {

    /**
     * Represents the destination floor to which the mail is intended to go
     */
    protected final int destination_floor;
    /**
     * The mail identifier
     */
    protected final String id;
    /**
     * The time the mail item arrived
     */
    protected final int arrival_time;
    /**
     * The weight in grams of the mail item
     */
    protected final int weight;
    private double serviceFees = 0;

    /**
     * Whether or not the item is delivered
     */
    private boolean isDelivered = false;

    private ArrayList<Activity> activities = new ArrayList<>();

    /**
     * Constructor for a MailItem
     *
     * @param dest_floor   the destination floor intended for this mail item
     * @param arrival_time the time that the mail arrived
     * @param weight       the weight of this mail item
     */
    public MailItem(int dest_floor, int arrival_time, int weight) {
        this.destination_floor = dest_floor;
        this.id = String.valueOf(hashCode());
        this.arrival_time = arrival_time;
        this.weight = weight;
    }

    @Override
    public String toString() {
        if (!Calculator.chargeDisplay || Calculator.chargeThreshold == 0 || !isDelivered) {
            return String.format("Mail Item:: ID: %6s | Arrival: %4d | Destination: %2d | Weight: %4d", id, arrival_time, destination_floor, weight);
        }

        return String.format(
                "Mail Item:: ID: %6s | Arrival: %4d | Destination: %2d | Weight: %4d | Charge: %.2f | Cost: %.2f | Fee: %.2f | Activity: %.2f",
                id, arrival_time, destination_floor, weight, Calculator.calculateCharge(this),
                Calculator.calculateCost(this), serviceFees, Calculator.calculateActivitySum(this));
    }

    /**
     * @return the destination floor of the mail item
     */
    public int getDestFloor() {
        return destination_floor;
    }

    /**
     * @return the ID of the mail item
     */
    public String getId() {
        return id;
    }

    /**
     * @return the arrival time of the mail item
     */
    public int getArrivalTime() {
        return arrival_time;
    }

    /**
     * @return the weight of the mail item
     */
    public int getWeight() {
        return weight;
    }

    static private int count = 0;
    static private Map<Integer, Integer> hashMap = new TreeMap<Integer, Integer>();

    @Override
    public int hashCode() {
        Integer hash0 = super.hashCode();
        Integer hash = hashMap.get(hash0);
        if (hash == null) {
            hash = count++;
            hashMap.put(hash0, hash);
        }
        return hash;
    }

    public boolean getPriority() {
        return Calculator.calculateEstimatedCharge(this) > Calculator.chargeThreshold;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public double getServiceFees() {
        return serviceFees;
    }

    public void setServiceFees(double serviceFees) {
        this.serviceFees = serviceFees;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }
}
