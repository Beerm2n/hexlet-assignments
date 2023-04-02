package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static <T> List findWhere(List<T> list, T map) {
        List<T> books = new ArrayList<>();
        Map test = (Map) map;
        for (T obj : list) {
            Map test2 = (Map) obj;
            if (test2.entrySet().containsAll(test.entrySet())) {
                books.add(obj);
            }
        }
        return books;
    }

    public static void main(String[] args) {
        Map<String, String> book1 = new HashMap<>(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book2 = new HashMap<>(
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111")
        );
        Map<String, String> book3 = new HashMap<>(
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book4 = new HashMap<>(
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222")
        );
        Map<String, String> book5 = new HashMap<>(
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333")
        );
        List<Map> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));
        List<Map> result = findWhere(books, where);
        System.out.println(result);
    }


}
//END
