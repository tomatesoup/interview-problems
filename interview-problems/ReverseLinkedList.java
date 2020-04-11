class ReverseLinkedList {

  public final class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
      this.value = value;
    }
  }

  public static LinkedListNode reverse(LinkedListNode head) {
    if (head.next == null) {
      return head;
    }

    while (head.next != null) {
      LinkedListNode originalTail = head.next;
      LinkedListNode newTail = null;

      head.next = newTail;
      newTail = head;
      head = originalTail;
    }
    return head;
  }

  public static void main(String[] args) {
    LinkedListNode one = new LinkedListNode(1);
    LinkedListNode two =  new LinkedListNode(2);
    LinkedListNode three = new LinkedListNode(3);

    one.next = two;
    two.next = three;

    LinkedListNode newHead = reverse(one);
    System.out.println(newHead.value);
    System.out.println(newHead.next.value);
    System.out.println(newHead.next.next.value);
  }
  
  
}