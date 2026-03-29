
package P3_GroceryStoreSim;

public class ExpressCheckout extends CheckoutLane {

    // Constructor
    public ExpressCheckout(int laneID) {
        super(laneID);
    }

    // Getter
    public double getCheckoutTime(Customer c) {
        return c.getNumItems() * 0.1 + 1.0;
    }
}
