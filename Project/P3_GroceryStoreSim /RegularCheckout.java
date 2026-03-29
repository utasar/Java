package P3_GroceryStoreSim;

class RegularCheckout extends CheckoutLane {

    // Constructor
    public RegularCheckout(int laneID) {
        super(laneID);
    }

    // Getter
    public double getCheckoutTime(Customer c) {
        return c.getNumItems() * 0.05 + 2.0;
    }
}
