public class StringOperations {
    public static void main(String[] args) {
        String myName = new String("Juan Ignacio");
        // You can also do it simpler in the case of Strings
        // String myName = "Juan Ignacio"
        System.out.println(myName);

        myName = myName.replace("Juan Ignacio", "Auan IgnaciZ");
        System.out.println(myName);

        String url = "www.stackoverflow.com";
        System.out.println(url);

        int firstDot = url.indexOf("."), lastDot = url.lastIndexOf(".");
        String name = url.substring(firstDot + 1, lastDot);
        System.out.println(name);

        int number = 1331;
        System.out.println(name + number);
    }
}

