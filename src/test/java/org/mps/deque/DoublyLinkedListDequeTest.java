package org.mps.deque;

import org.junit.jupiter.api.*;

import java.util.Deque;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque list;
    DequeNode node1,node2;

    @BeforeEach
    public void setUp () {

        node1 = new DequeNode(5,null,null);
        node2 = new DequeNode(7,null,null);

        node1.next = node2;
        node2.previous = node1;
        node2.next = null;

        list = new DoublyLinkedListDeque();
        list.size = 2;
        list.first = node1;
        list.last = node2;

    }

    @AfterEach
    public void shutDown () {
        node1 = null;
        node2 = null;
        list = null;
    }


    @Nested
    @DisplayName("Test Getter values")
    class getters {
        @Test
        public void testGetFirst () {
            Object obtainedValue = list.first();

            assertEquals(obtainedValue,list.first.getItem());
            assertEquals(obtainedValue,node1.getItem());

        }

        @Test
        public void testGetLast () {
            Object obtainedValue = list.last();

            assertEquals(obtainedValue,list.last.getItem());
            assertEquals(obtainedValue,node2.getItem());

        }
        @Test
        public void testGetSize () {
            int obtainedValue = list.size();

            assertEquals(obtainedValue,list.size);

        }
    }

    @Nested
    @DisplayName("List Modifiers")
    class modifiers {
        @Nested
        @DisplayName("tests Adders methods")
        class adders {
            @Test
            public void prependTest () {

            }
            @Test
            public void appendTest () {

            }
        }

        @Nested
        @DisplayName("tests removers methods")
        class removers {
            @Test
            public void deleteFirstTest () {

            }
            @Test
            public void deleteLastTest () {

            }
        }
    }
    
    
    
}
