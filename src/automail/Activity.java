package automail;

public class Activity {
    private double unit;
    private boolean billable;
    public static double unitPrice;

    public Activity(double unit, boolean billable) {
        this.unit = unit;
        this.billable = billable;
    }

    public boolean isBillable() {
        return billable;
    }

    public double getUnit() {
        return unit;
    }
}


