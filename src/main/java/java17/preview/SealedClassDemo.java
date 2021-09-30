package java17.preview;

import java17.plant.*;

public class SealedClassDemo {
    int process(Plant plant){
        return switch (plant){
            case Herb h->1;
            case Shrub s->2;
            case Cucumber cu->4;
            case Climber cl->3;
            //Lets you eliminate the definition of code to execute for an unmatched Plant type
//            default -> 0;   //Unreachable code
        };
    }
}
/*
class Plant {}

class Herb extends Plant {}
class Shrub extends Plant {}
class Climber extends Plant {}

class Cucumber extends Climber {}
*/


