package TestDrivenDevelopmentExercise;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainBlockImplTests {
    private Chainblock chainblock;
    private Transaction transaction;
    private List<Transaction> transactionList;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "From", "To", 12.20);
        createTransaction();
    }

    @Test
    public void testContainsByIdReturnCorrectValue() {
        assertFalse(chainblock.contains(transaction.getId()));

        chainblock.add(transaction);
        assertTrue(chainblock.contains(transaction.getId()));
    }

    @Test
    public void testAddHasToAddTransactionToChainBlock() {
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testAddHasToAddNotDuplicateTransactions() {
        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());

        chainblock.add(transaction);
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testChangeTransactionStatusForChangingStatusOfTransaction() {
        chainblock.add(transaction);
        chainblock.changeTransactionStatus(transaction.getId(), TransactionStatus.FAILED);

        assertEquals(TransactionStatus.FAILED, chainblock.getById(transaction.getId()).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusForNonExistingStatus() {
        chainblock.changeTransactionStatus(transaction.getId(), TransactionStatus.FAILED);
    }

    @Test
    public void testRemoveTransactionByIdRemovesCorrectTransaction() {
        chainblock.add(transaction);
        chainblock.removeTransactionById(transaction.getId());
        assertFalse(chainblock.contains(transaction.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowsExceptionWhenNoSuchTransaction() {
        chainblock.removeTransactionById(transaction.getId());
    }

    @Test
    public void testGetIdMethodForReturningTheTransactionByGivenId() {
        chainblock.add(transaction);
        chainblock.add(new TransactionImpl(2, TransactionStatus.FAILED, "From2", "To2", 13.20));
        Transaction foundTransaction = chainblock.getById(transaction.getId());
        assertEquals(transaction, foundTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetIdMethodWhenNoSuchTransactionExists() {
        chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusWhenNoSuchTransaction() {
        fillChainblock();
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatusReturnCorrectTransaction() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (Transaction t : actual) {
            assertEquals(TransactionStatus.SUCCESSFUL, t.getStatus());
        }
    }

    @Test
    public void testGetByTransactionReturnCorrectTransactionSortedByAmountDescending() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAllSendersWithTransactionStatusThrowExceptionWhenNoSendersExistWithTheStatus() {
        fillChainblock();
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testAllSendersWithTransactionStatusReturnsCorrectSendersForTheStatus() {
        fillChainblock();
        List<String> expected = transactionList.stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .map(Transaction::getFrom)
                .collect(Collectors.toList());
        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(senders);
        List<String> actual = new ArrayList<>();
        senders.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusThrowExceptionWhenNoSendersExistWithTheStatus() {
        fillChainblock();
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusReturnsCorrectSendersForTheStatus() {
        fillChainblock();
        List<String> expected = transactionList.stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .map(Transaction::getTo)
                .collect(Collectors.toList());
        Iterable<String> receivers = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(receivers);
        List<String> actual = new ArrayList<>();
        receivers.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdReturnsCorrectResultInCorrectOrder() {
        fillChainblock();
        Comparator<Transaction> compareByAmountDescending = Comparator.comparing(Transaction::getAmount).reversed();
        Comparator<Transaction> comparatorById = Comparator.comparing(Transaction::getId);
        List<Transaction> expected = transactionList.stream()
                .sorted(compareByAmountDescending.thenComparing(comparatorById))
                .collect(Collectors.toList());
        Iterable<Transaction> actual = chainblock.getAllOrderedByAmountDescendingThenById();
        assertNotNull(actual);
        List<Transaction> actualList = new ArrayList<>();
        actual.forEach(actualList::add);
        assertEquals(expected, actualList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedHasToThrowIfSenderNotPresent() {
        fillChainblock();
        chainblock.getBySenderOrderedByAmountDescending("Goshko");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingReturnTrueResult() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount))
                .filter(t -> t.getFrom().equals("From2"))
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getBySenderOrderedByAmountDescending("From2");
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected.size(), actual.size());
        double startAmount = 10.80;
        for (Transaction t : actual) {
            assertEquals("From2", t.getFrom());
            assertEquals(startAmount - 0.10, t.getAmount(), 0.01);
            startAmount -= 0.10;
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedHasToThrowIfReceiverNotPresent() {
        fillChainblock();
        chainblock.getByReceiverOrderedByAmountThenById("Goshko");
    }

    @Test
    public void testGetByReceiverOrderedByAmountDescendingThenByIdSortedReturnTrueResult() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getTo().equals("To2"))
                .sorted(Comparator.comparing(Transaction::getAmount).thenComparing(Comparator.comparing(Transaction::getId)))
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getByReceiverOrderedByAmountThenById("To2");
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected.size(), actual.size());
        double startAmount = 10.80;
        for (Transaction t : actual) {
            assertEquals("To2", t.getTo());
            assertEquals(startAmount - 0.10, t.getAmount(), 0.01);
            startAmount -= 0.10;
        }
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountByAmountDescendingReturnsCorrectCollection() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .filter(t -> t.getAmount() <= 10.8)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 10.8);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        double lastTransactionAmount = 10.8 + 10;
        for (Transaction t : result) {
            assertEquals(t.getStatus(), TransactionStatus.SUCCESSFUL);
            assertTrue(t.getAmount() <= 10.8);
            assertTrue(t.getAmount() <= lastTransactionAmount);
            lastTransactionAmount = t.getAmount();
        }
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountForNoSuchTransaction() {
        fillChainblock();
        Iterable<Transaction> actual = chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.UNAUTHORIZED, 0.1);
        int lengthOfActual = 0;
        for (Transaction t : actual) {
            lengthOfActual++;
        }
        assertEquals(0, lengthOfActual);
    }

    @Test
    public void testGetBySenderAndMinimumAmountByAmountDescendingReturnsCorrectCollection() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getFrom() == "From2")
                .filter(t -> t.getAmount() >= 1)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getBySenderAndMinimumAmountDescending("From2", 1);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        double lastTransactionAmount = 999999999;
        for (Transaction t : result) {
            assertEquals(t.getFrom(), "From2");
            assertTrue(t.getAmount() >= 1);
            assertTrue(t.getAmount() <= lastTransactionAmount);
            lastTransactionAmount = t.getAmount();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountThrowsExceptionForNoSuchTransaction() {
        fillChainblock();
        Iterable<Transaction> actual = chainblock.getBySenderAndMinimumAmountDescending("no_such_sender", 999);
    }

    @Test
    public void testGetByReceiverAndAmountRangeSortedByAmountDescendingThenByIdReturnsCorrectCollection() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getTo() == "To2")
                .filter(t -> t.getAmount() >= 10 && t.getAmount() < 11)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getByReceiverAndAmountRange("To2", 10, 11);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        double lastTransactionAmount = 999999999;
        for (Transaction t : result) {
            assertEquals(t.getTo(), "To2");
            assertTrue(t.getAmount() >= 10);
            assertTrue(t.getAmount() < 11);
            assertTrue(t.getAmount() <= lastTransactionAmount);
            lastTransactionAmount = t.getAmount();
        }
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeThrowsExceptionForNoSuchTransaction() {
        fillChainblock();
        Iterable<Transaction> actual = chainblock.getByReceiverAndAmountRange("no_such_receiver", 1, 2);
    }

    @Test
    public void testGetAllInAmountRangeInInsertionOrderReturnsCorrectCollection() {
        fillChainblock();
        List<Transaction> expected = this.transactionList.stream()
                .filter(t -> t.getAmount() >= 10.6 && t.getAmount() <= 10.8)
                .collect(Collectors.toList());
        Iterable<Transaction> result = chainblock.getAllInAmountRange(10.6, 10.8);
        assertNotNull(result);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (Transaction t : result) {
            assertTrue(t.getAmount() <= 10.8);
            assertTrue(t.getAmount() >= 10.6);
        }
    }

    @Test
    public void testGetAllInAmountRangeForNoSuchTransaction() {
        fillChainblock();
        Iterable<Transaction> actual = chainblock.getAllInAmountRange(100, 101);
        int lengthOfActual = 0;
        for (Transaction t : actual) {
            lengthOfActual++;
        }
        assertEquals(0, lengthOfActual);

    }

    private void createTransaction() {
        this.transactionList = new ArrayList<>();
        Transaction t1 = new TransactionImpl(1, TransactionStatus.FAILED, "From1", "To1", 10.50);
        Transaction t2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "From2", "To2", 10.60);
        Transaction t3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "From2", "To2", 10.70);
        Transaction t4 = new TransactionImpl(4, TransactionStatus.UNAUTHORIZED, "From4", "To4", 10.80);
        Transaction t5 = new TransactionImpl(5, TransactionStatus.FAILED, "From5", "To5", 10.90);
        transactionList.add(t1);
        transactionList.add(t2);
        transactionList.add(t3);
        transactionList.add(t4);
        transactionList.add(t5);
    }

    private void fillChainblock() {
        for (Transaction t : transactionList) {
            chainblock.add(t);
        }
    }


}