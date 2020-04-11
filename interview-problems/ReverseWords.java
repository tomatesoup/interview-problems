import java.util.Arrays;

class ReverseWords {
  public static void main(String[] args) {
    char[] message = { 'c', 'a', 'k', 'e', ' ', 'p', 'o', 'u', 'n', 'd', ' ', 's', 't', 'e', 'a', 'l' };
    reverseWords(message);
    System.out.println(Arrays.toString(message));
  }

  private static void reverseWords(char[] words) {
    if (words.length < 2) return;

    // 1. Reverse the whole array.
    reverseChars(0, words.length - 1, words);

    // 2. Reverse the individual words.
   int wordStart = 0;
   for (int i = 0; i <= words.length; i++) {
     if (i == words.length || words[i] == ' ') {
      reverseChars(wordStart, i -1, words);
      wordStart = i + 1;
     }
   }
  }

  private static void reverseChars(int start, int end, char[] collection) {
    while (start < end) {
      char temp = collection[start];
      collection[start] = collection[end];
      collection[end] = temp;
      start++;
      end--;
    }
  }
}