package wk8;

import java.util.List;
import java.util.Objects;

public class Driver {
    public static void main(String[] args) {
        System.out.println(binarySearch(List.of((short)0, (short)1, (short)2, (short)3, (short)4, (short)5), (short)8));
        System.out.println(binarySearch(List.of((short)0, (short)1, (short)2, (short)3, (short)4, (short)5), (short)3));
        System.out.println(binarySearch(List.of((short)0, (short)1, (short)2, (short)3, (short)4, (short)5), (short)5));
        System.out.println(binarySearch(List.of((short)0, (short)1, (short)2, (short)3, (short)4, (short)5), (short)1));
        System.out.println(binarySearch(List.of((short)0, (short)1, (short)2, (short)3, (short)4, (short)5), (short)0));
    }

    public static boolean binarySearch(List<Short> list, short target) {
        boolean found = false;
        if (!list.isEmpty()) {
            int midpoint = list.size() / 2;
            int comparison = list.get(midpoint) - target;
            if (comparison < 0) {
                found = binarySearch(list.subList(midpoint + 1, list.size()), target);
            } else if (comparison == 0) {
                found = true;
            } else {
                found = binarySearch(list.subList(0, midpoint), target);
            }
        }
        return found;
    }


    public static boolean binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size();
        boolean found = false;
        while (start != end && !found) {
            int midpoint = (end + start) / 2;
            int comparison = list.get(midpoint) - target;
            if (comparison < 0) {
                start = midpoint + 1;
            } else if (comparison == 0) {
                found = true;
            } else {
                end = midpoint;
            }
        }
        return found;
    }
}
