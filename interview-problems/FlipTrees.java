import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Algo:
// Look at every level of the tree
// if every level is equal to the other tree after sorting, return true
// otherwise return false

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class FlipTrees {
  public boolean flipEquiv(TreeNode root1, TreeNode root2) {
    if (root1 == null && root2 == null) {
      return true;
    }
        
    if ((root1 == null && root2 != null) || (root2 == null && root1 != null)) {
      return false;
    }
    HashMap<Integer, List<Integer>> levelsTreeOne = new HashMap<>();
    HashMap<Integer, List<Integer>> levelsTreeTwo = new HashMap<>();

    fillOutLevels(0, root1, levelsTreeOne);
    fillOutLevels(0, root2, levelsTreeTwo);

    for (Map.Entry<Integer, List<Integer>> treeLevel : levelsTreeOne.entrySet()) {
      List<Integer> treeOneValues = treeLevel.getValue();
      Collections.sort(treeOneValues);
        
      List<Integer> treeTwoValues = levelsTreeTwo.get(treeLevel.getKey());
      Collections.sort(treeTwoValues);
        
      for (int i = 0; i < treeOneValues.size(); i++) {
        if (treeOneValues.get(i) != treeTwoValues.get(i)) {
            return false;
        }
      }
    }
    return true;
  }

  private void fillOutLevels(int level, TreeNode node, HashMap<Integer, List<Integer>> levels) {
    if (node == null) {
      return;
    }

    if (!levels.containsKey(level)) {
      ArrayList<Integer> values = new ArrayList<>();
      values.add(node.val);
      levels.put(level, values);
    } else {
      ArrayList<Integer> values = levels.get(level);
      values.add(node.val);
      levels.put(level, values);
    }

    fillOutLevels(level + 1, node.left, levels);
    fillOutLevels(level + 1, node.right, levels);
  }
}