package Model;

import java.util.Map;
import java.util.stream.Collectors;

public class TransactionCountAnalyzer extends BaseAnalyzer {
    public TransactionCountAnalyzer(String filePath) {
        super(filePath);
    }

    public Map<String, Long> countTransactionsByMonth(String year) {
        return transactions.stream()
                .filter(t -> t.getYear().equals(year))
                .collect(Collectors.groupingBy(Transaction::getMonthYear, Collectors.counting()));
    }
}
