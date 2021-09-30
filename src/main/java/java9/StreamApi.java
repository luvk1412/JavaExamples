package java9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
  public static void main(String[] args) {
    takeWhileTest();
    dropWhileTest();
    iterateTest();
    ofNullableTest();
  }

  /**
   * If Stream is an Ordered, then takeWhile method returns the longest prefix which matches that Predicate.
   * The resulted Stream contains only that prefix elements which matches that Predicate condition.
   * <p>
   * That means takeWhile() returns all prefixed elements until they match Predicate condition.
   * When that Predicate returns false for first element, then it stops evaluation and returns that subset elements.
   */
  public static void takeWhileTest() {
    System.out.println("takeWhileTest");
    Stream<Integer> orderedStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    orderedStream.takeWhile(x -> x < 4).forEach(System.out::println);

    Stream<Integer> unOrderedStream = Stream.of(1, 2, 4, 5, 3, 6, 7, 8, 9, 10);
    unOrderedStream.takeWhile(x -> x < 4).forEach(System.out::println);
  }

  /**
   * If Stream is an Ordered, then dropWhile method drops the longest prefix elements which matches that Predicate and returns the rest of elements.
   * The resulted Stream contains all elements except those prefixed elements which matches the Predicate condition.
   * <p>
   * That means dropWhile() first drops all prefixed elements until they match Predicate condition.
   * When that Predicate returns false for first element, then it stops evaluation and returns the rest of subset elements into resulted Stream.
   */
  public static void dropWhileTest() {
    System.out.println("dropWhileTest");
    Stream<Integer> orderedStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    orderedStream.dropWhile(x -> x < 4).forEach(System.out::println);

    Stream<Integer> unOrderedStream = Stream.of(1, 2, 4, 5, 3, 6, 7, 8, 9, 10);
    unOrderedStream.dropWhile(x -> x < 4).forEach(System.out::println);
  }

  /**
   * It is similar to for-loop:
   * First parameter is init value,
   * next parameter is condition and
   * final parameter is to generate next element (for instance, increment or decrement operation).
   */
  public static void iterateTest() {
    System.out.println("iterateTest");
    IntStream.iterate(2, x -> x < 20, x -> x * x).forEach(System.out::println);
  }

  /**
   * Java 9 introduced the ofNullable method to return empty Optionals if the value is null.
   * The main intention is to avoid NullPointerExceptions and to avoid having null checks everywhere.
   */
  public static void ofNullableTest() {
    System.out.println("ofNullableTest");
    long count1 = Stream.ofNullable(100).count();
    System.out.println(count1);

    long count2 = Stream.ofNullable(null).count();
    System.out.println(count2);
  }
}
