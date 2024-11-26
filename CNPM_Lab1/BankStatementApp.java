import Controller.BankStatementController;
import View.ConsoleView;

public class BankStatementApp {
    public static void main(String[] args) {
        String filePath = "bank_statements.csv";
        ConsoleView view = new ConsoleView();
        BankStatementController controller = new BankStatementController(view);

        
        controller.analyzeProfitLoss(filePath);
        controller.analyzeTransactionCount(filePath, "2017");
        controller.analyzeTopExpenses(filePath);
        controller.analyzeHighestSpendingCategory(filePath);
    }
}
