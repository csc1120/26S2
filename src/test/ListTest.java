package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

import java.util.List;

public class ListTest {
    private List<String> strings;

    @BeforeEach
    public void setUp() {
        strings = new LinkedList<>();
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(strings.isEmpty());
        strings.add("a");
        Assertions.assertFalse(strings.isEmpty());
    }
}
