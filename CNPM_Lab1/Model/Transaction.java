package Model;

public class Transaction {
    public String date;
    public double amount;
    public String category;

    public Transaction(String date, double amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public String getMonthYear() {
        return date.substring(3, 10);
    }

    public String getYear() {
        return date.substring(6, 10);
    }

    public boolean isExpense() {
        return amount < 0;
    }
}
