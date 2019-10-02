package prototype;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Kyiv", 2232);
        User user = new User(address, "Yura", "Petr");
        User userClone = user.clone();

        System.out.println(user == userClone);
        System.out.println(user.equals(userClone));
    }
}
