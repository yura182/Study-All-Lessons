package list;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(null);
        for (int i = 1; i <= 19; i++) {
            strings.add("" + i);
        }

        System.out.println(strings);

        strings.remove("10");
        strings.remove("1");
        strings.remove("20");

        System.out.println(strings);

        strings.remove(null);
        System.out.println(strings.getByIndex(10));
        for (String s: strings) {
            System.out.print(s + " ");
        }
        System.out.println();

//        LinkedList<Integer> numbers = new LinkedList<>();
//
//        numbers.add(null);
//        numbers.add(11);
//        numbers.add(12);
//
//        for (Integer number : numbers) {
//            System.out.print(number + " ");
//        }
//        System.out.println();
//
//        numbers.remove(null);
//
//        for (Integer number : numbers) {
//            System.out.print(number + " ");
//        }
//        System.out.println();
//
//        numbers.remove(11);
//        numbers.add(111);
//        numbers.add(12);
//
//        for (Integer number : numbers) {
//            System.out.print(number + " ");
//        }
//        System.out.println();


    }
}
