package exercise;

import java.util.List;

public class App {

    public static Integer getCountOfFreeEmails(List<String> emails) {
        List<String> freeHosts = List.of("@yandex.ru", "@gmail.com", "@hotmail.com");
        long amountOfFreeEmails = emails.stream()
                .filter(email -> freeHosts.stream().anyMatch(freehost -> email.contains(freehost)))
                .count();
        return (int) amountOfFreeEmails;
    }

}
