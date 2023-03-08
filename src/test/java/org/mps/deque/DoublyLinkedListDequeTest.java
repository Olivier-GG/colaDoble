package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> list;
    DequeNode<Integer> node1, node2;

    @BeforeEach
    public void setUp() {
        node1 = new DequeNode<>(5, null, null);
        node2 = new DequeNode<>(7, null, null);

        node1.next = node2;
        node2.previous = node1;
        node2.next = null;

        list = new DoublyLinkedListDeque<>();
        list.size = 2;
        list.first = node1;
        list.last = node2;
    }

    @AfterEach
    public void shutDown() {
        node1 = null;
        node2 = null;
        list = null;
    }

    @Nested
    @DisplayName("Testing getters and setters methods")
    class Getters {
        @Test
        @DisplayName("first method test")
        public void testGetFirst() {
            Object obtainedValue = list.first();
            Object expectedValue = node1.getItem();
            assertEquals(list.first.getItem(), obtainedValue);
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("getLast method test")
        public void testGetLast() {
            Object obtainedValue = list.last();
            Object expectedValue = node2.getItem();
            assertEquals(list.last.getItem(), obtainedValue);
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("size method test")
        public void testGetSize() {
            int obtainedValue = list.size();
            int expectedValue =  list.size;
            assertEquals(expectedValue, obtainedValue);
        }
    }

    @Nested
    @DisplayName("Testing methods that involve adding and removing objects from the list")
    class Modifiers {
        @Nested
        @DisplayName("Adders tests")
        class Adders {
            @Test
            @DisplayName("prepend method test")
            public void prependTest() {
                Object expectedValue1 =  list.first.getItem();
                int expectedValue2 = list.size+1;

                list.prepend(3);

                Object obtainedValue1 = list.first.getNext().getItem();
                int obtainedValue2 = list.size();

                assertEquals(expectedValue1, obtainedValue1);
                assertEquals(expectedValue2, obtainedValue2);
            }

            @Test
            @DisplayName("append method test")
            public void appendTest() {
                Object expectedValue1 =  list.last.getItem();
                int expectedValue2 = list.size+1;

                list.append(3);

                Object obtainedValue1 = list.last.getPrevious().getItem();
                int obtainedValue2 = list.size();

                assertEquals(expectedValue1, obtainedValue1);
                assertEquals(expectedValue2, obtainedValue2);
            }
        }

        @Nested
        @DisplayName("Removers tests")
        class Removers {
            @Test
            @DisplayName("deleteFirst method test")
            public void deleteFirstTest() {
                Object obtainedValue1 = list.first.getNext();
                int expectedValue2 = list.size;
                list.deleteFirst();
                DequeNode expectedValue1 = list.first;
                int obtainedValue2 = list.size + 1;
                assertEquals(expectedValue1,obtainedValue1);
                assertEquals(expectedValue2, obtainedValue2);
            }

            @Test
            @DisplayName("deleteLast method test")
            public void deleteLastTest() {
                Object expectedValue1 = list.last.getPrevious();
                int expectedValue2 = list.size;
                list.deleteLast();
                DequeNode obtainedValue1 = list.last;
                int obtainedValue2 = list.size + 1;
                assertEquals(expectedValue1,obtainedValue1);
                assertEquals(expectedValue2, obtainedValue2);
            }
        }
    }

    @Nested
    @DisplayName("Introducing null argument throws DoubleEndedQueueException")
    public class NullArguments {

        @Test
        @DisplayName("Introducing null argument in append method")
        void nullItemAddedAppend() {
            assertThrows(DoubleEndedQueueException.class, () -> list.append(null));
        }

        @Test
        @DisplayName("Introducing null argument in prepend method")
        void nullItemAddedPrepend() {
            assertThrows(DoubleEndedQueueException.class, () -> list.prepend(null));
        }
    }
}
