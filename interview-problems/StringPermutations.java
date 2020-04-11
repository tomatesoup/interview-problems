import java.util.Arrays;

class PermutationGenerator {

  private static Set<String> permutations;

  public PermutationGenerator() {
    permutations = new HashSet<>();
  }

  public generatePermutations(String input) {
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
      permutations.add(permutationArray.toString());
    }
  }

  public static void main(String[] args) {
    PermutationGenerator generator = new PermutationGenerator();
    System.out.println(Arrays.toString(generator.generatePermutations("cat")));
  }
  
}