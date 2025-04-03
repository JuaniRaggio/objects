public class Palindromo {

  public static void main(String[] args) {
    StringBuilder pali = new StringBuilder();
    for (String arg : args) {
      pali.append(arg.toLowerCase());
    }
    System.out.println(check_pal(pali) ? "Es palindromo":"No es palindromo");
  }

  private static boolean check_pal(StringBuilder str) {
    for (int i = 0, j = str.length() - 1; i < j; ++i, --j) {
      if (str.charAt(i) != str.charAt(j)) return false;
    }
    return true;
  }
}
