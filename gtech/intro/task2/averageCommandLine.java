public class averageCommandLine {
    public static void main(String args[]) {
        double ans = 0;
        for (String value : args) {
            ans += Double.parseDouble(value);
        }
        ans = args.length != 0 ? ans/args.length:0;
        System.out.println(ans);
    }
}

