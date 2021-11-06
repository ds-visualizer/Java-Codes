public class PriorityQueue {

  // We will be using the heap abstract class,
  // Since it puts the max values on top and our
  // Look up time would then be O(1) to find
  // biggest priority task

  Heap heap = new Heap();

  public void insert(int value) {
    heap.insert(value);
  }

  public int peek() {

    return heap.peek();
  }

  public void remove() {
    heap.remove();
  }

  @Override
  public String toString() {
    return heap.toString();
  }
}
