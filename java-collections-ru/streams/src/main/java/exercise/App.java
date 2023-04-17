package exercise;

import java.util.Arrays;
import java.util.List;

public class App {

    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeHosts = Arrays.asList("yandex.ru", "gmail.com", "hotmail.com");
        return emails
                .stream()
                .map(email -> email.split("@")[1])
                .filter(freeHosts::contains)
                .count();
    /*    Set<String> freeHosts = Set.of("yandex.ru", "gmail.com", "hotmail.com");
        return (int) emails.stream()
                .map(email -> email.substring(email.indexOf('@') + 1))
                .filter(freeHosts::contains)
                .count(); */
    }

}
