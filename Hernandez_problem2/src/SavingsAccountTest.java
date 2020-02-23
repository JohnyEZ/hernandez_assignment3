public class  SavingsAccountTest {
    public static void main(String[] args) {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        SavingsAccount.modifyInterestRate(0.04);
        System.out.println("Months passed\tSaver 1 balance\t       Saver 2 balance");
        System.out.println("0\t        " + saver1.getSavingsBalance() + "\t" + saver2.getSavingsBalance());
        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.println((i + 1) + "\t        " + saver1.getSavingsBalance() + "\t" + saver2.getSavingsBalance());
        }
        SavingsAccount.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Saver1 balance: " + saver1.getSavingsBalance() + ", Saver2 balance: " + saver2.getSavingsBalance());
    }
}
