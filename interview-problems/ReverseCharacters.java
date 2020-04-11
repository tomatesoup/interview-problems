import java.util.Arrays;

class ReverseCharacters {

  public static void main(String[] args) {
    char[] cat = new char[]{'c', 'a', 't'};
    reverseInPlace(cat);
    System.out.println(Arrays.toString(cat));
  }

  private static void reverseInPlace(char[] characters) {
    if (characters.length < 2) return;

    char temp = characters[0];
    int end = characters.length - 1;
    for (int i = 0; i < characters.length / 2; i++) {
      temp = characters[i];
      characters[i] = characters[end];
      characters[end] = temp;
      end--;
    }
  }
}