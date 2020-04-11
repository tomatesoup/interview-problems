// Good morning! Here's your coding interview problem for today.

// This problem was recently asked by Google.

// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

// Bonus: Can you do this in one pass?

public final class SumToK {
  public static void main(String[] args) {
    int[] firstArray = {1, 2, 3};
    System.out.println(Boolean.toString(canSumToK(5, firstArray)));
    int[] secondArray = { 4, 5, 6 };
    System.out.println(Boolean.toString(canSumToK(3, secondArray)));
    int[] thirdArray = { 1, 2, 3 };
    System.out.println(Boolean.toString(canSumToK(7, thirdArray)));
  }

  private static boolean canSumToK(int k, int[] numbers) {
    if (numbers.length < 2) { return false; }

    int sum = Integer.MIN_VALUE;
    int firstNumberIndex = 0;
    int secondNumberIndex = numbers.length - 1;

    while (firstNumberIndex < secondNumberIndex) {
      for (int i = 0; i < numbers.length; i++) {
        firstNumberIndex = i;
        sum =  numbers[firstNumberIndex] + numbers[secondNumberIndex];
        if (sum == k) {
          return true;
        }
        secondNumberIndex--;
      }
    }
    return false;
  }
}