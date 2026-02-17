package wk4;

import java.util.List;
import java.util.function.Predicate;

public class Functional {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> odds = getOdds(nums);
    }

    private static List<Integer> getOdds(List<Integer> nums) {
        return nums.stream()
                .filter(integer -> integer % 2 == 1)
                .toList();
    }
}
