package java14.switchexpression;

import java.time.DayOfWeek;
import java.util.Scanner;

import static java.time.DayOfWeek.*;

// JEP 361: Switch Expressions : https://openjdk.java.net/jeps/361
// Preview in 12,13 : https://docs.oracle.com/javase/specs/jls/se13/preview/switch-expressions.html


public class SwitchDemo {

  public static void main(String[] args) {
  }


  private static void oldSwitch(DayOfWeek day) {
    switch (day) {
      case MONDAY:
      case FRIDAY:
      case SUNDAY:
        System.out.println(6);
        break;
      case TUESDAY:
        System.out.println(7);
        break;
      case THURSDAY:
      case SATURDAY:
        System.out.println(8);
        break;
      case WEDNESDAY:
        System.out.println(9);
        break;
    }
  }

  private static void newSwitch(DayOfWeek day) {
    switch (day) {
      case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
      case TUESDAY -> System.out.println(7);
      case THURSDAY, SATURDAY -> System.out.println(8);
      case WEDNESDAY -> System.out.println(9);
    }
  }

  private static void oldSwitchAssignment(DayOfWeek day) {
    int numLetters;
    switch (day) {
      case MONDAY:
      case FRIDAY:
      case SUNDAY:
        numLetters = 6;
        break;
      case TUESDAY:
        numLetters = 7;
        break;
      case THURSDAY:
      case SATURDAY:
        numLetters = 8;
        break;
      case WEDNESDAY:
        numLetters = 9;
        break;
      default:
        throw new IllegalStateException("Wat: " + day);
    }
  }

  private static void newSwitchAssignment(DayOfWeek day) {
    int numLetters = switch (day) {
      case MONDAY, FRIDAY, SUNDAY -> 6;
      case TUESDAY -> 7;
      case THURSDAY, SATURDAY -> 8;
      case WEDNESDAY -> 9;
//      default -> 4; // default is not required if all cases are covered
    };
  }

  private static void yieldKeyWord(DayOfWeek day) {
    int i = switch (day) {
      case MONDAY -> {
        System.out.println("Monday");
        yield 3;
        // ERROR if block doesn't contain a yield statement
      }
      default -> 1;
    };
  }

}

