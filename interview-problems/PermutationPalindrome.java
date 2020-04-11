import java.util.Set;
import java.util.HashSet;

class PermutationPalindrome {

  public static boolean hasPalindrome(String theString) {
    if (theString.length() < 2) return true;

    Set<Character> singleChars = new HashSet<>();

    for (int i = 0; i < theString.length(); i++) {
      if (singleChars.contains(theString.charAt(i))) {
        singleChars.remove(theString.charAt(i));
      } else {
        singleChars.add(theString.charAt(i));
      }
    }

    return singleChars.size() < 2;
  }

  public static void main(String[] args) {
    System.out.println(hasPalindrome("aabcbcd"));
    System.out.println(hasPalindrome("aabccbdd"));
    System.out.println(hasPalindrome("aabcd"));
    System.out.println(hasPalindrome("aabbcd"));
  }
  
}