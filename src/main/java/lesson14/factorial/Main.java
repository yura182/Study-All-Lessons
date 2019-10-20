package lesson14.factorial;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();

        Long result = factorial.factorial(21).orElse(0);

        System.out.println(result);
    }
}
