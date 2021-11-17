import java.util.*;

class Set<T> {

  class Entry {
    T key;

    Entry(T key) {
      this.key = key;
    }

  }

  private LinkedList<Entry>[] set = new LinkedList[10];

  private int hash(T key) {

    return key.hashCode() % set.length;
  }

  private Entry getEntry(T key, LinkedList<Entry> entries) {

    for (Entry entry : entries) {
      if (entry.key.equals(key))
        return entry;
    }

    return null;
  }

  void add(T key) {
    int hash = hash(key);
    LinkedList<Entry> entries = set[hash];

    if (entries == null) {

      entries = new LinkedList<Entry>();
      set[hash] = entries;

    }

    Entry entry = getEntry(key, entries);

    if (entry != null)
      return;

    entries.add(new Entry(key));
  }

  void remove(T key) {
    int hash = hash(key);
    LinkedList<Entry> entries = set[hash];

    if (entries == null)
      return;

    Entry entry = getEntry(key, entries);

    if (entry == null)
      return;

    entries.remove(entry);
  }

  boolean has(T key) {
    int hash = hash(key);
    LinkedList<Entry> entries = set[hash];

    if (entries == null)
      return false;

    Entry entry = getEntry(key, entries);

    if (entry == null)
      return false;

    return true;
  }

}