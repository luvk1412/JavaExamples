package java17.preview;

import java17.sealedclasses.pollution.AirPollution;
import java17.sealedclasses.pollution.WaterPollution;

/**
 * A switch is classified as a statement or an expression depending on whether it returns a value or not.
 * If it returns a value, it is a switch expression, otherwise a statement.
 */
public class SwitchDemo {
  enum SingleUsePlastic {
    CUP, STRAW, BOTTLE, TAKE_AWAY_CONTAINERS;
  }

  // Switch Expression: Arrow Syntax
  int getDamageToPlanet(SingleUsePlastic plastic) {
    return switch (plastic) {
      case CUP -> 100;
      case STRAW -> 200;
      case BOTTLE, TAKE_AWAY_CONTAINERS -> 300;
    };
  }

  // Switch Expression: Colon Syntax
  int getDamageToPlanetV2(SingleUsePlastic plastic) {
    return switch (plastic) {
      case CUP:
        yield 100;
      case STRAW:
        yield 200;
      case BOTTLE, TAKE_AWAY_CONTAINERS:
        yield 300;
    };
  }

  // Switch Statement: Arrow Syntax
  void showDamageToPlanet(SingleUsePlastic plastic) {
    switch (plastic) {
      case CUP -> System.out.println(100);
      case STRAW -> System.out.println(200);
      case BOTTLE -> System.out.println(300);
    }
  }

  int getDamageForPolltuionTypes(Object obj) {
    return switch (obj) {
//            case Pollution p -> 100; //pattern dominance : handling generic types before specific types
      case WaterPollution p -> 200;
      case AirPollution a -> 300;
      case null -> 0;
      case default -> -1;
    };
  }

  public static void main(String[] args) {
    SwitchDemo demo = new SwitchDemo();
    assert (0 == demo.getDamageForPolltuionTypes(null));
    assert (-1 == demo.getDamageForPolltuionTypes(demo));
    System.out.println(demo.getDamageForPolltuionTypes(new WaterPollution()));
  }
}
