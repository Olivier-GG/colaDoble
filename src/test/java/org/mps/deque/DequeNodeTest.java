package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_21;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests for class{@link DequeNode}
 *
 * @author Jose Fco Ruiz & Olivier Gabana
 */



public class DequeNodeTest {

    DequeNode node1,node2,node3;

    @BeforeEach
    void setup () {
        node1 = new DequeNode(5,null,node2);
        node2 = new DequeNode(7,node1,node3);
        node3 = new DequeNode(1,node2,null);
    }


    @Test
    public void testSetGetItem () {

        node1.setItem(33);

        Object obtainedValue = node1.getItem();
        assertEquals(33,(int)obtainedValue);

    }


    @Nested
    @DisplayName("PreviousTests")
    class previous {

        @Test
        @DisplayName("Get")
        void testGetPrevious () {

            DequeNode prueba1 = node1.getPrevious();
            DequeNode prueba2 = node2.getPrevious();
            DequeNode prueba3 = node3.getPrevious();

            assertEquals(prueba1,null);
            assertEquals(prueba2,node1);
            assertEquals(prueba3,node2);

        }

        @Test
        @DisplayName("Set")
        void testSetPrevious () {

            node1.setPrevious(node3);

            assertEquals(node1.getPrevious(),node3);

        }

        @AfterEach
        void shutdown () {
            node1 = null;
            node2 = null;
            node3 = null;
        }
    }



    //Otro Nested, con el de arriba en un pack mas grande

    @Test
    void testGetNext () {

        assertEquals(node1.getNext(),node2);

    }
    @Test
    void testSetNext () {

        node3.setNext(node2);

        assertEquals(node3.getNext(),node2);
    }



    //Nested de los siguientes 3

    @Test
    void testIsFirstNode () {

        assertTrue(node1.isFirstNode());
        assertFalse(node2.isFirstNode());
        assertFalse(node3.isFirstNode());
    }

    @Test
    void testIsLastNode () {

        assertFalse(node1.isLastNode());
        assertFalse(node2.isLastNode());
        assertTrue(node3.isLastNode());

    }

    @Test
    void isNotTerminalNode () {

        node1.setNext(null);

        assertFalse(node1.isNotATerminalNode());
        assertTrue(node2.isNotATerminalNode());
        assertTrue(node3.isNotATerminalNode());

    }


}
