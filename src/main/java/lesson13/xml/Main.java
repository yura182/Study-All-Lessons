package lesson13.xml;

import javax.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob", "Barker", 27);
        User newUser = null;
        String fileName = "./temp/user.xml";

        try {
            ObjectBinding<User> objectBinding = new ObjectBinding<>(user, fileName);
            objectBinding.objectToXML();
            newUser = objectBinding.objectFromXML();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println(newUser);

    }
}
