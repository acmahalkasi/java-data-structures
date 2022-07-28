package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("ahmet", 1));
        userList.add(new User("nergis", 2));
        userList.add(new User("okkes", 3));
        userList.add(new User("serdar", 4));
        userList.add(new User("isim", 5));
        userList.add(new User("name", 6));

        var filteredList = userList.stream().filter(user -> user.id > 3).collect(Collectors.toList());
        System.out.println("filteredList:");
        filteredList.forEach(System.out::println);

        System.out.println("mappedList");
        var mappedList = userList.stream().map(user -> {
            user.id = user.id + 100;
            user.name = "/" + user.name;
            return user;
        }).collect(Collectors.toMap(user -> user.id, user -> user.name));
        mappedList.forEach((userKey, userVal) -> System.out.printf("userKey->userName %d %s\n", userKey, userVal));

        userList.forEach(System.out::println);

        Predicate<User> idPredicate = user -> user.getId()>4;
        Predicate<User> namePredicate = user -> user.getName().startsWith("/");

        System.out.printf("idPredicate noneMatch %b\n",userList.stream().noneMatch(idPredicate));
        System.out.printf("idPredicate anyMatch %b\n", userList.stream().anyMatch(idPredicate));
        System.out.printf("idPredicate allMatch %b\n", userList.stream().allMatch(idPredicate));


        System.out.printf("namePredicate noneMatch %b\n",userList.stream().noneMatch(namePredicate));
        System.out.printf("namePredicate anyMatch %b\n", userList.stream().anyMatch(namePredicate));
        System.out.printf("namePredicate allMatch %b\n", userList.stream().allMatch(namePredicate));

        List<String> users = userList.stream()
                .map(user -> user.getName().split("/"))
                .flatMap(Arrays::stream)
                .toList();
        users.forEach(System.out::println);
    }



}
class User {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

