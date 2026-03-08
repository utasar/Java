// Acahrya
package Final;

public class Node {
    
    private int element;
    private Node next;
    
    public Node(int element) {
        this.element = element;
        next = null;
    }
    
    public int getElement() {
        return element;
    }
    
    public void setElement(int element) {
        this.element = element;
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "" + element;
    }
}
