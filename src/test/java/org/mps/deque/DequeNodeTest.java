package org.mps.deque;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.JRE.JAVA_21;
import static org.junit.jupiter.api.condition.JRE.JAVA_8;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Tests for class{@link DequeNode}
 *
 * @author Jose Fco Ruiz & Olivier Gabana
 */



public class DequeNodeTest {

    DequeNode node1,node2,node3;

    @BeforeEach
    void setup () {
        node1 = new DequeNode(5,null,null);
        node2 = new DequeNode(7,null,null);
        node3 = new DequeNode(1,null,null);
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
        public void testGetItem () {
            assertEquals(node1.getItem(),5);
            assertEquals(node2.getItem(),7);
            assertEquals(node3.getItem(),1);
        }

        @ParameterizedTest(name = "Testing value {0}")
        @DisplayName("setItem method test")
        @CsvSource({"-1","0","1","2","3","32000"})
        public void testSetItem (int value) {

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

                DequeNode prueba1 = node1.getPrevious();
                DequeNode prueba2 = node2.getPrevious();
                DequeNode prueba3 = node3.getPrevious();

                assertEquals(prueba1,null);
                assertEquals(prueba2,node1);
                assertEquals(prueba3,node2);

            }

            @Test
            @DisplayName("setPrevious method test")
            void testSetPrevious () {

                node1.setPrevious(node3);

                assertEquals(node1.getPrevious(),node3);

            }


        }

        //Otro Nested, con el de arriba en un pack mas grande
        @Nested
        @DisplayName("Testing methods related to next node")
        class Next {
            @DisplayName("")
            @Test
            void testGetNext () {

                node1.setNext(node2);

                assertEquals(node1.getNext(),node2);

            }
            @Test
            @DisplayName("test Set Next")
            void testSetNext () {

                node3.setNext(node2);

                assertEquals(node3.getNext(),node2);
            }
        }

    }




    @Nested
    @DisplayName("Tests posiciones booleanos")
    class booleanos {
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
            assertFalse(node1.isNotATerminalNode());
            assertTrue(node2.isNotATerminalNode());
            assertFalse(node3.isNotATerminalNode());

        }
    }



}
