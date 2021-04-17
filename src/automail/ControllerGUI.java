package automail;

public class ControllerGUI {
    public static void setActivityUnitPrice(double unitPrice) {
        Activity.unitPrice = unitPrice;
    }

    public static void setMarkupPercentage(double markupPercentage) {
        Calculator.markupPercentage = markupPercentage;
    }

    public static void setChargeThreshold(double chargeThreshold) {
        Calculator.chargeThreshold = chargeThreshold;
    }

    public static void setChargeDisplay(boolean chargeDisplay) {
        Calculator.chargeDisplay = chargeDisplay;
    }
}
