package Model;

import java.util.Map;
import java.util.stream.Collectors;

public class CategoryAnalyzer extends BaseAnalyzer {
    public CategoryAnalyzer(String filePath) {
        super(filePath);
    }

    public String getHighestSpendingCategory() {
        Map<String, Double> categorySpending = transactions.stream()
                .filter(Transaction::isExpense)
                .collect(Collectors.groupingBy(
                        t -> t.category,
                        Collectors.summingDouble(t -> Math.abs(t.amount))
                ));

        return categorySpending.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Khong tim thay danh muc chi tieu");
    }
}
