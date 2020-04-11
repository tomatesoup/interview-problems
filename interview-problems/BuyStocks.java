// [9, 11, 8, 5, 7, 10]

public class BuyStocks {
  public static void main(String[] args) {
    System.out.println(buyStocks(new int[]{9, 11, 8, 5, 7, 10}));
    System.out.println(buyStocks(new int[] {8, 1}));
    System.out.println(buyStocks(new int[] { 2, 8, 1, 9 }));
  }

  private static int buyStocks(int[] stockPrices) {
    if (stockPrices.length < 2) {
      return 0;
    }
    int maxDifference = 0;
    int minValue = stockPrices[0];

    for (int i = 1; i < stockPrices.length; i++) {
      // if the current value is greater than minValue and greater than maxDifference
      if (stockPrices[i] > minValue && stockPrices[i] - minValue > maxDifference) {
        maxDifference = stockPrices[i] - minValue;
      }

      // if the current value is smaller than minValue
      if (stockPrices[i] < minValue) {
        minValue = stockPrices[i];
      }
    }

  return maxDifference;
  }
}