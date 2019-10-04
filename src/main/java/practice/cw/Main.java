package practice.cw;

public class Main {
    public static void main(String[] args) {
        Container container1 = new Container("String");
        Container container2 = new Container(1);

        Object object1 = container1.getObject();

        if (object1 instanceof String) {
            String strObject = (String) object1;
        }

        Object object2 = container2.getObject();

        if (object2 instanceof Integer) {
            Integer integerObject = (Integer) object2;
        }

        GenericContainer<String> genericContainerString = new GenericContainer<>("String");
        GenericContainer<Number> genericContainerInteger = new GenericContainer<>(1);

        String object = genericContainerString.getObject();
        GenericContainer<Object> genericContainer1 = new GenericContainer<>();
        GenericContainer genericContainer2 = new GenericContainer();

        System.out.println(genericContainerString.getClass() == genericContainerInteger.getClass());

    }
}
