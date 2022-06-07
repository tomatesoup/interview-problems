import java.util.HashMap;
import java.util.Map;

class Trie {
  private Node root;

  class Node {
    private Node[] references;
    boolean endOfWord;

    Node() {
      references = new Node[26];;
      endOfWord = false;
    }

    /**
     * @param endOfWord the endOfWord to set
     */
    public void setEndOfWord(boolean endOfWord) {
      this.endOfWord = endOfWord;
    }

    public boolean getEndOfWord() {
      return endOfWord;
    }

    public Node get(char c) {
      return references[c - 97];
    }

    public Node getOrCreate(char c) {
      int index = c - 97;
      if (references[index] == null) {
        references[index] = new Node();
      }
      return references[index];
    }
  }

  /** Initialize your data structure here. */
  public Trie() {
    root = new Node();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if (word.isEmpty()) {
      throw new IllegalArgumentException();
    }

    Node currentReference = root;

    for (int i = 0; i < word.length(); i++) {
      Node letterToInsert = currentReference.getOrCreate(word.charAt(i));

      if (i == word.length() - 1) {
        letterToInsert.setEndOfWord(true);
        return;
      }

      currentReference = letterToInsert;
    }
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if (word.isEmpty()) {
      throw new IllegalArgumentException();
    }

    Node currentReference = root;

    for (int i = 0; i < word.length(); i++) {
      currentReference = currentReference.get(word.charAt(i));
      if (currentReference == null) {
        return false;
      } else if (i == word.length() - 1) {
        return currentReference.getEndOfWord();
      }
    }

    return false;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    if (prefix.isEmpty()) {
      throw new IllegalArgumentException();
    }

    Node currentReference = root;

    for (int i = 0; i < prefix.length(); i++) {
      currentReference = currentReference.get(prefix.charAt(i));
      if (currentReference == null) {
        return false;
      }
    }

    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
