package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DatabaseTests {
    //TODO: Constructors testing
    @Test
    public void testConstructorIsCreatingValidObject() throws OperationNotSupportedException {
        Integer[] numbers = {5, 9, 12, 13, 14};
        Database database = new Database(numbers);

        assertEquals("Count of elements is incorrect", numbers.length, database.getElements().length, 0);
        Integer[] databaseNumbers = database.getElements();
        for (int i = 0; i < databaseNumbers.length; i++) {
            assertEquals(numbers[i], databaseNumbers[i], 0);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        Database database = new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenLessThanOneElement() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        Database database = new Database(numbers);
    }

    //TODO: Add method testing
    @Test(expected = OperationNotSupportedException.class)
    public void testPassedElementsEqualsNull() throws OperationNotSupportedException {
        Database database = new Database(0, 3, 5);
        database.add(null);
    }

    @Test
    public void testAddOperationAddingElementAtNextFreeCell() throws OperationNotSupportedException {
        Database database = new Database(3, 4, 5, 6, 7, 8);
        int element = 13;
        database.add(element);
        int indexOfAddedElement = database.getElements()[database.getElements().length - 1];
        assertEquals(element, indexOfAddedElement, 0);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemovingElementFromEmptyDatabase() throws OperationNotSupportedException {
        Database database = new Database();
        database.remove();
    }

    @Test
    public void testRemovingOnlyLastElementFromDatabase() throws OperationNotSupportedException {
        Database database = new Database(3, 4, 5, 6, 7, 8, 9);
        int lastElement = database.getElements()[database.getElements().length - 1];
        database.remove();
        assertNotEquals(lastElement, database.getElements()[database.getElements().length - 1], 0);
    }
    //TODO: Remove method testing
    //TODO: Return true data
}
