package java17;

public class PatternMatchingDemo {
    void outputValueInUpperCase(Object obj){
        if(obj instanceof String s){
            System.out.println(s.toUpperCase());
        }
    }
}