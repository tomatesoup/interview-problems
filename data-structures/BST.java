import java.util.ArrayList;

public class BST {
  public Node root;

  class Node {
    int value;
    Node left;
    Node right;

    Node(int val) {
      value = val;
      left = null;
      right = null;
    }
  }

  public BST() {
    root = null;
  }

  public Node search(int val) {
    return search(val, root);
  }

  private Node search(int val, Node node) {
    if (node == null) {
      return node;
    }

    if (val < node.value) {
      return search(val, node.left);
    }

    if (val > node.value) {
      return search(val, node.right);
    }

    // Node matches the input value.
    return node;
  }

  public void insert(int val) {
    if (root == null) {
      root = new Node(val);
      return;
    }
    insertNode(val, root);
  }

  /** Finds and inserts a new node using binary search. */
  private void insertNode(int val, Node node) {
    if (node == null || node.value == val) {
      return;
    }

    // Left side.
    if (val < node.value) {
      // Node doesn't have a left child.
      if (node.left == null) {
        node.left = new Node(val);
      } else {
        insertNode(val, node.left);
      }
    }

    // Right side.
    if (val > node.value) {
      // Node doesn't have a right child.
      if (node.right == null) {
        node.right = new Node(val);
      } else {
        insertNode(val, node.right);
      }
    }
  }

  /** Deletes any node from the tree matching the input value. */
  public void delete(int val) {
    if (root == null) {
      throw new Error("Unable to delete from an empty tree.");
    }
    Node nodeToDelete = search(val, root);
    if (nodeToDelete != null) {
      rebalance(nodeToDelete);
    } else {
      throw new Error("Input value doesn't exist in the tree.");
    }
  }

  /** Swaps parent and child values all the way down a branch. */
  private void rebalance(Node node) {
    if (node == null) {
      return;
    }
    Node child = getChild(node);
    // Node has subtrees.
    if (child != null) {
      node.value = child.value;

      if (isLeaf(child)) {
        if (child == node.left) {
          node.left = null;
        } else {
          node.right = null;
        }
      } else {
        rebalance(child);
      }
    }
  }

  /** Determines if a child is a leaf node. */
  private boolean isLeaf(Node node) {
    return node.left == null && node.right == null;
  }

  /** Finds and returns the first non-null child. */
  private Node getChild(Node node) {
    if (node.left != null) {
      return node.left;
    }
    if (node.right != null) {
      return node.right;
    }
    return null;
  }

  /** For debugging. */
  public void printTree() {
    ArrayList<Integer> tree = new ArrayList<>();
    buildList(root, tree);
    System.out.print(tree.toString());
  }

  private void buildList(Node node, ArrayList<Integer> list) {
    if (node == null) {
      return;
    }
    list.add(node.value);
    buildList(node.left, list);
    buildList(node.right, list);
  }

  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(5);
    tree.insert(3);
    tree.insert(8);
    tree.insert(10);
    tree.insert(12);
    tree.insert(9);
    tree.printTree();
    tree.delete(10);
    tree.printTree();
  }

}