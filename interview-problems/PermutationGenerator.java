import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class PermutationGenerator {

  private Set<String> permutations;

  public PermutationGenerator() {
    permutations = new HashSet<>();
  }

  public Set<String> generatePermutations(String input) {
    return calculatePermutations(input);
  }

  private Set<String> calculatePermutations(String input) {
    for (int i = 0; i < input.length(); i++) {
      calculatePermutations(input, i);
    }
    return permutations;
  }

  private void calculatePermutations(String input, int currentIndex) {
    char characterToPermutate = input.charAt(currentIndex);
    for (int i = 0; i < input.length(); i++) {
      char[] permutationArray = input.toCharArray();
      char characterToSwap = input.charAt(i);
      permutationArray[i] = characterToPermutate;
      permutationArray[currentIndex] = characterToSwap;
      String permutation = new String(permutationArray);
      System.out.println(permutation);
      permutations.add(permutation);
    }
  }

  public static void main(String[] args) {
    PermutationGenerator generator = new PermutationGenerator();
    Set<String> cat = generator.generatePermutations("cat");
    System.out.println("---");
    for (String permutation : cat) {
      System.out.println(permutation);
    }
  }
  
}