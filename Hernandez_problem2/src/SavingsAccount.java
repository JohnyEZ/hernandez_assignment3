public class SavingsAccount {
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    private static double annualInterestRate;

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    private double savingsBalance;

    public SavingsAccount(double balance) {
        savingsBalance = balance;
    }

    public void calculateMonthlyInterest() {
        savingsBalance += savingsBalance * annualInterestRate / 12;
    }
    public static void modifyInterestRate(double newIntr) {
        annualInterestRate = newIntr;
    }
}
