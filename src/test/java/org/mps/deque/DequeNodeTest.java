package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests for class{@link DequeNode}
 *
 * @author Jose Fco Ruiz & Olivier Gabana
 */



class DequeNodeTest {

    DequeNode<Integer> node1,node2,node3;

    @BeforeEach
    void setup () {
        node1 = new DequeNode<>(5,null,null);
        node2 = new DequeNode<>(7,null,null);
        node3 = new DequeNode<>(1,null,null);
        //node1.setNext(node2);
        node1.next = node2;
        //node2.setPrevious(node1); node2.setNext(node3);
        node2.previous = node1;
        node2.next = node3;
        //node3.setPrevious(node2);
        node3.previous = node2;
    }

    @AfterEach
    void shutdown () {
        node1 = null;
        node2 = null;
        node3 = null;
    }

    @Nested
    @DisplayName("Testing getters and setters methods")
    class getterYSetter {

        @Test
        @DisplayName("getItem method test")
        void testGetItem () {
            assertEquals(node1.getItem(),5);
            assertEquals(node2.getItem(),7);
            assertEquals(node3.getItem(),1);
        }

        @ParameterizedTest(name = "Testing value {0}")
        @DisplayName("setItem method test")
        @CsvSource({"-1","0","1","2","3","32000"})
        void testSetItem (Integer value) {

            node1.setItem(value);

            Object obtainedValue = node1.getItem();
            assertEquals(value,(int)obtainedValue);

        }
    }


    @Nested
    @DisplayName("Testing setNext and setPrevious methods")
    class NextAndPreviousMethods {

        @Nested
        @DisplayName("Testing methods related to previous node")
        class Previous {

            @Test
            @DisplayName("getPrevious method tests")
            void testGetPrevious () {

                DequeNode<Integer> obtainedValue1 = node1.getPrevious();
                DequeNode<Integer> obtainedValue2 = node2.getPrevious();
                DequeNode<Integer> obtainedValue3 = node3.getPrevious();

                DequeNode<Integer> expectedValue1 = node1;
                DequeNode<Integer> expectedValue2 = node2;

                assertNull(obtainedValue1);
                assertEquals(expectedValue1,obtainedValue2);
                assertEquals(expectedValue2,obtainedValue3);

            }

            @Test
            @DisplayName("setPrevious method test")
            void testSetPrevious () {
                node1.setPrevious(node3);
                DequeNode<Integer> expectedValue = node3,obtainedValue = node1.getPrevious();
                assertEquals(expectedValue,obtainedValue);
            }

        }

        //Otro Nested, con el de arriba en un pack mas grande
        @Nested
        @DisplayName("Testing methods related to next node")
        class Next {
            @DisplayName("getNext method test")
            @Test
            void testGetNext () {
                DequeNode<Integer> obtainedValue1 = node1.getNext();
                DequeNode<Integer> obtainedValue2 = node2.getNext();
                DequeNode<Integer> obtainedValue3 = node3.getNext();

                DequeNode<Integer> expectedValue1 = node2,expectedValue2 = node3;

                assertEquals(expectedValue1,obtainedValue1);
                assertEquals(expectedValue2,obtainedValue2);
                assertNull(obtainedValue3);

            }
            @Test
            @DisplayName("setNext method test")
            void testSetNext () {

                node3.setNext(node2);

                DequeNode<Integer> expectedValue = node2,obtainedValue = node3.getNext();

                assertEquals(expectedValue,obtainedValue);
            }
        }

    }




    @Nested
    @DisplayName("Tests involving node positions")
    class Booleans {
        @Test
        @DisplayName("Testing isFirstNode method")
        void testIsFirstNode () {

            Boolean obtainedValue1 = node1.isFirstNode(), obtainedValue2 = node2.isFirstNode(), obtainedValue3 = node3.isFirstNode();

            assertTrue(obtainedValue1);
            assertFalse(obtainedValue2);
            assertFalse(obtainedValue3);
        }

        @Test
        @DisplayName("Testing isLastNode method")
        void testIsLastNode () {

            Boolean obtainedValue1 = node1.isLastNode(), obtainedValue2 = node2.isLastNode(), obtainedValue3 = node3.isLastNode();

            assertFalse(obtainedValue1);
            assertFalse(obtainedValue2);
            assertTrue(obtainedValue3);

        }

        @Test
        @DisplayName("Testing isNotATerminalNode method")
        void isNotTerminalNode () {

            Boolean obtainedValue1 = node1.isNotATerminalNode(), obtainedValue2 = node2.isNotATerminalNode(), obtainedValue3 = node3.isNotATerminalNode();
            
            assertFalse(obtainedValue1);
            assertTrue(obtainedValue2);
            assertFalse(obtainedValue3);

        }
    }


}
