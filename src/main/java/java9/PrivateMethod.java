package java9;

public class PrivateMethod implements PrivateMethodInterface {

  public static void main(String[] args) {
    PrivateMethod p = new PrivateMethod();
    p.publicMethod();
  }

}


interface PrivateMethodInterface {
  default void publicMethod(){
   privateMethod();
  }

  private void privateMethod() {
    System.out.println("private Method");
  }
}