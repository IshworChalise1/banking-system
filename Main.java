package part2;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\asus\\Desktop\\oop_project\\Account.csv"; 

        LinkedList<Account> accounts = new LinkedList<>();

        ReadAccounts readAccounts = new ReadAccounts(filePath);

        LinkedList<String> firstNames = readAccounts.getFirstNames();
        LinkedList<String> lastNames = readAccounts.getLastNames();
        LinkedList<Integer> accountList = readAccounts.getAccounts();
        LinkedList<Integer> balances = readAccounts.getBalances();
        
        for (int i = 0; i < firstNames.size(); i++) {
        	accounts.add(new Account(firstNames.get(i), lastNames.get(i), balances.get(i), accountList.get(i)));
        }
        
      for (Account account: accounts) {
    	  System.out.println("First Name: " + account.getFirstName());
          System.out.println("Last Name: " + account.getLastName());
          System.out.println("Account Number: " + account.getAccountNum());
          System.out.println("Balance: " + account.getBalance());
          System.out.println();
      }

    }
}
