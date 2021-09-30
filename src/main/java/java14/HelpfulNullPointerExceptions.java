package java14;

public class HelpfulNullPointerExceptions {
  public static void main(String[] args) {
    N1 n1 = new N1();
    n1.getN2().getN3().i = 100;
    System.out.println("TEST");
  }
}

class N1 {
  public N1() {
    this.n2 = new N2();
  }

  private N2 n2;

  public N2 getN2() {
    return n2;
  }
}

class N2 {
  N3 n3;

  public N3 getN3() {
    return n3;
  }
}

class N3 {
  int i;
}
