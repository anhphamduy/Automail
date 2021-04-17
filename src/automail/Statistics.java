package automail;

public class Statistics {
    public static int totalDeliveredItems = 0;
    public static int totalBillableActivity = 0;
    public static double totalActivityCost = 0;
    public static double totalServiceCost = 0;
    public static int totalSuccessfulLookups = 0;
    public static int totalFailedLookups = 0;

    public static void print() {
        System.out.println("# items delivered " + totalDeliveredItems);
        System.out.println("# billable activities " + totalBillableActivity);
        System.out.println("Total activity cost " + totalActivityCost);
        System.out.println("Total service cost " + totalServiceCost);
        System.out.println("# successful lookups " + totalSuccessfulLookups);
        System.out.println("# failed lookups " + totalFailedLookups);
    }
}
