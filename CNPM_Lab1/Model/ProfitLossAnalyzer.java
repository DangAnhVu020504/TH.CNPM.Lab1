package Model;

public class ProfitLossAnalyzer extends BaseAnalyzer {
    public ProfitLossAnalyzer(String filePath) {
        super(filePath);
    }

    public String calculateProfitOrLoss() {
        double total = transactions.stream().mapToDouble(t -> t.amount).sum();
        return String.format("%.2f (%s)", total, total > 0 ? "LAI" : "LO");
    }
}
