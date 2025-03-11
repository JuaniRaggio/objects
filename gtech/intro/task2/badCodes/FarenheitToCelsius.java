/*
 * I honestly didn't get why they are doing this, literally there is nothing changing
 * between each set of instructions
 * */
import java.util.Scanner;
public class FahrenheitToCelsius {
    public static void main(String[] args) {
        final int MIN_PARK_TEMP = 70;
        final int MAX_PARK_TEMP = 90;

        Scanner input = new Scanner(System.in);
        int fahrenheit;
        boolean raining;
        String day;
        double celsius;
        String rainInput;

        System.out.print("Enter a Fahrenheit value: ");
        fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        day = input.next();
        celsius = (5.0 / 9) * (fahrenheit - 32);
        
        raining = false;
        System.out.print("Is it raining? (y/n): ");
        rainInput = input.next().toLowerCase();
        if (rainInput.startsWith("y")) {
            raining = true;
        }
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius:", celsius);
        if ((fahrenheit >= MIN_PARK_TEMP) && (fahrenheit <= MAX_PARK_TEMP) && !raining) {
            System.out.println("Yay! It’s at least "
                               + MIN_PARK_TEMP
                               + " degrees but under "
                               + MAX_PARK_TEMP
                               + ".");
            System.out.println("Time to go to park.");
        } else {
            System.out.println("Stay home where there’s wi-fi and learn 1331 online");
        }

        System.out.print("Enter a Fahrenheit value: ");
        fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        day = input.next();
        celsius = (5.0 / 9) * (fahrenheit - 32);

        raining = false;
        System.out.print("Is it raining? (y/n): ");
        rainInput = input.next().toLowerCase();
        if (rainInput.startsWith("y")) {
            raining = true;
        }

        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius:", celsius);
        if ((fahrenheit >= MIN_PARK_TEMP) && (fahrenheit <= MAX_PARK_TEMP) && !raining) {
            System.out.println("Yay! It’s at least "
                               + MIN_PARK_TEMP
                               + " degrees but under "
                               + MAX_PARK_TEMP
                               + ".");
            System.out.println("Time to go to park.");
        } else {
            System.out.println("Stay home where there’s wi-fi and learn 1331 online");
        }

        System.out.print("Enter a Fahrenheit value: ");
        fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        day = input.next();
        celsius = (5.0 / 9) * (fahrenheit - 32);

        raining = false;
        System.out.print("Is it raining? (y/n): ");
        rainInput = input.next().toLowerCase();
        if (rainInput.startsWith("y")) {
            raining = true;
        }
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius:", celsius);
        if ((fahrenheit >= MIN_PARK_TEMP) && (fahrenheit <= MAX_PARK_TEMP) && !raining) {
            System.out.println("Yay! It’s at least "
                               + MIN_PARK_TEMP
                               + " degrees but under "
                               + MAX_PARK_TEMP
                               + ".");
            System.out.println("Time to go to park.");
        } else {
            System.out.println("Stay home where there’s wi-fi and learn 1331 online");
        }
    }
}
