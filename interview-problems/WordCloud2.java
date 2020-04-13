import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class WordCloud2 {

  public HashMap<String, Integer> generateWordCloud(String inputString) {
    if (inputString.isEmpty()) {
      throw new IllegalArgumentException("Input string not allowed to be empty.");
    }

    // 2 pointers, keeping track of the start and end of a word.
    // if " " or punctuation,
    //   cut the word, make it all lowercase, add it to the hashmap.
    // if "-" or "'",
    //    check if there are spaces before and after it.
    //      if yes, keep going. if no, it is part of the word.

    int startIndex = 0;
    HashSet<Character> punctuation = new HashSet<>(Arrays.asList(new Character[] {'.', ',', '?', ';', ':', '!'}));
    HashMap<String, Integer> wordCloud = new HashMap<>();
    int inputLength = inputString.length();

    while(startIndex < inputLength) {

      for (int i = startIndex; i < inputLength; i++) {
        // Handle starting at a space or punctuation.
        if (inputString.charAt(startIndex) == ' ' || punctuation.contains(inputString.charAt(startIndex))) {
          startIndex++;
          break;
        }

        char current = inputString.charAt(i);

        // Handle the last word.
        if (i + 1 == inputLength) {
          if (punctuation.contains(current)) {
            addWord(inputString, startIndex, i, wordCloud);
          } else {
            addWord(inputString, startIndex, i + 1, wordCloud);
          }
          return wordCloud;
        }


        // Handle spaces and standard punction.
        if (current == ' ' || punctuation.contains(current)) {
          addWord(inputString, startIndex, i, wordCloud);
          startIndex = i + 1;
          break;
        }

        // Handle hyphens.
        if (current == '-') {
          if (inputString.charAt(i - 1) == ' ' && inputString.charAt(i + 1) == ' ') {
            startIndex = i + 2;
            break;
          }
        }
      }
    }
    return wordCloud;
  }

  private void addWord(String inputString, int start, int end, HashMap<String, Integer> wordCloud) {
    String word = inputString.substring(start, end).toLowerCase();
    if (wordCloud.containsKey(word)) {
      wordCloud.put(word, wordCloud.get(word) + 1);
    } else {
      wordCloud.put(word, 1);
    }
  }

  public static void main(String[] args) {
    WordCloud2 wc = new WordCloud2();
    System.out.println(wc.generateWordCloud("I like cake").toString());
    System.out.println(wc.generateWordCloud("Chocolate cake for dinner and pound cake for dessert").toString());
    System.out.println(wc.generateWordCloud("Strawberry short cake? Yum!").toString());
    System.out.println(wc.generateWordCloud("Dessert - mille-feuille cake").toString());
    System.out.println(wc.generateWordCloud("Mmm...mmm...decisions...decisions").toString());
    System.out.println(wc.generateWordCloud("Allie's Bakery: Sasha's Cakes").toString());
  }
}