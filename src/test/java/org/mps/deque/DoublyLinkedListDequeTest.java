package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for class {@link DoublyLinkedListDeque}:
 *
 *
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
            @DisplayName("getLast test with an empty queue should throw an exception")
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
                @DisplayName("deleteFirst method test with empty queue should throw an exception")
                void deleteFirstEmptyQueueTest(){
                    DoublyLinkedListDeque<Integer> listavacia = new DoublyLinkedListDeque<>();
                    assertThrows(DoubleEndedQueueException.class, () -> listavacia.deleteFirst());
                }

                @Test
                @DisplayName("deleteLast method test with empty queue should throw an exception")
                void deleteLastEmptyQueueTest(){
                    DoublyLinkedListDeque<Integer> listavacia = new DoublyLinkedListDeque<>();
                    assertThrows(DoubleEndedQueueException.class, () -> listavacia.deleteLast());
                }
            }
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
            Object expectedValue2 = node2.getItem();
            Object obtainedValue2 = list.get(1);

            assertEquals(expectedValue, obtainedValue);
            assertEquals(expectedValue2, obtainedValue2);
        }

        @Test
        @DisplayName("get method test with index out of bounds should throw an exception")
        void getTestOutOfBounds() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        }

        @Test
        @DisplayName("get method test with negative index should throw an exception")
        void getTestNegativeIndex() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        }

        @Test
        @DisplayName("get method test with empty queue should throw an exception")
        void getTestWithEmptyQueue(){
            DoublyLinkedListDeque<Integer> newList = new DoublyLinkedListDeque<>();
            assertThrows(IndexOutOfBoundsException.class, () -> newList.get(0));
        }
    }

    @Nested
    @DisplayName("Testing contains method")
    class containsMethodTests {
        @Test
        @DisplayName("contains method test with element in the queue")
        void containsTest() {
            boolean expectedValue = true;
            boolean obtainedValue = list.contains(5);
            boolean obtainedValue2 = list.contains(7);
            assertEquals(expectedValue, obtainedValue);
            assertEquals(expectedValue, obtainedValue2);
        }

        @Test
        @DisplayName("contains method test with element not in the queue")
        void containsTestWithElementNotInQueue() {
            boolean expectedValue = false;
            boolean obtainedValue = list.contains(3);
            assertEquals(expectedValue, obtainedValue);
        }
        @Test
        @DisplayName("contains method test with empty queue")
        void containsTestWithEmptyQueue() {
            DoublyLinkedListDeque<Integer> newList = new DoublyLinkedListDeque<>();
            boolean expectedValue = false;
            boolean obtainedValue = newList.contains(1);
            assertEquals(expectedValue, obtainedValue);
        }
    }

    @Nested
    @DisplayName("Testing remove method")
    class removeMethodTests {
        @Test
        @DisplayName("removing the first item in the queue with remove method")
        void removeFirstTest() {
            Object expectedValue1 = node2.getItem();
            int expectedValue2 = list.size-1;
            list.remove(5);
            Object obtainedValue1 = list.get(0);
            int obtainedValue2 = list.size();
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
        }

        @Test
        @DisplayName("removing the last item in the queue with remove method")
        void removeLastTest() {
            Object expectedValue1 = node1.getItem();
            int expectedValue2 = list.size-1;
            list.remove(7);
            Object obtainedValue1 = list.get(0);
            int obtainedValue2 = list.size();
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
        }

        @Test
        @DisplayName("removing the middle item in the queue with remove method")
        void removeMiddleTest() {
            list.append(4);
            Object expectedValue1 = node1.getItem();
            Object expectedValue3 = list.last;
            int expectedValue2 = list.size-1;
            list.remove(7);
            Object obtainedValue1 = list.get(0);
            int obtainedValue2 = list.size();
            Object obtainedValue3 = list.get(1);
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
        }

        @Test
        @DisplayName("removing all items in the queue with remove method")
        void removeAllTest() {
            int expectedValue3 = list.size-2;
            list.remove(5);
            list.remove(7);
            Object obtainedValue1 = list.first;
            Object obtainedValue2 = list.last;
            int obtainedValue3 = list.size();

            assertNull(obtainedValue1);
            assertNull(obtainedValue2);
            assertEquals(expectedValue3, obtainedValue3);
        }

        @Test
        @DisplayName("remove method test with an element not contained in the queue")
        void removeTestWithElementNotInQueue() {
            DoublyLinkedListDeque<Integer> expectedValue = new DoublyLinkedListDeque<>();

            DequeNode <Integer> n1 = new DequeNode<>(5, null, null);
            DequeNode <Integer> n2 = new DequeNode<>(7, null, null);

            n1.next = n2;
            n1.previous = null;
            n2.previous = n1;
            n2.next = null;

            expectedValue.size = 2;
            expectedValue.first = n1;
            expectedValue.last = n2;

            DoublyLinkedListDeque<Integer> obtainedValue = list;

            obtainedValue.remove(2);
            obtainedValue.remove(1);

            assertEquals(expectedValue.first(),obtainedValue.first());
            assertEquals(expectedValue.last(),obtainedValue.last());
        }
    }

    @Nested
    @DisplayName("Testing sort method")
    class sortMethodTests {
        @Test
        @DisplayName("sort method test with reverse ordered queue")
        void sortTestReverseOrder() {
            DoublyLinkedListDeque<Integer> list = new DoublyLinkedListDeque<>();
            list.append(15);
            list.append(12);
            list.append(5);
            list.append(4);
            list.append(3);
            list.append(2);
            list.append(1);
            list.sort(Integer::compareTo);
            int expectedValue1 = 1;
            int expectedValue2 = 2;
            int expectedValue3 = 3;
            int expectedValue4 = 4;
            int expectedValue5 = 5;
            int expectedValue6 = 12;
            int expectedValue7 = 15;
            int obtainedValue1 = list.get(0);
            int obtainedValue2 = list.get(1);
            int obtainedValue3 = list.get(2);
            int obtainedValue4 = list.get(3);
            int obtainedValue5 = list.get(4);
            int obtainedValue6 = list.get(5);
            int obtainedValue7 = list.get(6);
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
            assertEquals(expectedValue3, obtainedValue3);
            assertEquals(expectedValue4, obtainedValue4);
            assertEquals(expectedValue5, obtainedValue5);
            assertEquals(expectedValue6, obtainedValue6);
            assertEquals(expectedValue7, obtainedValue7);

        }

        @Test
        @DisplayName("sort method test with mixed queue")
        void sortTestMixedOrder() {
            DoublyLinkedListDeque<Integer> list = new DoublyLinkedListDeque<>();
            list.append(26);
            list.append(5);
            list.append(4);
            list.append(66);
            list.append(72);
            list.append(24);
            list.append(1120);
            list.sort(Integer::compareTo);
            int expectedValue1 = 4;
            int expectedValue2 = 5;
            int expectedValue3 = 24;
            int expectedValue4 = 26;
            int expectedValue5 = 66;
            int expectedValue6 = 72;
            int expectedValue7 = 1120;
            int obtainedValue1 = list.get(0);
            int obtainedValue2 = list.get(1);
            int obtainedValue3 = list.get(2);
            int obtainedValue4 = list.get(3);
            int obtainedValue5 = list.get(4);
            int obtainedValue6 = list.get(5);
            int obtainedValue7 = list.get(6);
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
            assertEquals(expectedValue3, obtainedValue3);
            assertEquals(expectedValue4, obtainedValue4);
            assertEquals(expectedValue5, obtainedValue5);
            assertEquals(expectedValue6, obtainedValue6);
            assertEquals(expectedValue7, obtainedValue7);
        }

        @Test
        @DisplayName("sort method test with ordered queue")
        void sortTestOrdered() {
            DoublyLinkedListDeque<Integer> list = new DoublyLinkedListDeque<>();
            list.append(2);
            list.append(4);
            list.append(5);
            list.append(6);
            list.append(7);
            list.append(24);
            list.append(1120);
            list.sort(Integer::compareTo);
            int expectedValue1 = 2;
            int expectedValue2 = 4;
            int expectedValue3 = 5;
            int expectedValue4 = 6;
            int expectedValue5 = 7;
            int expectedValue6 = 24;
            int expectedValue7 = 1120;
            int obtainedValue1 = list.get(0);
            int obtainedValue2 = list.get(1);
            int obtainedValue3 = list.get(2);
            int obtainedValue4 = list.get(3);
            int obtainedValue5 = list.get(4);
            int obtainedValue6 = list.get(5);
            int obtainedValue7 = list.get(6);
            assertEquals(expectedValue1, obtainedValue1);
            assertEquals(expectedValue2, obtainedValue2);
            assertEquals(expectedValue3, obtainedValue3);
            assertEquals(expectedValue4, obtainedValue4);
            assertEquals(expectedValue5, obtainedValue5);
            assertEquals(expectedValue6, obtainedValue6);
            assertEquals(expectedValue7, obtainedValue7);
        }
    }

}
