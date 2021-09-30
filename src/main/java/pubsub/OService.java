package pubsub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Objects.isNull;


public class OService {

  private final Map<EventType, Consumer> consumers = new ConcurrentHashMap<>();
  private final List<ExecutorService> executorServices = new ArrayList<>();
  private final int executorCount = 10;
  private final Cache<String, Long> cache = new TTLCache<>(10);

  private OService() {
    for (int __ = 0; __ < executorCount; ++__) {
      executorServices.add(Executors.newFixedThreadPool(1));
    }
  }

  public void registerConsumer(Consumer consumer) {
    consumers.put(consumer.eventType(), consumer);
  }

  public void send(Event event) {
    if (!consumers.containsKey(event.type())) return;
    Consumer consumer = consumers.get(event.type());
    boolean isDuplicate = addToCacheAndGetDuplicateStatus(event);

    if (!isDuplicate) executorService(event.source()).submit(() -> consumer.receive(event));
  }

  private synchronized boolean addToCacheAndGetDuplicateStatus(Event event) {
    boolean isPresent = cache.containsKey(event.id());
    if (isPresent) return true;
    cache.put(event.id(), System.currentTimeMillis());
    return false;
  }

  private ExecutorService executorService(EventSource source) {
    return executorServices.get(source.hashCode() % executorCount);
  }

  public static void main(String[] args) {
    Point p = new Point(1, 2);
    System.out.println(p);
    test(p);
    System.out.println(p);
  }

  public static void test(Point p) {
    Point x = new Point(2, 3);
    System.out.println(p);
    p = x;
    System.out.println(p);
  }

}

class EventType {
  private String type;

  public static EventType of(String type) {
    EventType eventType = new EventType();
    eventType.type = type;
    return eventType;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof EventType) {
      return ((EventType) obj).type.equals(this.type);
    }
    return false;
  }
}

class EventSource {

}

class Event {

  private String id;
  private EventType type;
  private EventSource source;


  public static Event of(String id, EventType type) {
    Event event = new Event();
    event.id = id;
    event.type = type;
    return event;
  }

  public String id() {
    return id;
  }

  public EventType type() {
    return type;
  }

  public EventSource source() {
    return source;
  }
}


class Consumer {
  private EventType eventType;

  public EventType eventType() {
    return eventType;
  }

  public void receive(Event event) {

  }

}

interface Cache<K, V> {

  V get(K key);

  boolean containsKey(K key);

  void put(K key, V value);

  void remove(K key);

}

class TTLCache<K, V> implements Cache<K, V> {

  private final Map<K, V> values = new ConcurrentHashMap<>();
  private final Map<K, Long> ttlMap = new ConcurrentHashMap<>();
  private final long ttlMS;
  private final int maxMapSize = 2000;


  public TTLCache(long ttlMS) {
    this.ttlMS = ttlMS;
  }

  @Override
  public V get(K key) {
    cleanKey(key);
    return values.get(key);
  }

  @Override
  public boolean containsKey(K key) {
    cleanKey(key);
    return ttlMap.containsKey(key);
  }

  @Override
  public void put(K key, V value) {
    cleanMap();
    ttlMap.put(key, System.currentTimeMillis());
  }

  @Override
  public void remove(K key) {
    values.remove(key);
    ttlMap.remove(key);
  }

  private void cleanMap() {
    if (values.size() <= maxMapSize) return;
    for (K key : values.keySet()) {
      cleanKey(key);
    }
  }

  private void cleanKey(K key) {
    Long insertTime = ttlMap.get(key);
    if (isNull(insertTime)) return;
    if (System.currentTimeMillis() - insertTime > ttlMS) {
      remove(key);
    }
  }


}

class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return x + ":" + y;
  }
}