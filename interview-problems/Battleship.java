import java.util.Arrays;

class Battleship {
  // Linear search the board.
    // Find an X.
    // Increment count
    // Turn X into a .
    // Search right or down.
      // Turn every X into a '.'
      // When you find a '.' or reach the end of the board, break;

  // O(1) space
  // 0(N) time

  public int countBattleships(char[][] board) {
    int numShips = 0;

    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        char character = board[row][column];

        if (character == 'X') {
          numShips++;
          board[row][column] = '.';

          // Check the other values in this column.
          int rowIndex = row + 1;
          while (rowIndex < board.length) {
            if (board[rowIndex][column] == 'X') {
              board[rowIndex][column] = '.';
            } else {
              break;
            }
            rowIndex++;
          }

          // Check the other values in this row.
          int columnIndex = column + 1;
          while (columnIndex < board[row].length) {
            if (board[row][columnIndex] == 'X') {
              board[row][columnIndex] = '.';
            } else {
              break;
            }
            columnIndex++;
          }
        }
      }
    }
    return numShips;
  }

  public static void main(String[] args) {
    char[][] board = new char[][] { new char[] { 'X', '.', '.', 'X' }, new char[] { '.', '.', '.', 'X' },
        new char[] { '.', '.', '.', 'X' } };
    System.out.println(board[0]);
    System.out.println(board[1]);
    System.out.println(board[2]);
    Battleship b = new Battleship();
    System.out.println(b.countBattleships(board));
  }
}