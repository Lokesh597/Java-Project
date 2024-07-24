import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String date;
    private String description;
    private double amount;

    public Expense(String date, String description, double amount) {
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Description: " + description + ", Amount: " + amount;
    }
}

class ExpenseStorage {
    public static ArrayList<Expense> loadExpenses() {
        return new ArrayList<>();
    }

    public static void saveExpenses(ArrayList<Expense> expenses) {
        
    }
}

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = ExpenseStorage.loadExpenses();

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.next();
                    scanner.nextLine();  
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(date, desc, amount));
                    ExpenseStorage.saveExpenses(expenses);
                    break;
                case 2:
                    for (Expense e : expenses) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select from the menu.");
            }
        }
    }
}
