package wk6;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

class ListTest {
    private List<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    void size() {
        Assertions.assertEquals(0, list.size());
        list.add("one");
        Assertions.assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(list.isEmpty());
        list.add("one");
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void add() {
        list.add("one");
        Assertions.assertEquals(1, list.size());
        list.add("two");
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void clear() {
        list.clear();
        Assertions.assertTrue(list.isEmpty());
        list.add("one");
        list.clear();
        Assertions.assertTrue(list.isEmpty());
        list.add("one");
        list.add("one");
        list.add("one");
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void addInt() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, null));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, null));

        list.add(0, "one");
        Assertions.assertEquals(1, list.size());

        list.add(0, "two");
        Assertions.assertEquals(1, list.indexOf("one"));
        Assertions.assertEquals(0, list.indexOf("two"));

        list.add(2, "three");
        Assertions.assertEquals(2, list.indexOf("three"));
        Assertions.assertEquals(1, list.indexOf("one"));
        Assertions.assertEquals(0, list.indexOf("two"));

        list.add(1, "four");
        Assertions.assertEquals(1, list.indexOf("four"));
        Assertions.assertEquals(3, list.indexOf("three"));
        Assertions.assertEquals(2, list.indexOf("one"));
        Assertions.assertEquals(0, list.indexOf("two"));
    }

    @Test
    void contains() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add(null);
        Assertions.assertFalse(list.contains(""));
        Assertions.assertTrue(list.contains("two"));
        Assertions.assertTrue(list.contains(null));
        Assertions.assertFalse(list.contains(3));
    }

    @Test
    void get() {
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertEquals("one", list.get(0));
        Assertions.assertEquals("two", list.get(1));
        Assertions.assertEquals("three", list.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void set() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.set(0, "1");
        Assertions.assertEquals("1", list.get(0));
        list.set(2, "3");
        Assertions.assertEquals("3", list.get(2));
        list.set(2, null);
        Assertions.assertNull(list.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, ""));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, ""));
    }

    @Test
    void remove() {
        Assertions.assertFalse(list.remove(""));
        Assertions.assertFalse(list.remove("two"));
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertTrue(list.remove("two"));
        Assertions.assertFalse(list.remove("two"));
    }

    @Test
    void removeIntBad() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        list.add("one");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @Test
    void removeIntFirst() {
        list.add("one");
        Assertions.assertEquals("one", list.remove(0));
        list.add("one");
        list.add("two");
        Assertions.assertEquals("two", list.remove(1));
        Assertions.assertFalse(list.contains("two"));
        Assertions.assertTrue(list.contains("one"));
        Assertions.assertEquals("one", list.remove(0));
        Assertions.assertFalse(list.contains("one"));
    }

    @Test
    void removeIntLast() {
        list.add("one");
        list.add("two");
        list.add("three");
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        Assertions.assertEquals("three", list.remove(2));
        Assertions.assertFalse(list.contains("three"));
        Assertions.assertTrue(list.contains("two"));
        Assertions.assertEquals("two", list.remove(1));
        Assertions.assertTrue(list.contains("one"));
    }

    @Test
    void removeIntNull() {
        list.add(null);
        Assertions.assertNull(list.remove(0));
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(-1, list.indexOf("not found"));
        list.add("one");
        list.add("two");
        list.add("three");
        list.add(null);
        Assertions.assertEquals(-1, list.indexOf(""));
        Assertions.assertEquals(1, list.indexOf("two"));
        Assertions.assertEquals(3, list.indexOf(null));
        Assertions.assertEquals(-1, list.indexOf(3));
    }

    @Test
    void toArray() {
        list.add("one");
        list.add("two");
        list.add("three");
        Object[] expected = {"one", "two", "three"};
        Assertions.assertArrayEquals(expected, list.toArray());
    }

    @Test
    void toArrayEmpty() {
        Object[] expected = {};
        Assertions.assertArrayEquals(expected, list.toArray());
    }
}