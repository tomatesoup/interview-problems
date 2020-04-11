import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class LoveRectangles {

    public static class Rectangle {

        // coordinates of bottom left corner
        private int leftX;
        private int bottomY;

        // dimensions
        private int width;
        private int height;

        public Rectangle() {}

        public Rectangle(int leftX, int bottomY, int width, int height) {
            this.leftX = leftX;
            this.bottomY = bottomY;
            this.width  = width;
            this.height = height;
        }

        public int getLeftX() {
            return leftX;
        }

        public int getBottomY() {
            return bottomY;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            return String.format("(left: %d, bottom: %d, width: %d, height: %d)",
                leftX, bottomY, width, height);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Rectangle)) {
                return false;
            }
            final Rectangle r = (Rectangle) o;
            return leftX == r.leftX && bottomY == r.bottomY
                   && width == r.width && height == r.height;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = result * 31 + leftX;
            result = result * 31 + bottomY;
            result = result * 31 + width;
            result = result * 31 + height;
            return result;
        }
    }

    private static class Coordinate {
      int x;
      int y;
      Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
      }
    }

    private static Rectangle getBiggerRectangle(Rectangle first, Rectangle second) {
      int areaOne = first.getHeight() * first.getWidth();
      int areaTwo = second.getHeight() * second.getWidth();
      return areaOne >= areaTwo ? first : second;
    }

    private static boolean isWithinLimits(Coordinate coordinate, Rectangle rectangle) {
      int leftBoundary = rectangle.getLeftX();
      int rightBoundary = rectangle.getLeftX() + rectangle.getWidth();
      int lowerBoundary = rectangle.getBottomY();
      int upperBoundary = rectangle.getBottomY() + rectangle.getHeight();

      return coordinate.x >= leftBoundary 
            && coordinate.x <= rightBoundary
            && coordinate.y >= lowerBoundary
            && coordinate.y <= upperBoundary;
    }

    private static Set<Coordinate> getNeighbors(Coordinate coordinate, Rectangle parent) {
      Set<Coordinate> neighbors = new HashSet<>();
      neighbors.add(new Coordinate(coordinate.x + 1, coordinate.y));
      neighbors.add(new Coordinate(coordinate.x - 1, coordinate.y));
      neighbors.add(new Coordinate(coordinate.x, coordinate.y + 1));
      neighbors.add(new Coordinate(coordinate.x, coordinate.y - 1));

      for (Coordinate point : neighbors) {
        if (!isWithinLimits(point, parent)) {
          neighbors.remove(point);
        }
      }
      return neighbors;
    }

    private static Rectangle buildRectangle(List<Coordinate> coordinates) {
      int minX = Integer.MAX_VALUE;
      int maxX = Integer.MIN_VALUE;
      int minY = Integer.MAX_VALUE;
      int maxY = Integer.MIN_VALUE;

      for (int i = 0; i < coordinates.size(); i++) {
        Coordinate current = coordinates.get(i);
        // X values.
        if (current.x < minX) {
          minX = current.x;
        }
        if (current.x > maxX) {
          maxX = current.x;
        }
        // Y values.
        if (current.y < minY) {
        minY = current.y;
        }
        if (current.y > maxY) {
          maxY = current.y;
        }
      }
      return new Rectangle(minX, minY, maxX - minX, maxY - minY);
    }

    public static Rectangle findRectangularOverlap(Rectangle rect1, Rectangle rect2) {
        // calculate the overlap between the two rectangles

        // Traverse one reactangle (the smaller one if possible)
        List<Coordinate> overlap = new ArrayList<>();
        Queue<Coordinate> coordinatesToVisit = new ArrayDeque<>();
        Set<Coordinate> visited = new HashSet<>();
        Rectangle rectangleToTraverse = getBiggerRectangle(rect1, rect2);
        Rectangle otherRectangle = getBiggerRectangle(rect1, rect2) == rect1 ? rect2 : rect1;
        Coordinate startingPoint = new Coordinate(rectangleToTraverse.getLeftX(), rectangleToTraverse.getBottomY());

        coordinatesToVisit.add(startingPoint);

        while(!coordinatesToVisit.isEmpty()) {
          // Check if current coordinate within limits of other rectangle
            // If yes, add the coordinate to an array
            // Check the coordinate's neighbors
          Coordinate current = coordinatesToVisit.remove();
          Set<Coordinate> neighbors = getNeighbors(current, rectangleToTraverse);

          if (isWithinLimits(current, otherRectangle)) {
            overlap.add(current);
          }
          visited.add(current);
          for (Coordinate neighbor : neighbors) {
            coordinatesToVisit.add(neighbor);
          }
        }

        // if the array is not empty
          // build and return the overlap rectangle
          if (!overlap.isEmpty()) {
            return buildRectangle(overlap);
          } 

        return new Rectangle();
    }

    public static void main(String[] args) {
      
    }
}