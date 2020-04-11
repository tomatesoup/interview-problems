import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
 
class Game {
 
 // You are creating a PacMan style game.
 // Given a game board of 1s and 0s, a starting position, and an ending position,
 // determine if the game has an exit.
 
 // 1 1 0
 // 1 1 0
 // 0 1 1
 
 private class Position {
   int x;
   int y;
 
   Position(int x, int y) {
     this.x = x;
     this.y = y;
   }
 }
 
 public static boolean hasPathWithBFS(int[][] board, Position start, Position end) {
   Queue<Position> positionsToCheck = new ArrayDeque<>();
   Set<Position> checkedPositions = new HashSet<>();
   positionsToCheck.add(start);
 
   while (!positionsToCheck.isEmpty()) {
     Position currentPosition = positionsToCheck.remove();
 
     if (currentPosition == end) {
       return true;
     }
 
     for (Position neighbor : getNeighbors(currentPosition, board)) {
       if (!checkedPositions.contains(neighbor)) {
         positionsToCheck.add(neighbor);
       }
     }
     checkedPositions.add(currentPosition);
   }
 
   return false;
 }
 
 public static boolean hasPathWithDFS(int[][] board, Position start, Position end) {
   Stack<Position> positionsToCheck = new Stack<>();
   Set<Position> checkedPositions = new HashSet<>();
   positionsToCheck.push(start);
 
   while (!positionToCheck.isEmpty()) {
     Position currentPosition = positionsToCheck.pop();
 
     if (currentPosition == end) {
       return true;
     }
 
     for (Position neighbor : getNeighbors(currentPosition, board)) {
       if (!checkedPositions.contains(neighbor)) {
         positionsToCheck.push(neighbor);
       }
     }
     checkedPositions.add(currentPosition);
   }
 
   return false;
 }
 
 public static boolean hasPathWithRecursiveDfs(int[][] board, Position start, Position end) {
   Set<Position> checkedPositions = new HashSet<>();
   return recursiveDfs(board, start, end, checkedPositions);
 }
 
 private static boolean recursiveDfs(int[][] board, Position position, Position end, Set<Position> checkedPositions) {
   if (isWall(board, position)) {
     return false;
   }
   if (position == end) {
     return true;
   }
   for (Position neighbor : getNeighbors(start, board)) {
     if (!checkedPositions.contains(neighbor)) {
       checkedPositions.add(neighbor);
       return recursiveDfs(board, neighbor, end, checkedPositions);
     }
   }
 }
 
 private static boolean isWall(int[][] board, Position position) {
   return board[position.y][position.x] == 0;
 }
 
 private static List<Position> getNeighbors(Position position, int[][] board) {
   List<Position> neighbors = new ArrayList<>();
 
   if (position.x > 0) {
     neighbors.add(new Position(position.x - 1, position.y));
   }
 
   if (position.x < board[0].length) {
     neighbors.add(new Position(position.x + 1, position.y));
   }
 
 
   if (position.y > 0) {
     neighbors.add(new Position(position.x, position.y - 1));
   }
 
   if (position.y < board.length) {
     neighbors.add(new Position(position.x, position.y + 1));
   }
 
   return neighbors;
 }
}
