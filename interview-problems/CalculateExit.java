// three inputs: 2 integers, set of Integers
// Build out a tree with start int
  // Calculate valid children at each level of tree
  // if one of the children matches the end return true
// return false
class CalculateExit {

  public boolean calculateExit(int start, int end, Set<Integer> safeNumbers) {
    Set<Integer> calculatedNumbers = new HashSet<>();
    Queue<Integer> permutationsToCheck = new ArrayDeque<>();

    permutationsToCheck.add(Integer.valueOf(start));

    while (!permutationsToCheck.isEmpty()) {
      Integer current = permutationsToCheck.remove();

      if (current == Integer.valueOf(end)) {
        return true;
      }

      List<Integer> validPermutations = calculatePermutations(current, calculatedNumbers, safeNumbers);

      for (Integer permutation : validPermutations) {
        permutationsToCheck.add(permutation);
      }

      calculatedNumbers.add(current);
    }

    return false;
  }

  private List<Integer> calculatePermutations(Integer value, Set<Integer> calculatedNumbers, Set<Integer> safeNumbers) {
    // Do the bitwise permutations here
  }
}
