//UTSAV
package Final;

class Main {

  public static void main(String[] args) {
    // [2,8,9,1]
    LinkedList list2 = new LinkedList();
    list2.add(2);
    list2.add(8);
    list2.add(9);
    list2.add(1);
    System.out.println("[" + list2 + "] -> " + list2.firstBiggerThanLast());

    // [2,8,9,2]
    LinkedList list3 = new LinkedList();
    list3.add(2);
    list3.add(8);
    list3.add(9);
    list3.add(2);
    System.out.println("[" + list3 + "] -> " + list3.firstBiggerThanLast());

    // []
    LinkedList list4 = new LinkedList();
    System.out.println("[" + list4 + "] -> " + list4.firstBiggerThanLast());

    // [3]
    LinkedList list5 = new LinkedList();
    list5.add(3);
    System.out.println("[" + list5 + "] -> " + list5.firstBiggerThanLast());

    // [3, 4, 7, 6, 3, 2, 9, 6, 3, 6]
    LinkedList list = new LinkedList();
    list.add(3);
    list.add(4);
    list.add(7);
    list.add(6);
    list.add(3);
    list.add(2);
    list.add(9);
    list.add(6);
    list.add(3);
    list.add(6);
    System.out.println("[" + list + "] -> " + list.firstBiggerThanLast());
  }
}
