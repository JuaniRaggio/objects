public class Deletrear {
  public static void main(String[] args) {
    StringBuilder s = new StringBuilder();
    int i;
    for (String arg : args) {
      for (i = 0; i < arg.length() - 1; ++i) {
        s.append(arg.charAt(i));
        s.append('-');
      }
      s.append(arg.charAt(i));
      s.append('\n');
    }
    System.out.println(s);
  }
}

