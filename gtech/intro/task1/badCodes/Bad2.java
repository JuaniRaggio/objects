public class Bad2 {
    public static void main(String[] args) {
        int a = 1331;
        int b = 0;
        System.out.println("Welcome to \nCS 1331!");
        int c = a / b;// b is 0 and its a math error -> Exception
        System.out.println("c is equal to: " + c);
    }
}
