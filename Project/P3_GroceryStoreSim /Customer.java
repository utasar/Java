
package P3_GroceryStoreSim;

class Customer {

	// Customer info from txt file
	private int customerID;
	private double arrivalTime;
	private int numItems;
	private double timePerItem;

	// Calculated info
	private double timeFinishedShopping;
	private double timeFinishedCheckout;
	private double checkoutTime;

	private CheckoutLane lane;

	// Constructor
	public Customer(int customerID, double arrivalTime, int numItems, double timePerItem) {
		this.customerID = customerID;
		this.arrivalTime = arrivalTime;
		this.numItems = numItems;
		this.timePerItem = timePerItem;

		timeFinishedShopping = arrivalTime + (numItems * timePerItem);
	}

	@Override
	public String toString() {
		return "Customer " + customerID + ": arrival time = " + arrivalTime + ", # of items = " + numItems
				+ ", time per item = " + timePerItem + ", shopping time = " + timeFinishedShopping;
	}

	// Methods
	public boolean isExpress() {
		return numItems <= 12;
    }

	public boolean isRegular() {
		return numItems > 12;
	}

	
	// Getters
	public int getCustomerID() {
		return customerID;
	}

	public double getArrivalTime() {
		return arrivalTime;
	}

	public int getNumItems() {
		return numItems;
	}

	public double getTimePerItem() {
		return timePerItem;
	}

	public double getTimeFinishedShopping() {
		return timeFinishedShopping;
	}

	public double getTimeFinishedCheckout() {
		return timeFinishedCheckout;
	}

	public double getWaitTime(Customer c) {
		return timeFinishedCheckout - timeFinishedShopping - c.getCheckoutTime();
	}

	public double getCheckoutTime() {
		return checkoutTime;
	}

	public CheckoutLane getLane() {
		return lane;
	}

	// Setters
	public void setTimeFinishedCheckout(double timeFinishedCheckout) {
		this.timeFinishedCheckout = timeFinishedCheckout;
	}

	public void setCheckoutTime(double checkoutTime) {
		this.timeFinishedCheckout = checkoutTime;
	}

	public void setLane(CheckoutLane shortestLane) {
		this.lane = shortestLane;
	}
}
