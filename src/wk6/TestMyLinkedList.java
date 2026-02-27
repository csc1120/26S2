package wk6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMyLinkedList {
    @DisplayName("Testing size after construction")
    @Test
    public void testConstructorSize(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Assertions.assertEquals(0, list.size(),
                "The size of the initial list should be 0");

    }
    @DisplayName("Testing size after adding stuff")
    @Test
    public void addSizeTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assertions.assertEquals(5, list.size(),
                "Size of list after adding 5 elemennts should be 5");
    }
    @DisplayName("Testing get after a bunch of adds")
    @Test
    public void addGetTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        for(int i = 0; i<expected.size(); i++){
            Assertions.assertEquals(expected.get(i), list.get(i),
                    "Error comparing element at index "+i);
        }
    }
    @Test
    public void removeTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assertions.assertEquals(1, list.remove(0),
                "Element removed at index 0 should be 1");
        List<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        expected.remove(0);
        for(int i = 0; i<expected.size(); i++){
            Assertions.assertEquals(expected.get(i), list.get(i),
                    "Error comparing element at index "+i);
        }


    }
}