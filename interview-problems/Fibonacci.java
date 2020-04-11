class Fibonacci {

  public static int fib(int n) { 
    int[] cache = new int[n + 1];

    // compute the nth Fibonacci number
    return fib(n, cache);
  }

  private static int fib(int n, int[] cache) {
    if (n < 0) {
      throw new IllegalArgumentException("Invalid input.");
    }
    if (n < 2) {
      return n;
    }

    if (cache[n] != 0) {
      return cache[n];
    }

    cache[n] = fib(n -1, cache) + fib(n - 2, cache);
    return cache[n];
  }

  public static void main(String[] args) {
    System.out.println(fib(10));
  }
}