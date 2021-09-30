package java11;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Misc {
  public static void main(String[] args) throws UnsupportedEncodingException {
    predicateNotTest();
    optionIsEmpty();
    unicode();
    newStringsFunc();
  }

  public static void predicateNotTest() {
    Stream.of("a", "b", " ", "c").filter(Predicate.not(String::isBlank)).forEach(System.out::println);
  }

  public static void optionIsEmpty() {
    Optional<Integer> nonEmpty = Optional.of(2);
    Optional<Integer> empty = Optional.ofNullable(null);
    System.out.println(nonEmpty.isEmpty() + " " + empty.isEmpty());
  }

  private static void unicode() throws UnsupportedEncodingException {
    //UNICODE 6.0 JAVA 7
    System.out.println("\u20b9"); //RUPEE

    //UNICODE 8.0 JAVA 9
    System.out.println("\uD83E\uDD13");  //NERD FACE
    System.out.println("\uD83E\uDD81");  //LION FACE
    System.out.println("\uD83E\uDD11");  //MONEY MOUTH FACE
    System.out.println("\uD83E\uDD18");  //SIGN OF THE HORNS
    System.out.println("\uD83E\uDD84");  //UNICORN FACE

    //UNICODE 10.0 JAVA 11
    System.out.println("\u20BF"); //BITCOIN SIGN
  }

  private static void newStringsFunc() {
    // lines
    String multiLineString = "This is l1\n" +
      "This is l2\n" +
      "This is l3\n" +
      "This is l4\n";
    multiLineString.lines().forEach(System.out::println);

    // blankTest
    String test1 = "     ";
    String test2 = "";
    System.out.println(test1.isBlank() + "\t" + test1.isEmpty());
    System.out.println(test2.isBlank() + "\t" + test2.isEmpty());

    // repeat
    String test = "Abc";
    System.out.println(test.repeat(5));
  }
}
