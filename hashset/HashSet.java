import java.util.*;

class HashSet{

  class Entry {
    Integer key;

    Entry(Integer key) {
      this.key = key;
    }

  }

  private LinkedList<Entry>[] set = new LinkedList[10];

  private int hash(Integer key) {

    return key % set.length;
  }

  private Entry getEntry(Integer key, LinkedList<Entry> entries) {

    for (Entry entry : entries) {
      if (entry.key.equals(key))
        return entry;
    }

    return null;
  }

  void add(Integer key) {
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

  void remove(Integer key) {
    int hash = hash(key);
    LinkedList<Entry> entries = set[hash];

    if (entries == null)
      return;

    Entry entry = getEntry(key, entries);

    if (entry == null)
      return;

    entries.remove(entry);
  }

  boolean has(Integer key) {
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