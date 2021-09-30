package java11;

import java.util.function.Consumer;

public class VarInLambda {
  /**
   * There are a few limitations of using var in lambda.
   * For example, we cannot use var for some parameters and skip for others:
   * (var s1, s2) -> s1 + s2
   * <p>
   * we cannot mix var with explicit types:
   * (var s1, String s2) -> s1 + s2
   * <p>
   * even though we can skip the parentheses in single parameter lambda:
   * s1 -> s1.toUpperCase()
   * we cannot skip them while using var:
   * var s1 -> s1.toUpperCase()
   * <p>
   * All of the above three usages will result in compilation error.
   */

  public static void main(String[] args) {
    Consumer<String> stringConsumer = (var s) -> System.out.println(s.repeat(3));
    stringConsumer.accept("USA !!!");
  }
}
