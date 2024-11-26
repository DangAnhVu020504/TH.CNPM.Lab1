package View;

import Model.Transaction;

import java.util.List;

public class ConsoleView {
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayTransactions(List<Transaction> transactions) {
        transactions.forEach(t -> 
            System.out.println(t.date + " : " + t.amount + " - " + t.category)
        );
    }
}
