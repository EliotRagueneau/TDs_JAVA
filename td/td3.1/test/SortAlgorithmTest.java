import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SortAlgorithmTest {
    private static String[] toSort;
    private static String[] answer;

    @BeforeAll
    static void generateStringsToSort() {
        final int NB_STRINGS_TO_SORT = 1000;
        final int MAX_LENGTH_STRING = 50;
        final int LOWER_BOND = 'A';
        final int UPPER_BOND = 'z';
        toSort = new String[NB_STRINGS_TO_SORT];
        Random r = new Random();
        for (int i = 0; i < NB_STRINGS_TO_SORT; i++) {
            toSort[i] = r.ints(Math.abs(r.nextInt(MAX_LENGTH_STRING)), LOWER_BOND, UPPER_BOND)
                    .mapToObj(c -> Character.toString((char) c))
                    .collect(Collectors.joining());
        }
        answer = toSort.clone();
        Arrays.sort(answer, String::compareTo);
    }

    @Test
    void insertSort() {
        String[] output = InsertSort.getInstance().sort(toSort);
        assertArrayEquals(output, answer);
    }

    @Test
    void basicSort() {
        String [] output = toSort.clone();
        Arrays.sort(output, String::compareTo);
        assertArrayEquals(output, answer);
    }

    @Test
    void trueInsertSort() {
        String[] output = InsertSort.getInstance().insertionSort(toSort);
        assertArrayEquals(output, answer);
    }
}