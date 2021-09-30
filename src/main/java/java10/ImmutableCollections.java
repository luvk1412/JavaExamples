package java10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImmutableCollections {
  public static void main(String[] args) {
    copyOfTest();
    toUnmodifiableTest();
  }

  /**
   * java.util.List, java.util.Map and java.util.Set each got a new static method copyOf(Collection)
   * It returns the unmodifiable copy of the given Collection
   * Any attempt to modify such a collection would result in java.lang.UnsupportedOperationException runtime exception
   */
  public static void copyOfTest() {
    List<Integer> intList = new ArrayList<>();
    intList.add(10);
    intList.add(20);
    intList.add(30);

    List<Integer> copyList = List.copyOf(intList);

    intList.add(40);
    System.out.println("Original List : "+intList);
    System.out.println("Copy List : "+copyList);
    copyList.add(50);
  }

  /**
   * java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set
   * Any attempt to modify such a collection would result in java.lang.UnsupportedOperationException runtime exception
   */
  public static void toUnmodifiableTest() {
    List<Integer> intList = Stream.of(10,20,30,40,50).filter(i->i%20==0).collect(Collectors.toUnmodifiableList());
    System.out.println(intList);
    intList.add(70);
    System.out.println("After Modification :"+intList);
  }
}
