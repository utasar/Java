package P3_GroceryStoreSim;

import java.io.*;
import java.util.*;

public class Simulator {

	private static ArrayList<Customer> customerList = new ArrayList<Customer>();
	private static PriorityQueue<Event> eventQueue = new PriorityQueue<>();
	//private static File file = new File("Projects/P3_GroceryStoreSim/customer data/arrival simple.txt");
	private static File file = new File("Projects/P3_GroceryStoreSim/customer data/arrival medium.txt");

	public static void main(String[] args) throws IOException {
		// Read file and store data in customerList
		readFile(file);

		// Simulate 2 express and 4 regular lanes
		simulate(2, 4);
	}

	public static void readFile(File file) {
		try {
			Scanner fileInput = new Scanner(file);
			int count = 0;

			while (fileInput.hasNext()) {
				String line = fileInput.nextLine();
				String[] data = line.split("\\s+");
				int customerID = count;
				double arrivalTime = Double.parseDouble(data[0]);
				int numItems = Integer.parseInt(data[1]);
				double timePerItem = Double.parseDouble(data[2]);
				Customer customer = new Customer(customerID, arrivalTime, numItems, timePerItem);
				customerList.add(customer);
				count++;

				// Create a new arrival event for each customer
				eventQueue.add(new ArrivalEvent(customer, arrivalTime));
			}
			fileInput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static double averageWaitTime() {
		double totalWaitTime = 0;

		for (Customer customer : customerList) {
			totalWaitTime += customer.getWaitTime(customer);
		}
		return totalWaitTime / customerList.size();
	}

	public static void simulate(int numExpress, int numRegular) throws IOException {

		// Create n express lanes
		PriorityQueue<ExpressCheckout> expressCheckoutLanes = new PriorityQueue<>();
		for (int i = 1; i <= numExpress; i++) {
			expressCheckoutLanes.add(new ExpressCheckout(i));
		}

		// Create n regular lanes
		PriorityQueue<RegularCheckout> regularCheckoutLanes = new PriorityQueue<>();
		for (int i = 1; i <= numRegular; i++) {
			regularCheckoutLanes.add(new RegularCheckout(i + expressCheckoutLanes.size()));
		}

		// Open log file
		PrintWriter log = new PrintWriter("Projects/P3_GroceryStoreSim/customer data/log.txt");

		// Main loop that runs until all customers are served
		while (!eventQueue.isEmpty()) {
			Event event = eventQueue.poll();
			Customer customer = customerList.get(event.getCustomerID());
			double timeFinishedShopping = customer.getTimeFinishedShopping();

			// list all the customers in all of the lanes
			System.out.println("Customers in all express lanes: " + expressCheckoutLanes);
			System.out.println("Customers in all regular lanes: " + regularCheckoutLanes);

			// First event: customer arrives at the store
			if (event instanceof ArrivalEvent) {
				
				// Add a new FinishedShoppingEvent to the eventQueue
				eventQueue.add(new FinishedShoppingEvent(customer, timeFinishedShopping));
				log.println(customer.getArrivalTime() + ": Customer " + customer.getCustomerID() + " arrives");
			
			// Second event: customer finishes shopping
			} else if (event instanceof FinishedShoppingEvent) {

				ExpressCheckout shortestExpressLane = expressCheckoutLanes.peek();
				RegularCheckout shortestRegularLane = regularCheckoutLanes.peek();

				log.println(timeFinishedShopping + ": Customer " + customer.getCustomerID() + " finishes shopping");

				// If the customer has 12 or less items
				if (customer.getNumItems() <= 12) {

					// If the shortest express lane is shorter than or equal to the shortest regular lane
					if (shortestExpressLane.size() <= shortestRegularLane.size()) {

						// Add the customer to the shortest express lane
						shortestExpressLane = expressCheckoutLanes.poll();
						shortestExpressLane.addCustomer(customer);
						customer.setLane(shortestRegularLane);
						expressCheckoutLanes.offer(shortestExpressLane);

						log.println("12 or fewer, chose express lane " + shortestExpressLane.getLaneID());

						//expressCheckoutLanes.add(shortestExpressLane);	

						// If the customer is the only one in the express lane
						if (shortestExpressLane.size() == 1) {

							// Calculate checkout time = time finished shopping + time checking out
							customer.setTimeFinishedCheckout(timeFinishedShopping + shortestExpressLane.getCheckoutTime(customer));
							
							// Add a new FinishedCheckoutEvent
							eventQueue.add(new FinishedCheckoutEvent(customer, customer.getTimeFinishedCheckout()));
							customer.setCheckoutTime(timeFinishedShopping + shortestExpressLane.getCheckoutTime(customer));
						}
					} else {

						// Add the customer to the shortest regular lane
						shortestRegularLane = regularCheckoutLanes.poll();
						shortestRegularLane.addCustomer(customer);
						customer.setLane(shortestRegularLane);
						regularCheckoutLanes.offer(shortestRegularLane);

						log.println("12 or fewer, chose regular lane " + shortestRegularLane.getLaneID());

						// If the customer is the only one in the regular lane
						if (shortestRegularLane.size() == 1) {

							// Calculate checkout time = time finished shopping + time checking out
							customer.setTimeFinishedCheckout(timeFinishedShopping + shortestRegularLane.getCheckoutTime(customer));
							
							// Add a new FinishedCheckoutEvent
							eventQueue.add(new FinishedCheckoutEvent(customer, customer.getTimeFinishedCheckout()));
							customer.setCheckoutTime(timeFinishedShopping + shortestRegularLane.getCheckoutTime(customer));
						}
					}
				} else {			
					shortestRegularLane = regularCheckoutLanes.poll();
					shortestRegularLane.addCustomer(customer);
					customer.setLane(shortestRegularLane);

					log.println("More than 12, chose regular lane " + shortestRegularLane.getLaneID());

					regularCheckoutLanes.offer(shortestRegularLane);

					if (shortestRegularLane.size() == 1) {
						customer.setTimeFinishedCheckout(timeFinishedShopping + shortestRegularLane.getCheckoutTime(customer));
						eventQueue.add(new FinishedCheckoutEvent(customer, customer.getTimeFinishedCheckout()));
						customer.setCheckoutTime(timeFinishedShopping + shortestRegularLane.getCheckoutTime(customer));
					}
				}

			// Third event: customer finishes checking out
			} else if (event instanceof FinishedCheckoutEvent) {

				// remove the customer from their lane
				CheckoutLane lane = customer.getLane();
				lane.removeCustomer(customer);

				log.println(customer.getTimeFinishedCheckout() + ": Customer " + customer.getCustomerID()
							+ " finishes checking out");
			}
		}

		// Add average wait time to the log file
		log.println("Average wait time: " + averageWaitTime());
		log.close();
	}
}
