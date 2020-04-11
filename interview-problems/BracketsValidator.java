import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

class BracketsValidator {

  public static boolean isValid(String code) {
    HashMap<String, String> closeToOpen = new HashMap<>();
    closeToOpen.put("}", "{");
    closeToOpen.put("]", "[");
    closeToOpen.put(")", "(");

    Deque<String> stack = new ArrayDeque<>();

    // Go through each character in String
    // If it is an opener, push it onto stack.
    // if it is a closer, peek at last element of stack -
    // if they match, pop it off the stack.
    // if they don't, return false.
    // Check that the stack is empty.

    for (int i = 0; i < code.length(); i++) {
      String current = Character.toString(code.charAt(i));

      if (closeToOpen.containsKey(current)) {
        String potentialMatch = stack.peek();
        if (potentialMatch.equals(closeToOpen.get(current))) {
          stack.pop();
        } else {
          return false;
        }
      } else {
        stack.push(current);
      }
    }

    if (!stack.isEmpty()) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    String one = "{[]()}";
    String two = "{[(])}";
    String three = "{[}";
    System.out.println(BracketsValidator.isValid(one));
    System.out.println(BracketsValidator.isValid(two));
    System.out.println(BracketsValidator.isValid(three));
  }

}