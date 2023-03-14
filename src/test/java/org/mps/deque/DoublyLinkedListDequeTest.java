package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test cases for class {@link DoublyLinkedListDeque}:
 * Introducing null argument in append and prepend
 * Testing methods than involve adding and removing objects from de list
 *  Testing removers with empty queue
 * Testing getters methods
 *  Testing getters methods with empty queue
 *
 * @author Jose Francisco Ruiz Sierras & Olivier Gabana Gómez
 */
class DoublyLinkedListDequeTest {

    DoublyLinkedListDeque<Integer> list;
    DequeNode<Integer> node1, node2;

    @BeforeEach
    void setUp() {
        node1 = new DequeNode<>(5, null, null);
        node2 = new DequeNode<>(7, null, null);

        node1.next = node2;
        node1.previous = null;
        node2.previous = node1;
        node2.next = null;

        list = new DoublyLinkedListDeque<>();
        list.size = 2;
        list.first = node1;
        list.last = node2;
    }

    @AfterEach
    void shutDown() {
        node1 = null;
        node2 = null;
        list = null;
    }

    @Nested
    @DisplayName("Testing getters methods")
    class Getters {
        @Test
        @DisplayName("first method test")
        void testGetFirst() {
            Object obtainedValue = list.first();
            Object expectedValue = node1.getItem();
            assertEquals(list.first.getItem(), obtainedValue);
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("getLast method test")
        void testGetLast() {
            Object obtainedValue = list.last();
            Object expectedValue = node2.getItem();
            assertEquals(list.last.getItem(), obtainedValue);
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("size method test")
        void testGetSize() {
            int obtainedValue = list.size();
            int expectedValue =  list.size;
            assertEquals(expectedValue, obtainedValue);
        }

        @Nested
        @DisplayName("Testing getters methods with an empty queue")
        class gettetsWithEmptyQueue {
            @Test
            @DisplayName("getFirst test with an empty queue should throw an exception")
            void testGetFirstEmptyQueue () {
                DoublyLinkedListDeque<Integer> listavacia = new DoublyLinkedListDeque<>();
                assertThrows(DoubleEndedQueueException.class, () -> listavacia.first());
            }
            @Test
            @DisplayName("getLast test with an empty queue")
            void testGetLastEmptyQueue () {
                DoublyLinkedListDeque<Integer> listavacia = new DoublyLinkedListDeque<>();
                assertThrows(DoubleEndedQueueException.class, () -> listavacia.last());
            }
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
            void prependTest() {
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
            void appendTest() {
                Object expectedValue1 =  list.last.getItem();
                int expectedValue2 = list.size+1;

                list.append(3);

                Object obtainedValue1 = list.last.getPrevious().getItem();
                int obtainedValue2 = list.size();

                assertEquals(expectedValue1, obtainedValue1);
                assertEquals(expectedValue2, obtainedValue2);
            }

            @Test
            @DisplayName("prepend method test with empty queue")
            void prependTestEmptyQueue(){
                DoublyLinkedListDeque<Integer> emptyList = new DoublyLinkedListDeque<>();
                emptyList.prepend(3);
                int expectedValue = 3;
                int obtainedValue = emptyList.first();
                assertEquals(expectedValue, obtainedValue);
            }

            @Test
            @DisplayName("append method test with empty queue")
            void appendTestEmptyQueue(){
                DoublyLinkedListDeque<Integer> emptyList = new DoublyLinkedListDeque<>();
                emptyList.append(3);
                int expectedValue = 3;
                int obtainedValue = emptyList.first();
                assertEquals(expectedValue, obtainedValue);
            }
        }

        @Nested
        @DisplayName("Removers tests")
        class Removers {
            @Test
            @DisplayName("deleteFirst method test")
            void deleteFirstTest() {
                Object obtainedValue1 = list.first.getNext();
                int expectedValue2 = list.size;
                list.deleteFirst();
                DequeNode<Integer> expectedValue1 = list.first;
                int obtainedValue2 = list.size + 1;
                assertEquals(expectedValue1,obtainedValue1);
                assertEquals(expectedValue2, obtainedValue2);
            }

            @Test
            @DisplayName("deleteLast method test")
            void deleteLastTest() {
                Object expectedValue1 = list.last.getPrevious();
                int expectedValue2 = list.size;
                list.deleteLast();
                DequeNode<Integer> obtainedValue1 = list.last;
                int obtainedValue2 = list.size + 1;
                assertEquals(expectedValue1,obtainedValue1);
                assertEquals(expectedValue2, obtainedValue2);
            }

            @Nested
            @DisplayName("Removers tests with just one element in the queue")
            class RemoversWithOneElementInTheQueue{
                @Test
                @DisplayName("deleteFirst method test with just one element in the queue")
                void deleteFirstEmptyQueueTest(){
                    list.deleteFirst();
                    list.deleteFirst();
                    int expectedValue = 0;
                    int obtainedValue = list.size();
                    assertEquals(expectedValue, obtainedValue);
                }

                @Test
                @DisplayName("deleteLast method test with just one element in the queue")
                void deleteLastEmptyQueueTest(){
                    list.deleteLast();
                    list.deleteLast();
                    int expectedValue = 0;
                    int obtainedValue = list.size();
                    assertEquals(expectedValue, obtainedValue);
                }
            }

            @Nested
            @DisplayName("Removers tests with an empty queue")
            class RemoversWithEmptyQueue{
                @Test
                @DisplayName("deleteFirst method test with empty queue")
                void deleteFirstEmptyQueueTest(){
                    DoublyLinkedListDeque<Integer> listavacia = new DoublyLinkedListDeque<>();
                    assertThrows(DoubleEndedQueueException.class, () -> listavacia.deleteFirst());
                }

                @Test
                @DisplayName("deleteLast method test with empty queue")
                void deleteLastEmptyQueueTest(){
                    DoublyLinkedListDeque<Integer> listavacia = new DoublyLinkedListDeque<>();
                    assertThrows(DoubleEndedQueueException.class, () -> listavacia.deleteLast());
                }
            }
        }
    }

    @Nested
    @DisplayName("Introducing null argument throws DoubleEndedQueueException")
    class NullArguments {

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



    // PRUEBAS PARA LA SEGUNDA SESIÓN
    @Nested
    @DisplayName("Testing get node from index method")
    class getMethodTests {
        @Test
        @DisplayName("get method test")
        void getTest() {
            Object expectedValue = node1.getItem();
            Object obtainedValue = list.get(0);
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("get method test with index out of bounds")
        void getTestOutOfBounds() {
            assertThrows(DoubleEndedQueueException.class, () -> list.get(3));
        }

        @Test
        @DisplayName("get method test with negative index")
        void getTestNegativeIndex() {
            assertThrows(DoubleEndedQueueException.class, () -> list.get(-1));
        }
    }

    @Nested
    @DisplayName("Testing contains method")
    class containsMethodTests {
        @Test
        @DisplayName("contains method test")
        void containsTest() {
            boolean expectedValue = true;
            boolean obtainedValue = list.contains(1);
            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("contains method test with element not in the queue")
        void containsTestElementNotInQueue() {
            boolean expectedValue = false;
            boolean obtainedValue = list.contains(3);
            assertEquals(expectedValue, obtainedValue);
        }
    }

    @Nested
    @DisplayName("Testing remove method")
    class removeMethodTests {
        @Test
        @DisplayName("remove method test")
        void removeTest() {
            Object expectedValue1 = node2.getItem();
            int expectedValue2 = list.size-1;
            list.remove(1);
            Object obtainedValue1 = list.get(1);
            int obtainedValue2 = list.size();
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
        }

        @Test
        @DisplayName("remove method test with index out of bounds")
        void removeTestOutOfBounds() {
            assertThrows(DoubleEndedQueueException.class, () -> list.remove(3));
        }

        @Test
        @DisplayName("remove method test with negative index")
        void removeTestNegativeIndex() {
            assertThrows(DoubleEndedQueueException.class, () -> list.remove(-1));
        }
    }

    @Nested
    @DisplayName("Testing sort method")
    class sortMethodTests {
        @Test
        @DisplayName("sort method test with reverse order")
        void sortTestReverseOrder() {
            DoublyLinkedListDeque<Integer> list = new DoublyLinkedListDeque<>();
            list.append(3);
            list.append(2);
            list.append(1);
            list.sort(Integer::compareTo);
            int expectedValue1 = 1;
            int expectedValue2 = 2;
            int expectedValue3 = 3;
            int obtainedValue1 = list.get(0);
            int obtainedValue2 = list.get(1);
            int obtainedValue3 = list.get(2);
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
            assertEquals(expectedValue3, obtainedValue3);
        }

        @Test
        @DisplayName("sort method test with reverse order")
        void sortTestMixedOrder() {
            DoublyLinkedListDeque<Integer> list = new DoublyLinkedListDeque<>();
            list.append(3);
            list.append(2);
            list.append(1);
            list.sort(Integer::compareTo);
            int expectedValue1 = 1;
            int expectedValue2 = 2;
            int expectedValue3 = 3;
            int obtainedValue1 = list.get(0);
            int obtainedValue2 = list.get(1);
            int obtainedValue3 = list.get(2);
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
            assertEquals(expectedValue3, obtainedValue3);
        }

        @Test
        @DisplayName("sort method test with reverse order")
        void sortTestOrdered() {
            DoublyLinkedListDeque<Integer> list = new DoublyLinkedListDeque<>();
            list.append(3);
            list.append(2);
            list.append(1);
            list.sort(Integer::compareTo);
            int expectedValue1 = 1;
            int expectedValue2 = 2;
            int expectedValue3 = 3;
            int obtainedValue1 = list.get(0);
            int obtainedValue2 = list.get(1);
            int obtainedValue3 = list.get(2);
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
            assertEquals(expectedValue3, obtainedValue3);
        }
    }

}
