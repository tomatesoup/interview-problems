
// Good morning! Here's your coding interview problem for today.

// This problem was asked by Twitter.

// You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

// record(order_id): adds the order_id to the log
// get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
// You should be as efficient with time and space as possible.

class Recorder {
  // O(N) space and O(1) time.

  private static int DEFAULT = 100;
  private static int CURRENT = 0;
  private static int[] LOG;

  public Recorder() {
   LOG = new int[DEFAULT];
  }

  public static void record(int orderId) {
    add(orderId);
  }

  public static int getLast(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("Element index must be 0 or greater.");
    }
    return LOG[i];
  }

  private static void add(int element) {
    int currentSize = LOG.length;
    // Current array too small.
    if (CURRENT == currentSize - 1) {
      int newCapacity = currentSize + DEFAULT;
      int[] biggerCopy = Arrays.copyOf(LOG, newCapacity);
      LOG = biggerCopy;
      LOG[originalSize] = element;
      CURRENT = originalSize;
    } else {
      LOG[CURRENT + 1] = element;
      CURRENT++;
    }
  }
}

