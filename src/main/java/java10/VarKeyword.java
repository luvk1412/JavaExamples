package java10;

public class VarKeyword {

  /**
   * Java has now var style declarations.
   * It allows you to declare a local variable without specifying its type.
   * The type of variable will be inferred from type of actual object created.
   * <p>
   * NOTE:
   * var can be used as a variable, method, and package name, but we cannot use it as a class or interface name.
   * <p>
   * RESTRICTIONS:
   * 1. We cannot use the var on a variable without initializers.
   * 2. var is not allowed in a compound declaration.
   * 3. We cannot initialize with a null value for var-type variables.
   */
  public static void main(String[] args) {
    var test = "Hello World";
    System.out.println(test);

    var isValid = true;
    if (isValid)
      System.out.println("Valid");

    var var = 10;
    System.out.println(var + 100);

    var();

  /*COMPILATION ERROR :
    var i;
    var a, b = 0;
    var c = null;
	*/
  }

  public static void var() {
    System.out.println("var() method invoked");
  }

}
