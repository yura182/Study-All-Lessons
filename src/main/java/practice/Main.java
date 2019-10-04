package practice;

public class Main {
    public static void main(String[] args) {
        String str = new String("1");
        Class clsStr = str.getClass();
        System.out.println(clsStr);
        Class cls = clsStr.getClass().getSuperclass();
        System.out.println(cls);

        Object[] array = new Object[Integer.MAX_VALUE-1];
    }
}
