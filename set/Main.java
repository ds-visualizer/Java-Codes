class Main {

  public static void main(String[] args) {
    var set = new Set<String>();

    set.add("a");
    System.out.println(set.has("a"));
    set.remove("a");
    System.out.println(set.has("a"));

  }
}