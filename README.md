# codsoft_task-3

TASK 3
ATM INTERFACE
1.	Create a class to represent the ATM machine. 
2.	Design the user interface for the ATM, including options such as withdrawing, depositing, and checking the balance. 
3.	Implement methods for each option, such as withdraw(amount), deposit(amount), and checkBalance(). 
4.	Create a class to represent the user's bank account, which stores the account balance. 
5.	Connect the ATM class with the user's bank account class to access and modify the account balance. 
6.	Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals). 
7.	Display appropriate messages to the user based on their chosen options and the success or failure of their transactions. 

# Code:

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

# Instraction:

	1. Copy Full code.
	2. Save: Atminterface.java
	3. Compile: javac Atminterface.java
	4. Run: java Atminterface
