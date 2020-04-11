class KthToLastOnePass {
    public static class LinkedListNode {
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) throws Exception {
      if (head == null || k == 0) {
        throw new Exception();
      }

      // Initialize two pointers
      // Move second pointer to the right "k" times
      // When second pointer is k elements away, move both pointers one at a time
      // when the second pointer is null, return the first pointer
      // O(N) complexity, O(1) space.

      LinkedListNode first = head;
      LinkedListNode second = head;

      for(int i = 0; i < k; i++) {
        // K is bigger than the list size.
        if (second == null) {
          throw new Exception("K cannot be bigger than the list size.");
        }
        second = second.next;
      }

      while (second != null) {
        first = first.next;
        second = second.next;
      }

      return first;
    }
}