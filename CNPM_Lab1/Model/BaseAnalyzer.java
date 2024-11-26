package Model;

import java.io.*;
import java.util.*;

public abstract class BaseAnalyzer {
    protected List<Transaction> transactions;

    public BaseAnalyzer(String filePath) {
        this.transactions = loadTransactions(filePath);
    }

    private List<Transaction> loadTransactions(String filePath) {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String date = data[0];
                double amount = Double.parseDouble(data[1]);
                String category = data[2];
                transactions.add(new Transaction(date, amount, category));
            }
        } catch (IOException e) {
            System.err.println("Loi doc file: " + e.getMessage());
        }
        return transactions;
    }
}