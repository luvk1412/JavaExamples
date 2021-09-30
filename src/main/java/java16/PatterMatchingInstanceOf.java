package java16;

// Detailed pattern matching : https://cr.openjdk.java.net/~briangoetz/amber/pattern-match.html
// JEP 305 : https://openjdk.java.net/jeps/305, preview in 14,15
public class PatterMatchingInstanceOf {

  public static void main(String[] args) {

  }

  private static void test(Object obj) {
    if (obj instanceof Integer) {
      int intValue = ((Integer) obj).intValue();
      // use intValue
    }

    if (obj instanceof Integer i) {
      // can use i here, of type Integer
    }


    String formatted = "unknown";
    if (obj instanceof Integer) {
      int i = (Integer) obj;
      formatted = String.format("int %d", i);
    } else if (obj instanceof Byte) {
      byte b = (Byte) obj;
      formatted = String.format("byte %d", b);
    } else if (obj instanceof Long) {
      long l = (Long) obj;
      formatted = String.format("long %d", l);
    } else if (obj instanceof Double) {
      double d = (Double) obj;
      formatted = String.format("double %f", d);
    } else if (obj instanceof String) {
      String s = (String) obj;
      formatted = String.format("String %s", s);
    }

    formatted = "unknown";
    if (obj instanceof Integer i) {
      formatted = String.format("int %d", i);
    } else if (obj instanceof Byte b) {
      formatted = String.format("byte %d", b);
    } else if (obj instanceof Long l) {
      formatted = String.format("long %d", l);
    } else if (obj instanceof Double d) {
      formatted = String.format("double %f ", d);
    } else if (obj instanceof String s) {
      formatted = String.format("String %s", s);
    }

    Object objA = new A();
    if (objA instanceof A a)
      System.out.println(a.numA);

    objA = new B();
    if (objA instanceof B b && b.stringB.length() > 0)
      System.out.println(b.stringB);
  }


}

class A {
  A() {
    numA = 10;
  }

  int numA;
}

class B extends A {
  B() {
    stringB = "Hello";
  }

  String stringB;
}

class PointDemo {
  int x, y;

//  public boolean equals(Object o) {
//    if (!(o instanceof PointDemo))
//      return false;
//    PointDemo other = (PointDemo) o;
//    return x == other.x
//      && y == other.y;
//  }

  public boolean equals(Object o) {
    return (o instanceof PointDemo other)
      && x == other.x
      && y == other.y;
  }
}