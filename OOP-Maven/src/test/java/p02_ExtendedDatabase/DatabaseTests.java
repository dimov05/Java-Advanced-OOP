package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.management.OperatingSystemMXBean;

import static org.junit.Assert.assertEquals;

public class DatabaseTests {
    private Database database;
    private static final Person[] people = {
            new Person(1, "First"),
            new Person(2, "Second"),
            new Person(3, "Third"),
            new Person(4, "Fourth"),
    };

    @Before
    public void setupDatabase() throws OperationNotSupportedException {
        this.database = new Database(people);
    }

    @Test
    public void testConstructorIsCreatingValidObject() throws OperationNotSupportedException {
        assertEquals("Count of elements is incorrect", people.length, database.getElements().length, 0);
        Person[] databasePeople = database.getElements();
        for (int i = 0; i < databasePeople.length; i++) {
            assertEquals(people[i], databasePeople[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        Database database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionWhenLessThanOneElement() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        Database database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPassedElementsEqualsNull() throws OperationNotSupportedException {
        p01_Database.Database database = new p01_Database.Database(0, 3, 5);
        database.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldNotAddNullPerson() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldPersonAtLastPosition() throws OperationNotSupportedException {
        database.add(new Person(5, "Fifth"));
        assertEquals(5, database.getElements().length, 0);
        assertEquals(5, database.getElements()[4].getId(), 0);
        assertEquals("Fifth", database.getElements()[4].getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldThrowExceptionOnEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < people.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveShouldRemoveLastPersonAdded() throws OperationNotSupportedException {
        database.remove();
        Database databaseTest = new Database(database.getElements());
        assertEquals(people.length - 1, databaseTest.getElements().length, 0);
        assertEquals("Third", databaseTest.getElements()[databaseTest.getElements().length - 1].getUsername());
        for (int i = 0; i < databaseTest.getElements().length; i++) {
            assertEquals(databaseTest.getElements()[i], people[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameAndNoPresentUsername() throws OperationNotSupportedException {
        database.findByUsername("Kosta");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullParameter() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    //TODO: Test method findByUsername if names are case sensitive
    @Test
    public void testFindByUsernameWithCaseSensitiveName() throws OperationNotSupportedException {
        database.findByUsername("Second");
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdAndNoPresentUser() throws OperationNotSupportedException {
        database.findById(10);
    }
    @Test
    public void testFindByIdForCaseSensitiveId() throws OperationNotSupportedException {
        database.findById(Long.parseLong("2"));
    }
}