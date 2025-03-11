import java.util.Scanner;

public class farenheitToCelsius {
    public static void main(String[] args) {
        Scanner temperature = new Scanner(System.in);
        System.out.print("Introduce temperature in farenheit: ");
        if (!temperature.hasNextInt())
            throw new IllegalArgumentException("Invalid temperature value");
        int farenheit = temperature.nextInt();
        System.out.print("Introduce day: ");
        String day = temperature.next();
        double celsius = (5.0/9) * (farenheit - 32);
        System.out.println(day + "'s temperature in celsius is: " + celsius);
    }
}

