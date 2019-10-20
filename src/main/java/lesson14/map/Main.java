package lesson14.map;

public class Main {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.find(10));
        System.out.println(fibonacci.find(5));
        System.out.println(fibonacci.find(-8));
    }
}
