package Controller;

import Model.*;
import View.ConsoleView;
import java.util.List;
import java.util.Map;

public class BankStatementController {
    private final ConsoleView view;

    public BankStatementController(ConsoleView view) {
        this.view = view;
    }

    public void analyzeProfitLoss(String filePath) {
        ProfitLossAnalyzer analyzer = new ProfitLossAnalyzer(filePath);
        String result = analyzer.calculateProfitOrLoss();
        view.displayMessage("1. Tong loi nhuan va lo: " + result);
    }

    public void analyzeTransactionCount(String filePath, String year) {
        TransactionCountAnalyzer analyzer = new TransactionCountAnalyzer(filePath);
        Map<String, Long> transactionsByMonth = analyzer.countTransactionsByMonth(year);
        view.displayMessage("2. So lan giao dich cua tung thang trong 1 nam " + year + ":");
        transactionsByMonth.forEach((month, count) -> 
            view.displayMessage(month + ": " + count + " transactions")
        );
    }

    public void analyzeTopExpenses(String filePath) {
        ExpenseAnalyzer analyzer = new ExpenseAnalyzer(filePath);
        List<Transaction> topExpenses = analyzer.getTopExpenses();
        view.displayMessage("3. Top 10 chi tieu lon nhat:");
        view.displayTransactions(topExpenses);
    }

    public void analyzeHighestSpendingCategory(String filePath) {
        CategoryAnalyzer analyzer = new CategoryAnalyzer(filePath);
        String category = analyzer.getHighestSpendingCategory();
        view.displayMessage("4. Giao dich nhieu nhat: " + category);
    }
}
