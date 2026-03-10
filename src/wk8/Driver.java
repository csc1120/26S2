package wk8;

import wk6.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Driver {
    public static void main(String[] args) {
        List<Integer> bigList = makeBigList(999);
        System.out.println("created");
        long start = System.nanoTime();
        binarySearch(bigList, -1);
        long end = System.nanoTime();
        System.out.println("Binary search time: " + (end - start));
        start = System.nanoTime();
        binarySearchR(bigList, -1);
        end = System.nanoTime();
        System.out.println("Recursive Binary search time: " + (end - start));
    }

    private static List<Integer> makeBigList(int size) {
        List<Integer> bigList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            bigList.add(i);
        }
        return bigList;
    }

    public static boolean binarySearchR(List<Integer> list, int target) {
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
