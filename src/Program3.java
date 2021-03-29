import javax.swing.plaf.synth.SynthTextAreaUI;

public class Program3 {

    public static void main(String[] args) {
        Account acct1 = new Account(150.00);
        System.out.println("Created account " + acct1.getAccountNumber() + " with $" + String.format("%.2f", acct1.getBalance()));
        Account acct2 = new Account(75.00);
        System.out.println("Created account " + acct2.getAccountNumber() + " with $" + String.format("%.2f", acct2.getBalance()));


        acct1.withdraw(100.00);

        System.out.println("Withdraw from account " + acct1.getAccountNumber() + " of $100");
        System.out.println("Account number =" + acct1.getAccountNumber() + " , balance= $" + String.format("%.2f",acct1.getBalance()) + " " + acct1.isOverdrawn());
        System.out.println("Account number =" + acct2.getAccountNumber() + ", balance= $" + String.format("%.2f",acct2.getBalance()) + " " + acct2.isOverdrawn());
        System.out.println("Total of accounts = $" + String.format("%2f",Account.getTotalAccounts()));

        System.out.println(Account.getTotalAccounts());
        acct1.withdraw(75.00);
        System.out.println(Account.getTotalAccounts());

        System.out.println("Withdraw from account " + acct1.getAccountNumber() + " of $75");
        System.out.println("Account number =" + acct1.getAccountNumber() + " , balance= $" + String.format("%.2f",acct1.getBalance()) + " " + acct1.isOverdrawn());
        System.out.println("Account number =" + acct2.getAccountNumber() + ", balance= $" + String.format("%.2f",acct2.getBalance()) + " " + acct2.isOverdrawn());
        System.out.println("Total of accounts = $" + String.format("%.2f",Account.getTotalAccounts()));



    }


}

class Account {

    // vars

    private int accountNumber = 1;
    private double balance;
    public static double totalBalances;
    public static int nextAccountNumber = 1;
    public final int OVERDRAFT_FEE = 20;


    // constructors
    Account () {
        if (nextAccountNumber == 1) {
            this.accountNumber = nextAccountNumber;
        }
        else {
            this.accountNumber = nextAccountNumber;
        }

        this.balance = 0;
        nextAccountNumber += 1;
    }

    Account(double cbalance) {
        if (nextAccountNumber == 1) {
            this.accountNumber = nextAccountNumber;
        }
        else {
            this.accountNumber = nextAccountNumber;
        }
        this.balance = cbalance;
        totalBalances += this.balance;
        nextAccountNumber += 1;
    }



    //setters
    public void deposit(double amount) {
        this.balance += amount;
        totalBalances += amount;
        this.accountNumber = nextAccountNumber;
    }

    public void withdraw(double amount) {
        if (this.balance < amount) {
            this.balance = this.balance - amount - OVERDRAFT_FEE;
            totalBalances += this.balance;
        }
        else{
            this.balance -= amount;
            totalBalances -= amount;
        }

    }


    // getters
    public double getBalance() {
        return this.balance;
    }

    public String isOverdrawn() {
        if (this.balance < 0) {
            return "Overdrawn";
        }
        return "Not Overdrawn";
    }

    static double getTotalAccounts() {
        return totalBalances;
    }

    public String getAccountNumber(){
        return String.format("%06d", this.accountNumber);
    }



}
