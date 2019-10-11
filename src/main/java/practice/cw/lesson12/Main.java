package practice.cw.lesson12;

import lesson11.exception.IllegalArgumentRuntimeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class A {
    public int number;

    public A(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return number == a.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "A{" +
                "number=" + number +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Map<A, String> map = new HashMap<>(5);
        A a1 = new A(1000);


        map.put(a1, "Hello1");


        a1.number = 500;
        for (int i = 0; i < 200; i++) {
            map.put(new A(i), "Hello" + i);
        }
        map.forEach((key,value)->System.out.println("key: " + key + " value: " + value));
        a1.number = 1000;
        System.out.println(map.get(a1));

    }


}
