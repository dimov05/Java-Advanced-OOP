package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"first", "second", "third"};

    @Before
    public void setupListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(DATA);
    }

    //TODO: test constructor for null elements
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenNullElementsAreGiven() throws OperationNotSupportedException {
        ListIterator list = new ListIterator(null);
    }

    @Test
    public void testMoveInternalIndexToNextIndexInList() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());

    }

    @Test
    public void testHasNextReturnCorrectBoolean() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyList() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void testPrintReturnsCorrectElements() {
        int index = 0;
        while (listIterator.hasNext()) {
            assertEquals(DATA[index], listIterator.print());
            index++;
            listIterator.move();
        }
    }

}
