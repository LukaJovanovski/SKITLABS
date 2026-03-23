import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

    class UniqueIntegerDetectorTester{

        // T1 - Base test: повеќе вредности, дупликати, позитивен target, постојат парови
        @Test
        void testBaseCase() {
            List<Integer> numbers = List.of(1, 4, 5, 3, 2, 4, 6);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 7);
            assertEquals(List.of(1, 4, 5, 3, 2, 6), result);
        }

        // T2 - Празна листа
        @Test
        void testEmptyList() {
            List<Integer> numbers = List.of();
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 7);
            assertEquals(List.of(), result);
        }

        // T3 - Една вредност (не може да формира пар)
        @Test
        void testSingleElement() {
            List<Integer> numbers = List.of(5);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 5);
            assertEquals(List.of(), result);
        }
        @Test
        void testSimilarToBaseCase() {
            List<Integer> numbers = List.of(1, 4, 5, 3, 2, 4, 6,9,11,14);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 15);
            assertEquals(List.of(1,4,6,9,11,14), result);
        }
        @Test
        void testNegativeNumbersCase(){
            List<Integer> numbers = List.of(30,40,-20,30,-18,80,20,55,70,60,-35,120);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 100);
            assertEquals(List.of(30,40,-20,80,20,70,60,120),result);
        }
        // T4 - Негативен target
        @Test
        void testNegativeTarget() {
            List<Integer> numbers = List.of(1, 4, 5, 3, 2, 4, 6);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, -1);
            assertEquals(List.of(), result);
        }

        // T5 - Target = 0
        @Test
        void testZeroTarget() {
            List<Integer> numbers = List.of(1, 4, 5, 3, 2, 4, 6);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 0);
            assertEquals(List.of(), result);
        }

        // T6 - Нема парови кои сумираат до target
        @Test
        void testNoPairsExist() {
            List<Integer> numbers = List.of(1, 2, 3, 4);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 100);
            assertEquals(List.of(), result);
        }

        // T7 - Null листа
        @Test
        void testNullList() {
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(null, 7);
            assertEquals(List.of(), result); // или assertThrows ако фрла exception
        }

        // T8 - Само еден пар, без дупликати
        @Test
        void testOnePairNoDuplicates() {
            List<Integer> numbers = List.of(3, 4);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 7);
            assertEquals(List.of(3, 4), result);
        }
        @Test
        void testDuplicates() {
            List<Integer> numbers = List.of(6,3,7,3,6,10,6,10,7,5,4);
            List<Integer> result = UniqueIntegerDetector.findElementsInTargetSumPairs(numbers, 10);
            assertEquals(List.of(6,3,7,4), result);
        }
    }
