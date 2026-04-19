package DataStructures;

import java.util.*;
import java.util.Stack;

class DataStructuresPractice {

    public static void main(String[] args) {

        Stack<BasketballPlayer> stack = new Stack<>();
        stack.push(new BasketballPlayer("John Doe", 11));
        stack.push(new BasketballPlayer("Amy Adkins", 22));
        stack.push(new BasketballPlayer("Josh Temp", 4));

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Queue<BasketballPlayer> q = new LinkedList<>();
        
        // Priority queue practice
        PriorityQueue<BasketballPlayer> q = new PriorityQueue<>();
        q.offer(new BasketballPlayer("John Doe", 11));
        q.offer(new BasketballPlayer("Amy Adkins", 22));
        q.offer(new BasketballPlayer("Josh Temp", 4));

        System.out.println("The queue has " + q.size() + " items");

        BasketballPlayer person = q.poll();
        System.out.println("Got " + person + " from the queue");

        person = q.poll();
        System.out.println("Got " + person + " from the queue");

        person = q.poll();
        System.out.println("Got " + person + " from the queue");

        if (!q.isEmpty()) {
            person = q.poll();
            System.out.println("Got " + person + " from the queue");
        }

        System.out.println("The queue has " + q.size() + " items");
        
    }

}
