import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class UniqueIntegerDetector {
    public static List<Integer> findElementsInTargetSumPairs(List<Integer> numbers, int target) {
        if (numbers == null || numbers.isEmpty()) return new ArrayList<>();
        HashSet<Integer> participates = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == target) {
                    participates.add(numbers.get(i));
                    participates.add(numbers.get(j));
                }
            }
        }
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        for (Integer num : numbers) {
            if (participates.contains(num)) {
                result.add(num);
            }
        }

        return new ArrayList<>(result);
    }
}