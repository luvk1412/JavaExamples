package java17.preview;

import java17.sealedclasses.plant.*;

// pattern matching + switch + sealed evaluate demo[oracle] : https://slides.nipafx.dev/patterns/index.html#/ , h,n,k -> keys to travel in ppt

public class SealedClassWithSwitch {
  int process(Plant plant) {
    return switch (plant) {
      case Herb h -> 1;
      case Shrub s -> 2;
      case Cucumber cu -> 4;
      case Climber cl -> 3;
      //Lets you eliminate the definition of code to execute for an unmatched Plant type
//            default -> 0;   //Unreachable code
    };
  }
}


