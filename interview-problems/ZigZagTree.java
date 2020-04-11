// Given a binary tree of characters, print out each level of the tree in zig-zag order.
// First level L -> R, next level R -> L, etc.
import java.util.Stack;

class ZigZagTree {
  static class Node {
    private Node right;
    private Node left;
    private char value;

    Node(char value) {
      this.left = null;
      this.right = null;
      this.value = value;
    }
  }

  public static void zigZag(Node root) {
    // if null then return 
    if (rootNode == null) { 
      return; 
    } 
  
    // declare two stacks 
    Stack<Node> currentLevel = new Stack<>(); 
    Stack<Node> nextLevel = new Stack<>(); 
  
    // push the root 
    currentLevel.push(rootNode); 
    boolean leftToRight = true; 
  
    // check if stack is empty 
    while (!currentLevel.isEmpty()) { 
  
      // pop out of stack 
      Node node = currentLevel.pop(); 
        
      // print the data in it 
      System.out.print(node.value); 
    
      // store data according to current 
      // order. 
      if (leftToRight) { 
          if (node.left != null) { 
            nextLevel.push(node.left); 
          } 
            
          if (node.right != null) { 
            nextLevel.push(node.right); 
          } 
      } 
      else { 
          if (node.right != null) { 
            nextLevel.push(node.right); 
          } 
            
          if (node.left != null) { 
            nextLevel.push(node.left); 
          } 
      } 
    
      if (currentLevel.isEmpty()) { 
          leftToRight = !leftToRight; 
          Stack<Node> temp = currentLevel; 
          currentLevel = nextLevel; 
          nextLevel = temp; 
      } 
    } 
  }

  public static void main(String[] args) {
    Node a = new Node('a');
    Node b = new Node('b');
    Node c = new Node('c');
    Node d = new Node('d');
    Node e = new Node('e');
    Node f = new Node('f');
    Node g = new Node('g');

    a.left = b;
    a.right = c;

    b.left = d;
    b.right = e;

    c.left = f;
    c.right = g;

    zigZag(a); 
  }
}