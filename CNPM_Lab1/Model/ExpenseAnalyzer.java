package Model;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseAnalyzer extends BaseAnalyzer {
    public ExpenseAnalyzer(String filePath) {
        super(filePath);
    }

    public List<Transaction> getTopExpenses() {
        return transactions.stream()
                .filter(Transaction::isExpense)
                .sorted(Comparator.comparingDouble(t -> t.amount))
                .limit(10)
                .collect(Collectors.toList());
    }
}
