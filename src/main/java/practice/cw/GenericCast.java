package practice.cw;

public class GenericCast {
    static <E> E cast(Object item) {
        return (E) item;
    }

    public static void main(String[] args) {
        Object o1 = 10;
        int i = 10;
        Integer anInteger = 10;
        Integer i1 = GenericCast.<Integer>cast(o1);
        Integer i2 = cast(i);
        Integer i3 = cast(10);
        Integer i4 = cast(anInteger);
        System.out.println("" + i1 + i2 + i3 + i4);
    }
}
