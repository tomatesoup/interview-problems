import java.util.Arrays;

class FindDuplicateSpaceEdition {

  // O(N log N) time, O(1) space.
  public static int findRepeat(int[] numbers) throws IllegalArgumentException {
    if (numbers.length < 2) {
      throw new IllegalArgumentException();
    }
    Arrays.sort(numbers);
    int previousIndex = 0;
    int nextIndex = 1;

    while (nextIndex < numbers.length) {
      if (numbers[previousIndex] == numbers[nextIndex]) {
        return numbers[previousIndex];
      }
      previousIndex++;
      nextIndex++;
    }
    return 0;
  }

  /** Previous solution. */
  // public static int findRepeat(int[] numbers) {
  //   Arrays.sort(numbers);
  //   // find a number that appears more than once
  //   for (int i = 0; i < numbers.length; i++) {
  //     int repeat = binarySearch(numbers, i + 1, numbers[i]);
  //     if (repeat > 0) {
  //       return repeat;
  //     }
  //   }
  //   return 0;
  // }

  // private static int binarySearch(int[] numbers, int startIndex, int number) {
  //   int floorIndex = startIndex;
  //   int ceilingIndex = numbers.length;

  //   while (floorIndex < ceilingIndex) {
  //     int guessIndex = floorIndex + ((ceilingIndex - floorIndex) / 2);

  //     if (numbers[guessIndex] == number) {
  //       return number;
  //     } else if (numbers[guessIndex] > number) {
  //       ceilingIndex = guessIndex;
  //     } else if (numbers[guessIndex] < number) {
  //       floorIndex = guessIndex;
  //     }
  //   }

  //   return 0;
  // }
}