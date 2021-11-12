import java.util.*;

class Heap {

  private LinkedList<Integer> heap = new LinkedList<Integer>();

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index))
      return true;

    if (!hasRightChild(index))
      return heap.get(index) >= leftChild(index);

    return (heap.get(index) >= leftChild(index) && heap.get(index) >= rightChild(index));
  }

  private int leftChild(int index) {
    return heap.get(leftChildIndex(index));
  }

  private int rightChild(int index) {
    return heap.get(rightChildIndex(index));
  }

  private int parent(int index) {
    return heap.get(parentIndex(index));
  }

  private int leftChildIndex(int index) {
    return (2 * index) + 1;
  }

  private int rightChildIndex(int index) {
    return (2 * index) + 2;
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) < heap.size();
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) < heap.size();
  }

  private int parentIndex(int index) {

    // Returns the parent index of the index

    return (index - 1) / 2;
  }

  private void bubbleDown(int parent, int child) {
    swap(heap, parent, child);
  }

  private void bubbleUp(int index) {
    // heap is a global variable, and this method is specific to that heap array
    // So I dont find a need of passing array in the parameter.

    swap(heap, index, parentIndex(index));
  }

  private void swap(LinkedList<Integer> arr, int index1, int index2) {

    Collections.swap(arr, index1, index2);
  }

  private int largerChildIndex(int index) {

    if (!hasRightChild(index))
      return leftChildIndex(index);

    return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
  }

  public void insert(int value) {
    heap.add(value);
    int index = heap.size() - 1; // Since it gets added in the last

    // Now we want to bubble the elements so they satisfy the heap property

    while (heap.get(index) > parent(index)) {
      bubbleUp(index);
      index = parentIndex(index);
    }
  }

  public void remove() {

    if (heap.isEmpty())
      throw new RuntimeException("Heap empty");

    heap.removeFirst();
    heap.addFirst(heap.pollLast());

    int index = 0;

    while (index < heap.size() && !isValidParent(index)) {
      int largerChild = largerChildIndex(index);

      bubbleDown(index, largerChild);
      index = largerChild;

    }

  }

  public boolean isEmpty() {
    return heap.size() == 0;
  }

  public int peek() {
    if (heap.isEmpty())
      throw new RuntimeException("Heap empty");

    return heap.peek();
  }

  @Override
  public String toString() {

    return heap.toString();
  }
}