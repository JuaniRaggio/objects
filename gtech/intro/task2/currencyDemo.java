import java.util.Scanner;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class currencyDemo{
    public static void main(String[] args) {
        double discount = 0.7; // 30% descuento
        LocalDate date = LocalDate.now();
        DayOfWeek today = date.getDayOfWeek();
        Scanner buffer = new Scanner(System.in);
        boolean cleanBuffer = false;
        do {
            if (cleanBuffer) buffer.nextLine();
            System.out.print("Introduce the amount of items: ");
            cleanBuffer = true;
        } while (!buffer.hasNextInt());
        int amount = buffer.nextInt();

        cleanBuffer = false;
        do {
            if (cleanBuffer) buffer.nextLine();
            System.out.print("Introduce the price of the items: ");
            cleanBuffer = true;
        } while(!buffer.hasNextDouble());
        double price = buffer.nextDouble();
        double totalPrice = today == DayOfWeek.THURSDAY ? price * amount * discount:price * amount;
        System.out.println("The total price without formating is: " + totalPrice);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println("The total price is: " + currencyFormat.format(totalPrice));
    }
}

