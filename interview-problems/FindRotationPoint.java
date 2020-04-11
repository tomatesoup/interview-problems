// SPlit the input in half
  // COmpare the found word with the last word of the right chunk (could be any chunk)
    // if the last word is smaller than the found word, search that chunk
    // Otherwise, search the left chunk

    // .equals returns an integer, use this to compare "size" of words

class FindRotationPoint {

  public static int findRotation(String[] input) {
    if (input.length < 2) {
      return -1;
    }

    int startIndex = 0;
    int endIndex = input.length - 1;

    while (startIndex + 1 !=  endIndex) {
      int guessIndex = startIndex + ((endIndex - startIndex)/2);
      int comparison = input[guessIndex].compareTo(input[endIndex]);

      if (comparison >= 0) {
        startIndex = guessIndex;
      } else {
        endIndex = guessIndex;
      }
    }

    return endIndex;
  }

  public static void main(String[] args) {
    System.out.println(findRotation(new String[] { "cape", "cake" }));
    System.out.println(findRotation(new String[] { "grape", "orange", "plum", "radish", "apple" }));
    System.out.println(findRotation(new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
            "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"}));
  }

}