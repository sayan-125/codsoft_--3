import java.util.Scanner;

class Bankaccount {
    private double Balance;

    public Bankaccount(double balance) 
    {
        this.Balance = balance;
    }
    public boolean withdraw(double amount) 
    {
        if (amount <= Balance) 
        {
            Balance -= amount;
            System.out.println("Withdrawal successful. Current account balance: " + Balance);
            return true;
        }
        else 
        {
            System.out.println("Insufficient balance. Withdrawal failed. Try again....");
            return false;
        }
    }
    public void deposit(double amount) 
    {
        Balance += amount;
        System.out.println("Deposit successful. Current account balance: " + Balance);
    }
    public double checkbalance() 
    {
        return Balance;
    }
}

class Atminterface {
    private Bankaccount Account;
    public Atminterface(Bankaccount account) {
        this.Account = account;
    }
    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
    }
    public void option(int option) {
        Scanner inputoption = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = inputoption.nextDouble();
                Account.withdraw(withdrawalAmount);
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = inputoption.nextDouble();
                Account.deposit(depositAmount);
                break;
            case 3:
                System.out.println("Your current balance is: " + Account.checkbalance());
                break;
            default:
                System.out.println("Invalid option. Please select correct option.");
        }
    }
    public static void main(String[] args) {
        Bankaccount userAccount = new Bankaccount(10000.0);
        Atminterface atm = new Atminterface(userAccount);
        Scanner input = new Scanner(System.in);
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            atm.option(choice);
        }
    }
}
