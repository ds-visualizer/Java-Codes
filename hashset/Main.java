class Main {

  public static void main(String[] args) {
    var set = new HashSet();

    set.add(10);
    System.out.println(set.has(10));
    set.remove(10);
    System.out.println(set.has(10));

  }
}