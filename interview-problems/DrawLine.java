// Go through the x’s on the grid and calculate the Y’s
// if there is a space between the current y and previous y, fill in the points
// between them
// End conditions - no more x’s, y’s too big for grid

class DrawLine {
  public void drawLine(int[][] grid, int m, int c) {
    int prevY = 0;
    for (int x = 0; x < grid[0].length; x++) {
      int currentY = m * x + c;

      if (currentY < grid.length) {
        grid[x][currentY] = 1;
      } else if (currentY < 0) {
        continue;
      } else if (currentY > grid.length) {
        return;
      }

      if (currentY > prevY + 1) {
        // Loop through and flip middle 0’s along the diagonal, all the way up to the currentY calculation.
        int y = prevY + 1;
        while (y < currentY && x < grid[0].length) {
          if (y > grid.length) {
            return;
          }
          grid[x][y] = 1;
          x++;
          y++;
        }
      }
      prevY = currentY;
    }
  }

}
