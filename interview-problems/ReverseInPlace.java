class ReverseInPlace {

  public static char[] reverseInPlace(char[] input) {
    int oppositeIndex = input.length - 1;

    for (int i = 0; i < input.length/ 2; i++) {
      char temp = input[i];
      input[i] = input[oppositeIndex];
      input[oppositeIndex] = temp;
      oppositeIndex--;
    }

    return input;
  }

  public static void main(String[] args) {
    char[] wordOne = new char[]{'c', 'a', 't', 's'};

    System.out.println(reverseInPlace(wordOne));
    System.out.println(reverseInPlace(new char[]{}));
    System.out.println(reverseInPlace(new char[]{'c', 'a', 't'}));
    System.out.println(reverseInPlace(new char[]{'c'}));
  }
}