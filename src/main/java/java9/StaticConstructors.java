package java9;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class StaticConstructors {

  private static final Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  public static void main(String[] args) {

    List<String> immutableEmptyList = List.of();
    log.info("Empty List Example: " + immutableEmptyList);
    List<String> immutableList = List.of("ABC", "PQR", "MNO");
    log.info("Non-Empty List Example: " + immutableList);


    Set<String> immutableEmptySet = Set.of();
    log.info("Empty Set Example: " + immutableEmptySet);
    Set<String> immutableSet = Set.of("MUMBAI", "PARIS", "LONDON");
    log.info("Non-Empty Set Example: " + immutableSet);


    Map<String, Integer> immutableEmptyMap = Map.of();
    log.info("Empty Map  Example: " + immutableEmptyMap);
    Map<String, Integer> immutableMap = Map.of("ABC", 10, "PQR", 11, "MNO", 12);
    log.info("Non-Empty Map  Example: " + immutableMap);
  }
}
