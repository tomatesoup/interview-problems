import java.util.Map;

class WordCloud {


  // Go through my string and 'find' words:
    // keep track of where a word starts
    // keep track of where a word ends
      // handle punctuation
   // add word to hashmap


  private static Map<String, Integer> buildWordCloud(String input) {
    String lower = input.toLowerCase();
    Map<String, Integer> wordCloud;

    if (input.length() < 2 && lower == "a" || lower == "i") {
      wordCloud.put(lower, 1);
      return wordCloud;
    }

    if (input.length() < 2 && lower != "a" && lower != "i") {
      throw new IllegalArgumentException("Incorrect Input String");
    }

    Set<Character> standardPunctuation;
    int start = 0;

    while (startIndex < lower.length()) {
      for (int end = start; end < lower.length(); end++) {
        char current = lower.charAt(end);

        if (standardPunctuation.contains(lower.charAt(start))) {
          start++;
        }

        if (end < start) {
          end++;
        }

        // Check if it's punctuation
        if (standardPunctuation.contains(current)) {
          // Get the word
          String word = lower.substring(start, current);

          // Add it to the Map
          if (wordCloud.containsKey(word)) {
            wordCloud.put(word, wordCloud.get(word) + 1);
          } else {
            wordCloud.put(word, 1);
          }

          // Update start
          end++;
          start = end;
        }
      }
    }
    return wordCloud;
  }
}