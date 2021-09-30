package java17.plant;

/**
 * A sealed class can be abstract too.
 * If you define a sealed class and its derived classes in the same source file, you can omit the contextual keyword permits and the name of the derived classes that are included in the declaration of a sealed class.
 */
public sealed abstract class Plant permits Herb, Shrub, Climber {
}
/**
 * The classes that extend a sealed class must either be final, non-sealed, or sealed.
 * A final class prohibits further extension.
 * A non-sealed class allows other classes to extend it.
 * And a sealed subclass must follow the same set of rules as the parent base class – it could be extended by an explicit list of other classes.
 */
