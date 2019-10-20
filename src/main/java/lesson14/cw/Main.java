package lesson14.cw;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

//Stream
public class Main {
    public static void main(String[] args) {
        final List<String> strings = asList("one", "two", "three", "one", null);
        final long count = strings.stream()
                .filter(Objects::nonNull)
                .filter("one"::equals)
                .count();
        System.out.println(count);

        System.out.println("version 1:");
        strings.forEach(System.out::println);
        System.out.println("version 2:");
        strings.stream().map(x -> x + "____").forEach(System.out::println);

        final List<Client> clients = asList(
                new Client("one", asList(new Item(1), new Item(2))),
                new Client("two", asList(new Item(3), new Item(4), new Item(4))),
                new Client("two", asList(new Item(6))),
                new Client("three", null),
                null
        );
        clients.forEach(System.out::println);
        final List<Item> items = clients.stream()
                .filter(Objects::nonNull)
                .filter(x -> nonNull(x.getItems()))
                .flatMap(x -> x.getItems().stream())
                .collect(toList());
        items.forEach(System.out::println);

        final List<Item> items1 = clients.stream()
                .flatMap(x -> Optional.ofNullable(x)
                        .map(Client::getItems)
                        .map(Collection::stream)
                        .orElse(Stream.empty()))
                .collect(toList());

        final List<Client> users = asList(
                new Client("one", asList(new Item(1), new Item(2)), Role.ADMIN),
                new Client("two", asList(new Item(3), new Item(4), new Item(4)), Role.USER),
                new Client("three", asList(new Item(6)), Role.ADMIN),
                new Client("four", asList(new Item(6)))
        );

        Map<Role, List<String>> roleToItems = users.stream()
                .collect(Collectors
                        .groupingBy(Client::getRole, Collectors.mapping(Client::getName, Collectors.toList())));

        roleToItems.forEach((key, value) -> System.out.println(key + " " + value));
    }
}