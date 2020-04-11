class KthToLast {
      public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    // O(N) complexity, O(1) space. -> It's actually 2N complexity, and can be done in one pass.
    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) throws Exception {
        if (head == null || k == 0) {
            throw new Exception();
        }
        int listSize = 0;
        LinkedListNode currentNode = head;

        while (currentNode != null) {
            currentNode = currentNode.next;
            listSize++;
        }
        
        if (k > listSize) {
            throw new Exception();
        }
        
        int kth = listSize - k;
        
        for (int i = 0; i < kth; i++) {
            head = head.next;
        }

        return head;
    }
}