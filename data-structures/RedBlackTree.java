public class RedBlackTree {
  private String BLACK = "black";
  private String RED = "red";

  class Node {
    Node(int value, Node parent, String color) {
      this.value = value;
      this.parent = parent;
      this.color = color;
      this.left = null;
      this.right = null;
    }
  }

  public RedBlackTree() {
    this.root = null;
    this.blackHeight = 0;
  }

  public void insert(int val) {
    // If there is no root, insert as root and color black.
    if (this.root == null) {
      this.root = new Node(val, null, BLACK);
    }

    Node openNode = search(val);
    Node insertion = new Node(val, openNode, RED);
    insertNode(insertion, openNode);
    balance(insertion);
  }

  public void delete(int val) {
    if (this.root == null) {
      return;
    }

    Node deletion = search(val);
  }

  public String printTree() {
    return "";
  }

  private void insertNode(Node newNode, Node parentNode) {
    if (newNode.value == parentNode.value) {
      return;
    }

    if (newNode.value < parentNode.value) {
      if (parentNode.left == null) {
        parentNode.left = newNode;
      } else {
        parentNode.left.parent = newNode;
        newNode.left = parentNode.left;
        parentNode.left = newNode;
      }
    }
    
    if (newNode.value > parentNode.value) {
        if (parentNode.right == null) {
        parentNode.right = newNode;
      } else {
        parentNode.right.parent = newNode;
        newNode.right = parentNode.right;
        parentNode.right = newNode;
      }
    }
  }


  private Node search(int val) {
    // Does binary search and finds the node with the matching value.
    return search(val, this.root);
  }

  private Node search (int val, Node node) {
    if (node == null || node.value == val) {
      return node;
    }

    if (node.value > val) {
      return search(val, node.left);
    }

    if (node.value < val) {
      return search(val, node.right);
    }
  }

  private void balance(Node node) {
    // Either recolor or rotate the node.
    return;
  }

  private void rotate(Node node) {
    return;
  }

  public static void main(String[] args) {

  }
}