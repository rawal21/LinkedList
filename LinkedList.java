import java.nio.channels.Pipe.SourceChannel;

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

public int itrSearch(int key)
{
    Node temp = head;
    int i = 0;
    while(temp!=null)
    {
       if(temp.data==key)
       {
        return i ;
       }
       temp = temp.next;
       i++;
    }

    // key not found 
    return -1 ;
}

public int Helper(Node head , int key)
{
    if(head==null){
        return -1 ;
    }

    if(head.data ==key)
    {
        return 0 ;
    }

    int idx = Helper(head.next, key);

    if(idx==-1)
    {
        return -1 ;
    }

    return idx+1 ;
}

public int recSeach(int key)
{
    return Helper(head , key);
}

public void reverse() {
    Node prev = null;
    Node current = head; // Start from head
    Node next;

    while (current != null) {
        next = current.next; // Store next node
        current.next = prev; // Reverse link
        prev = current; // Move prev forward
        current = next; // Move current forward
    }

    // After loop, prev will be the new head
    tail = head; // Old head becomes the new tail
    head = prev; // New head is the previous node (last node before reversing)
}
 

  public static void main(String[] args) {
      LinkedList LL = new LinkedList();

    LL.addFirst(2);
    LL.addFirst(4);
    LL.addFirst(8);
    LL.addFirst(9);

    //   // Insert value `2` at index `2`
    //   LL.add(2, 9);
    //   LL.removeFirst();
    //   LL.removeLast();

     
      System.out.println("before reverse");
      LL.printLL();
      LL.reverse();
      System.out.println("AFTER REVSER");
      LL.printLL();
    //   int keyIdx = LL.recSeach(9);
    //   System.out.println("Index of 9: " + keyIdx);
    //   System.out.println(LL.itrSearch(11));

  }
}
