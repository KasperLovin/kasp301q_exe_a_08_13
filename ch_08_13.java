import java.util.Scanner;

public class ch_08_13
{
    /*
    Add a transfer method to the BankAccount class from the previous exercises. Your method should move money
    from the current bank account to another account. The method accepts two parameters: a second BankAccount to
    accept the money, and a real number for the amount of money to transfer. There is a $5.00 fee for transferring
    money, so this much must be deducted from the current account’s balance before any transfer. The method should
    modify the two BankAccount objects such that “this” current object has its balance decreased by the given amount
    plus the $5 fee, and the other account's balance is increased by the given amount. If this account object does
    not have enough money to make the full transfer, transfer whatever money is left after the $5 fee is deducted.
    If this account
    has under $5 or the amount is 0 or less, no transfer should occur and neither account's state should be modified.
    The following are some example calls to the method:
    */

    public static void main(String[] args)
    {
        BankAccount ba = new BankAccount("Kurt", 100,1.20);
        BankAccount ba1 = new BankAccount("Lukas", 10,9.20);
        ba.withdraw(0);
    }
    public static class BankAccount {
        Scanner sc = new Scanner(System.in);
        String name;
        double balance = 100;
        double transactionFee = 0.00;

        public void transfer (BankAccount acc,double amount) {
            System.out.println("Enter the amount you want to transfer " + acc.name + " :");
            amount = sc.nextDouble();
            transactionFee = 5.00;
            if (balance > 5) {
                balance = balance - transactionFee;
            }
            else {
                System.out.println("not enough money on your account.... sry fam");
                System.exit(1);
            }

            if (balance < amount) {
                balance = balance - amount;

                while (balance < 0) {
                    balance ++;
                    amount --;
                }
                acc.balance = acc.balance + amount;
            }
            else if (balance > amount) {
                balance = balance - amount;
                acc.balance = acc.balance + amount;
            }
        }

        public void  deposit(double amount) {
            balance = balance + amount;
        }


        public void withdraw(double amount){
            System.out.println("How much do you want to withdraw?");
            amount = sc.nextDouble();
            System.out.println("Enter transaction fee");
            transactionFee = sc.nextDouble();
            balance = balance - amount - transactionFee;

            if (balance < 0){
                System.out.println("Your account cant go below 0");
                balance = balance + amount + transactionFee;

            }
            else
                System.out.println("you have withdrawn: " + amount);
        }

        public BankAccount(String name, double balance, double transactionFee)
        {
            this.name = name;
            this.balance = balance;
            this.transactionFee = transactionFee;
        }
        public String toString() {
            return name + ", " + balance;
        }
    }
}
