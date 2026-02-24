package wk6;

import java.util.List;
import java.util.Objects;

public class Exam {
    private Object[] data;

    public boolean remove(Object target) {
        boolean changed = false;
        int index = -1;
        for (int i = 0; index == -1 && i < data.length; i++) {
            if (Objects.equals(data[i], target)) {
                index = i;
            }
        }
        if (index != -1) {
            Object[] temp = new Object[data.length - 1];
            System.arraycopy(data, 0, temp, 0, index);
            System.arraycopy(data, index + 1, temp, index, data.length - 1 - index);
            data = temp;
        }
        return changed;
    }

    public static List<Integer> questionTwo(List<String> words) {
        return words.stream()
                .map(w -> w.length())
                .filter(i -> i < 8)
                .toList();
    }
    public static List<Integer> questionEleven(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n < 13 || n > 19)
                .toList();
    }
}
