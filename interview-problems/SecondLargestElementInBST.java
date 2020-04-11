class SecondLargestElementInBST {
  public static class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
      this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
      this.left = new BinaryTreeNode(leftValue);
      return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
      this.right = new BinaryTreeNode(rightValue);
      return this.right;
    }
  }

  public static int findSecondLargest(BinaryTreeNode rootNode) {
    if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
      throw new IllegalArgumentException("Tree must have at least 2 nodes");
    }
    BinaryTreeNode current = rootNode;

    while (true) {
      // Current has a right child with no children of it's own: it's the second
      // largest value.
      if (current.right != null && current.right.left == null && current.right.right == null) {
        return current.value;
      }

      // No right child, but there is a left child.
      if (current.right == null && current.left != null) {
        // Find largest element in left subtree.
        return findLargest(current.left);
      }
      // Keep looking right.
      current = current.right;
    }
  }

  private static int findLargest(BinaryTreeNode node) {
    BinaryTreeNode current = node;
    while (current.right != null) {
      current = current.right;
    }
    return current.value;
  }

  /** Recursive solution: */
  public static int findSecondLargestRecursive(BinaryTreeNode rootNode) {
    if (rootNode.right == null && rootNode.left == null) {
      throw new IllegalArgumentException("Tree must contain more than one node.");
    }
    return findSecondLargest(rootNode, rootNode.value);
  }

  private static int findSecondLargest(BinaryTreeNode node, int largestSoFar) {
    if (node.right != null) {
      largestSoFar = node.value;
      return findSecondLargest(node.right, largestSoFar);
    }
    if (node.right == null && node.left != null) {
      return findLargestRecursive(node.left);
    }
    return largestSoFar;
  }

  private static int findLargestRecursive(BinaryTreeNode node) {
    if (node.right != null) {
      return findLargestRecursive(node.right);
    }
    return node.value;
  }
}