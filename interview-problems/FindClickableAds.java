import java.util.HashSet;

class FindClickableAds {

  private static class Point {
    private char value;
    private int x;
    private int y;

    Point(char value, int x, int y) {
      this.value = value;
      this.x = x;
      this.x = y;
    }
  }

  private static class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point a, Point b) {
      return (Integer.valueOf(a.value).compareTo(Integer.valueOf(b.value)));
    }
  }

  public static Set<Point> findMostClickablePoints(char[][] webpage) {
    int maxDistance = 0;
    Set<Point> mostClickablePoints = new HashSet<>();
    Queue<Point> unvisitedPoints = new ArrayDeque<>();
    unvisitedPoints.add(new Point(webpage[0][0], 0, 0));

    // Mark up the matrix with distance values.
    while (!unvisitedPoints.isEmpty()) {
      Point currentPoint = unvisitedPoints.remove();
      if (currentPoint.value == 'N') {
        webpage[currentPoint.x][currentPoint.y] = '0';
      } else if (currentPoint.value == 'C') {
        int minimumNeighborValue = Collections.min(getKnownNeighbors(currentPoint, webpage), new PointComparator());
        if (minimumNeighborValue + 1 > maxDistance) {
          maxDistance = minimumNeighborValue + 1;
        }
        webpage[currentPoint.x][currentPoint.y] = String.valueOf(minimumNeighborValue + 1);
      }
      unvisitedPoints.addAll(getUnknownNeighbors(currentPoint, webpage));
    }

    // Find the maximum distances and add their points to a set.
    for (int x = 0; x < webpage.length; x++) {
      for (int y = 0; y < webpage[x].length; y++) {
        char currentValue = webpage[x][y];
        if (Integer.valueOf(currentValue) == maxDistance) {
          mostClickablePoints.add(new Point(value, x, y));
        }
      }
    }
    return mostClickablePoints;
  }

  private static List<Point> getUnknownNeighbors(Point point, char[][] matrix) {
    // Gets the neighbors that don't already have an integer value.
  }

  private static List<Point> getKnownNeighbors(Point point, char[][] matrix) {
    // Gets the neighbors that do already have an integer value.
  }

  public static void main(String[] args) {
  }
}
