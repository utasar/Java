
package P3_GroceryStoreSim;

import java.util.*;

abstract class CheckoutLane implements Comparable<CheckoutLane> {

	private Queue<Customer> customerLine = new LinkedList<Customer>();
	protected int laneID;


	// Constructor
	public CheckoutLane(int laneID) {
		this.laneID = laneID;
	}

	@Override
    public int compareTo (CheckoutLane other) {
		return this.customerLine.size() - other.customerLine.size();
	}

	@Override
	public String toString() {
		return "Lane " + laneID + ": " + customerLine.size() + " customers";
	}
	
	// Methods
	public int size() {
		return customerLine.size();
	}

	public void addCustomer(Customer c) {
		customerLine.add(c);
	}

	public void removeCustomer(Customer customer) {
		customerLine.remove(customer);
    }

	public boolean containsCustomer(Customer c) {
		return customerLine.contains(c);
	}

	// Getters
	public int getLaneID() {
		return laneID;
	}

	public Customer getNextCustomer() {
		return customerLine.peek();
	}

	public Queue<Customer> getCustomerLine() {
		return customerLine;
	}

	public abstract double getCheckoutTime(Customer c);
}
