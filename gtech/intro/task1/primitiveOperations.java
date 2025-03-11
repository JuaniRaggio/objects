public class primitiveOperations {
    public static void main(String[] args) {
        short edad = 22;
        float peso = 88.5F;
        System.out.println(edad);
        System.out.println(peso);

        float multiplication = edad * peso;
        System.out.println(multiplication);

        double newDouble = (double)edad;
        System.out.println(newDouble);

        short newShort = (short)peso;
        System.out.println("Expected 88, result: " + newShort);

        char letter = 'A';
        System.out.println("Expected: A, result: " + letter);

        char itsLowerCase = (char)(letter + ('a' - 'A'));
        System.out.println("Expected: a, result: " + itsLowerCase);
    }
}

