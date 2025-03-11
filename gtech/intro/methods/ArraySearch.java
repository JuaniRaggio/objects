import java.util.Scanner;

public class ArraySearch {
    public static void main(String args[]) {
        // Create an array of strings
        String assignments[] = {"Math", "Physics", "Programming", "Communication Protocols"};
        // Look for a particular assignment
        Scanner input = new Scanner(System.in);
        System.out.print("Introduce the assignment you want to look for: ");
        String toLook = capitalize(input.nextLine());
        System.out.printf("%s was%s", toLook, lookFor(toLook, assignments) == true ? " found successfully!":"n't found");
        input.close();
    }

    public static String capitalize(String str) {
        if (str.length() == 0) return null;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static boolean lookFor(String toLook, String in[]) {
        for (String strs : in) {
            if (strs.equals(toLook)) return true;
        }
        return false;
    }
}

