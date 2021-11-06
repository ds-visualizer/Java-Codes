public class Main {

  public static void main(String[] args) {
    PriorityQueue queue = new PriorityQueue();
    queue.peek();
    // Even though the array isn't sorted, the most important task will always be at
    // the first, even after removing

    System.out.println(queue);
  }
}
