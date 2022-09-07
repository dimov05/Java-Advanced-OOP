package TestDrivenDevelopmentExercise;

import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transcationsById;

    public ChainblockImpl() {
        this.transcationsById = new HashMap<>();
    }

    public int getCount() {
        return this.transcationsById.size();
    }

    public void add(Transaction transaction) {
        if (!contains(transaction.getId())) {
            this.transcationsById.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transcationsById.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        this.transcationsById.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        transcationsById.remove(id);
    }

    public Transaction getById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        return transcationsById.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction t : transcationsById.values()) {
            if (t.getStatus() == status) {
                transactionList.add(t);
            }
        }
        if (transactionList.size() == 0) {
            throw new IllegalArgumentException();
        }
        transactionList
                .sort(Comparator.comparing(Transaction::getAmount).reversed());
        return transactionList;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status)
                .forEach(transactions::add);
        return transactions.stream()
                .map(Transaction::getFrom).collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status)
                .forEach(transactions::add);
        return transactions.stream()
                .map(Transaction::getTo).collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transcationsById.values()
                .stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transcationsById.values()) {
            if (transaction.getFrom().equals(sender)) {
                transactions.add(transaction);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transcationsById.values()) {
            if (transaction.getTo().equals(receiver)) {
                transactions.add(transaction);
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Comparator.comparing(Transaction::getId)))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transcationsById.values()) {
            if (transaction.getStatus() == status) {
                if (transaction.getAmount() <= amount) {
                    transactions.add(transaction);
                }
            }
        }
        if (transactions.size() == 0) {
            return transactions;
        }
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transcationsById.values()) {
            if (transaction.getFrom() == sender) {
                if (transaction.getAmount() >= amount) {
                    transactions.add(transaction);
                }
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transcationsById.values()) {
            if (transaction.getTo() == receiver) {
                if (transaction.getAmount() >= lo && transaction.getAmount() < hi) {
                    transactions.add(transaction);
                }
            }
        }
        if (transactions.size() == 0) {
            throw new IllegalArgumentException();
        }
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Comparator.comparing(Transaction::getId)))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        for (Transaction transaction : transcationsById.values()) {
            if (transaction.getAmount() >= lo && transaction.getAmount() <= hi) {
                transactions.add(transaction);
            }
        }
        if (transactions.size() == 0) {
            return transactions;
        }
        return transactions;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
