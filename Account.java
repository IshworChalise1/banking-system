package part2;

public class Account extends Customer {
    private int balance;
    private int accountNumber;

    public Account(String FName, String LName, int accNum, int accBal) {
    	setFirstName(FName);
    	setLastName(LName);
        this.balance = accBal;
        this.accountNumber = accNum;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getAccountNum() {
        return this.accountNumber;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }
}
