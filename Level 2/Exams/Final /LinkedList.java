// Utsav
package Final;

public class LinkedList {
    
    private Node head;
    private int size;
    
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    public void add(int element) {
        Node newNode = new Node(element);
        
        if (head == null) {
            head = newNode;
            size = 1;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            size++;
        }
    }
    
    public int getSize() {
        return size;
    }
   
    @Override
    public String toString() {
        String s = "";
        if (head == null) {
            return s;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                s += current.toString() + ", ";
                current = current.getNext();
            }
            s += current.toString(); // last item has no trailing comma
            return s;
        }
    }

    public boolean firstBiggerThanLast() {
        if (head == null) {
            return false;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return head.getElement() > current.getElement();
        }
    }
    
}
