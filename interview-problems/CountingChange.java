class CountingChange {

  public static int numberOfWays(int amount, int[] denominations) {
    int answer = 0;

    for (int denomination : denominations) {
      int amountRemaining = amount - denomination;
      answer += numberOfWays(amountRemaining, denomination);
    }
    
  }

  private static int numberOfWays(int amountLeft, int denomination) {
    
  }
}