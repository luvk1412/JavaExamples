package java16;

// JEP 395:  https://openjdk.java.net/jeps/395, previewed in 14, 15

import java.util.Objects;

public class Records {
  public static void main(String[] args) {
    Point point = new Point(12, 13);
    System.out.println(point.x());
    System.out.println(point.y());
    System.out.println(point);

    Point anotherPoint = new Point(12, 13);
    System.out.println("Equality check: " + point.equals(anotherPoint));

    Range range1 = new Range(1, 20);
    System.out.println(range1);
  }
}


class PointOld {
  private final int x;
  private final int y;

  PointOld(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int x() {
    return x;
  }

  int y() {
    return y;
  }

  public boolean equals(Object o) {
    if (!(o instanceof PointOld)) return false;
    PointOld other = (PointOld) o;
    return other.x == x && other.y == y;
  }

  public int hashCode() {
    return Objects.hash(x, y);
  }

  public String toString() {
    return String.format("Point[x=%d, y=%d]", x, y);
  }
}

record Point(int x, int y) {
}

record Range(int low, int high) {
  //Concise Constructor
  public Range {
    if (low >= high)
      throw new IllegalArgumentException("Bad Range: (%d, %d)".formatted(low, high));
  }
}