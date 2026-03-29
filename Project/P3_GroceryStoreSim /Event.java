package P3_GroceryStoreSim;

class Event implements Comparable<Event> {

	private Customer customer;
	private double time;


	// Constructor
	public Event(Customer customer, double time) {
		this.customer = customer;
		this.time = time;
	}

	@Override
	public int compareTo(Event o) {
		// Multiply by 100 to avoid rounding errors
		return (int) ((this.time - o.time) * 100);
	}

	@Override
	public String toString() {
		return "LaneID = " + customer.getCustomerID();
	}

	// Getter
	public int getCustomerID() {
		return customer.getCustomerID();
	}
}
