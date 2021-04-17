package automail;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Calculator {
    public static double markupPercentage;
    public static double chargeThreshold;
    public static boolean chargeDisplay;

    public static double calculateEstimatedCharge(MailItem item) {
        ArrayList<Activity> activities = new ArrayList();
        for (int i = 0; i < item.getDestFloor(); i++) {
            activities.add(new MovementActivity(true));
        }

        activities.add(new LookUpActivity(true));
        return activities.stream().mapToDouble(Activity::getUnit).sum() * Activity.unitPrice * (1 + markupPercentage);
    }

    public static double calculateCharge(MailItem item) {
        return (1 + markupPercentage) * calculateCost(item);
    }

    public static double calculateActivitySum(MailItem item) {
        Stream<Activity> billableActivityStream = item.getActivities().stream().filter(Activity::isBillable);

        return billableActivityStream.mapToDouble(Activity::getUnit).sum();
    }

    public static double calculateCost(MailItem item) {
        double activityUnitSum = calculateActivitySum(item);
        double cost = activityUnitSum * Activity.unitPrice + item.getServiceFees();

        return cost;
    }
}
