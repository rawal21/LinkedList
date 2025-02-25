public class LinkedList {

  public static class Node {
      int data;
      Node next;

      public Node(int data) {
          this.data = data;
          this.next = null;
      }
  }

  public static Node head;
  public static Node tail;
  public static int size ;

  // Add a node at the beginning of the LinkedList
  public void addFirst(int data) {
      Node newNode = new Node(data);
      size++;

      // If list is empty, both head and tail point to newNode
      if (head == null) {
          head = tail = newNode;
          return;
      }

      // Point the new node to the current head
      newNode.next = head;

      // Update head to the new node
      head = newNode;
  }

  // Add a node at the end of the LinkedList
  public void addLast(int data) {
      Node newNode = new Node(data);
      size++;

      // If list is empty, head and tail point to newNode
      if (head == null) {
          head = tail = newNode;
          return;
      }

      // Link the last node (tail) to the new node
      tail.next = newNode;

      // Update tail to the new node
      tail = newNode;
  }

  // Print the LinkedList
  public void printLL() {
      if (head == null) {
          System.out.println("Linked list is empty");
          return;
      }

      Node temp = head;
      while (temp != null) {
          System.out.print(temp.data + " -> ");
          temp = temp.next;
      }
      System.out.println("NULL");
  }

  // Insert a node at a given index
  public void add(int idx, int data) {
      Node newNode = new Node(data);
      size++;

      // Case 1: If inserting at index 0, use addFirst
      if (idx == 0) {
          addFirst(data);
          return;
      }

      Node temp = head;
      int i = 0;

      // Traverse to the (idx-1)th position
      while (temp != null && i < idx - 1) {
          temp = temp.next;
          i++;
      }

      // Case 2: If index is out of bounds
      if (temp == null) {
          System.out.println("Index out of bounds!");
          return;
      }

      // Insert the new node at the desired position
      newNode.next = temp.next;
      temp.next = newNode;

      // If inserting at the last position, update tail
      if (newNode.next == null) {
          tail = newNode;
      }
  }  

  public void removeFirst() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    // If the list has only one element
    if (head == tail) {
        head = tail = null;
    } else {
        head = head.next;
    }

    size--; // Decrease the size of the linked list
}

public void removeLast() {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    // If the list has only one element
    if (head == tail) {
        head = tail = null;
    } else {
        Node temp = head;
        
        // Traverse to the second-last node
        while (temp.next != tail) {
            temp = temp.next;
        }

        // Update the tail to the second-last node
        temp.next = null;
        tail = temp;
    }

    size--; // Decrease the size of the linked list
}

  public static void main(String[] args) {
      LinkedList LL = new LinkedList();

    LL.addFirst(2);
    LL.addFirst(4);
    LL.addFirst(8);
    LL.addFirst(9);

      // Insert value `2` at index `2`
      LL.add(2, 9);
      LL.removeFirst();
      LL.removeLast();

      LL.printLL();

  }
}
