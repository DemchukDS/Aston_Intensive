package StreamTraining;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    private static List<Integer> numbers = new ArrayList<>();

    public static List<Integer> findListRandomNumbers() {
        Random random = new Random();
        for (int i = 0; i < 21; i++) {
            numbers.add(random.nextInt(-100, 100));
        }
        return numbers;
    }
}
