package wk4;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        list.add("Wow");
        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
    }
}
