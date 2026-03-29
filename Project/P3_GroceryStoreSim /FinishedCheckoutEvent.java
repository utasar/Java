package P3_GroceryStoreSim;

class FinishedCheckoutEvent extends Event {

	// Constructor
	public FinishedCheckoutEvent(Customer customer, double time) {
		super(customer, time);
	}
}
