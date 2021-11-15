import java.util.*;

public class HashMap<T, E> {

  // constructor

  class Entry {
    T key;
    E value;

    Entry(T key, E value) {
      this.key = key;
      this.value = value;
    }

  }

  private LinkedList<Entry>[] map = new LinkedList[10];

  private int hash(T key) {

    // This hashcode function returns an integer and is specifically made for
    // these purposes like hashing, hash sets and etc.

    // Each object in java gets their own unique hashcode but we will only take the
    // integer in the one's position for our hash function in order to understand
    // collisions

    // suppose our hashcode returns 123439, our hash function only returns 9

    return Math.abs(key.hashCode() % 10);
  }

  private Entry getEntry(T key, LinkedList<Entry> entries) {

    for (Entry entry : entries)
      if (entry.key == key)
        return entry;

    return null;
  }

  void put(T key, E value) {

    int hashNumber = hash(key);

    LinkedList<Entry> entries = map[hashNumber];

    if (entries == null) {
      entries = new LinkedList<Entry>();

      // This step for putting the linkedlist into the array
      // So it gets the reference

      map[hashNumber] = entries;
    }

    Entry entry = getEntry(key, entries);

    if (entry != null)
      return;

    entries.add(new Entry(key, value));
  }

  void remove(T key) {

    LinkedList<Entry> entries = map[hash(key)];

    if (entries == null)
      return;

    Entry entry = getEntry(key, entries);

    if (entry == null)
      return;

    entries.remove(entry);

  }

  boolean contain(T key) {
    LinkedList<Entry> entries = map[hash(key)];

    if (entries == null)
      return false;

    Entry entry = getEntry(key, entries);

    if (entry == null)
      return false;

    return true;
  }

}

