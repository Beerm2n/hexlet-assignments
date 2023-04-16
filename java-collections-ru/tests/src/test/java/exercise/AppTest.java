package exercise;

//import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List<Integer> numbers;

    @BeforeAll
    static void prepare() {
        System.out.println("Preparations for test");
    }

    @BeforeEach
    void initList() {
        numbers = new ArrayList<>();
        this.numbers.add(1);
        this.numbers.add(2);
        this.numbers.add(3);
        this.numbers.add(4);
        this.numbers.add(5);
        this.numbers.add(6);
        this.numbers.add(7);
        this.numbers.add(8);
        this.numbers.add(9);
        this.numbers.add(10);
    }

    @Test
    void testTake() {
        Assertions.assertEquals(App.take(numbers, 5), Arrays.asList(1, 2, 3, 4, 5));

    }

    @Test
    void testTakeMax() {
        Assertions.assertEquals(App.take(numbers, 10), numbers);
    }

    @Test
    void testTakeZero() {
        Assertions.assertEquals(App.take(numbers, 0), Arrays.asList());
    }
}
