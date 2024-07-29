package part2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.LinkedList;

public class GUI extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L; 

    private LinkedList<Account> globalAccounts;
    private StringBuilder sbAllData;
    private JTextField withdrawAccountNumberField;
    private JTextField withdrawAmountField;
    private JTextField depositAccountNumberField;
    private JTextField depositAmountField;
    private JTextField transactionFromAccountField;
    private JTextField transactionAmountField;
    private JTextField transactionToAccountField;
    private JButton showAllButton, withdrawButton, depositButton, transactionButton;

    public GUI(LinkedList<Account> accounts) {
        super("Banking System");
        getContentPane().setBackground(new Color(128, 128, 128));
        this.globalAccounts = accounts;
        this.sbAllData = new StringBuilder();

        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(801, 664);

        for (Account account : globalAccounts) {
            sbAllData.append("First Name: ").append(account.getFirstName())
                    .append("\nLast Name: ").append(account.getLastName())
                    .append("\nAccount Number: ").append(account.getAccountNum())
                    .append("\nBalance: ").append(account.getBalance()).append("\n\n");
        }

        JPanel boxPanel = new JPanel();
        boxPanel.setBounds(50, 432, 602, 150);
        boxPanel.setBackground(Color.WHITE);
        boxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(boxPanel);

        JTextArea showAllData = new JTextArea();
        boxPanel.add(showAllData);
        showAllData.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(showAllData);
        scrollPane.setPreferredSize(new Dimension(700, 150));
        boxPanel.add(scrollPane);

        JLabel withdrawAccountNumberLabel = new JLabel("Enter Account Number:");
        withdrawAccountNumberField = new JTextField(10);
        JLabel withdrawAmountLabel = new JLabel("Enter Amount:");
        withdrawAmountField = new JTextField(10);
        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new HandlerClass());

        withdrawAccountNumberLabel.setBounds(50, 129, 150, 25);
        withdrawAccountNumberField.setBounds(191, 129, 150, 25);
        withdrawAmountLabel.setBounds(391, 129, 150, 25);
        withdrawAmountField.setBounds(482, 129, 150, 25);
        withdrawButton.setBounds(654, 129, 100, 25);
        getContentPane().add(withdrawAccountNumberLabel);
        getContentPane().add(withdrawAccountNumberField);
        getContentPane().add(withdrawAmountLabel);
        getContentPane().add(withdrawAmountField);
        getContentPane().add(withdrawButton);

        JLabel depositAccountNumberLabel = new JLabel("Enter Account Number:");
        depositAccountNumberField = new JTextField(10);
        JLabel depositAmountLabel = new JLabel("Enter Amount:");
        depositAmountField = new JTextField(10);
        depositButton = new JButton("Deposit");
        depositButton.addActionListener(new HandlerClass());

        depositAccountNumberLabel.setBounds(50, 224, 150, 25);
        depositAccountNumberField.setBounds(191, 224, 150, 25);
        depositAmountLabel.setBounds(391, 224, 150, 25);
        depositAmountField.setBounds(482, 224, 150, 25);
        depositButton.setBounds(654, 224, 100, 25);
        getContentPane().add(depositAccountNumberLabel);
        getContentPane().add(depositAccountNumberField);
        getContentPane().add(depositAmountLabel);
        getContentPane().add(depositAmountField);
        getContentPane().add(depositButton);

        JLabel transactionFromAccountLabel = new JLabel("From Account:");
        transactionFromAccountField = new JTextField(10);
        JLabel transactionAmountLabel = new JLabel("Amount:");
        transactionAmountField = new JTextField(10);
        JLabel transactionToAccountLabel = new JLabel("To Account:");
        transactionToAccountField = new JTextField(10);
        transactionButton = new JButton("Transact");
        transactionButton.addActionListener(new HandlerClass());

        transactionFromAccountLabel.setBounds(50, 312, 136, 25);
        transactionFromAccountField.setBounds(127, 312, 150, 25);
        transactionAmountLabel.setBounds(50, 347, 150, 25);
        transactionAmountField.setBounds(127, 347, 150, 25);
        transactionToAccountLabel.setBounds(302, 312, 150, 25);
        transactionToAccountField.setBounds(391, 312, 150, 25);
        transactionButton.setBounds(50, 382, 100, 25);
        getContentPane().add(transactionFromAccountLabel);
        getContentPane().add(transactionFromAccountField);
        getContentPane().add(transactionAmountLabel);
        getContentPane().add(transactionAmountField);
        getContentPane().add(transactionToAccountLabel);
        getContentPane().add(transactionToAccountField);
        getContentPane().add(transactionButton);

        showAllButton = new JButton("Show All");
        showAllButton.setBounds(50, 592, 100, 25);
        showAllButton.addActionListener(new HandlerClass());
        getContentPane().add(showAllButton);

        JLabel lblForMoneyWithdraw = new JLabel("For money withdraw");
        lblForMoneyWithdraw.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblForMoneyWithdraw.setBounds(50, 94, 150, 25);
        getContentPane().add(lblForMoneyWithdraw);

        JLabel lblForMoneyDeposit = new JLabel("For money deposit");
        lblForMoneyDeposit.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblForMoneyDeposit.setBounds(50, 189, 150, 25);
        getContentPane().add(lblForMoneyDeposit);

        JLabel lblForMoneyTransaction = new JLabel("For money transaction");
        lblForMoneyTransaction.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblForMoneyTransaction.setBounds(50, 277, 150, 25);
        getContentPane().add(lblForMoneyTransaction);

        JLabel lblWelcomeLabel = new JLabel("Welcome to MINI Bank");
        lblWelcomeLabel.setForeground(new Color(0, 0, 0));
        lblWelcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblWelcomeLabel.setBounds(319, 10, 211, 33);
        getContentPane().add(lblWelcomeLabel);

        JLabel lblManageYourMoney = new JLabel("Manage your money as you want from withdraw and deposit to Transaction");
        lblManageYourMoney.setFont(new Font("Times New Roman", Font.ITALIC, 14));
        lblManageYourMoney.setBounds(170, 42, 471, 25);
        getContentPane().add(lblManageYourMoney);
    }

    private class HandlerClass implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showAllButton) {
                Component[] components = getContentPane().getComponents();
                for (Component component : components) {
                    if (component instanceof JPanel) {
                        JPanel panel = (JPanel) component;
                        for (Component innerComponent : panel.getComponents()) {
                            if (innerComponent instanceof JScrollPane) {
                                JScrollPane scrollPane = (JScrollPane) innerComponent;
                                JViewport viewport = scrollPane.getViewport();
                                if (viewport.getView() instanceof JTextArea) {
                                    JTextArea textArea = (JTextArea) viewport.getView();
                                    textArea.setText(sbAllData.toString());
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (e.getSource() == withdrawButton) {
                handleWithdraw();
            } else if (e.getSource() == depositButton) {
                handleDeposit();
            } else if (e.getSource() == transactionButton) {
                handleTransaction();
            }
        }

        private void handleWithdraw() {
            int accountNumber = Integer.parseInt(withdrawAccountNumberField.getText());
            int amount = Integer.parseInt(withdrawAmountField.getText());
            for (Account account : globalAccounts) {
                if (account.getAccountNum() == accountNumber) {
                    account.withdraw(amount);
                    JOptionPane.showMessageDialog(null, "Withdrawal Successful.\n" +
                            "Account Number: " + account.getAccountNum() +
                            ", New Balance: " + account.getBalance());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Account not found.");
        }

        private void handleDeposit() {
            int accountNumber = Integer.parseInt(depositAccountNumberField.getText());
            int amount = Integer.parseInt(depositAmountField.getText());
            for (Account account : globalAccounts) {
                if (account.getAccountNum() == accountNumber) {
                    account.deposit(amount);
                    JOptionPane.showMessageDialog(null, "Deposit Successful.\n" +
                            "Account Number: " + account.getAccountNum() +
                            ", New Balance: " + account.getBalance());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Account not found.");
        }

        private void handleTransaction() {
            int fromAccountNumber = Integer.parseInt(transactionFromAccountField.getText());
            int toAccountNumber = Integer.parseInt(transactionToAccountField.getText());
            int amount = Integer.parseInt(transactionAmountField.getText());
            Account fromAccount = null;
            Account toAccount = null;
            for (Account account : globalAccounts) {
                if (account.getAccountNum() == fromAccountNumber) {
                    fromAccount = account;
                }
                if (account.getAccountNum() == toAccountNumber) {
                    toAccount = account;
                }
            }
            if (fromAccount != null && toAccount != null) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                JOptionPane.showMessageDialog(null, "Transaction completed.\n" +
                        "From Account: " + fromAccount.getAccountNum() + ", New Balance: " + fromAccount.getBalance() + "\n" +
                        "To Account: " + toAccount.getAccountNum() + ", New Balance: " + toAccount.getBalance());
            } else {
                JOptionPane.showMessageDialog(null, "One or both accounts not found.");
            }
        }
    }
    public static void main(String[] args) {
        LinkedList<Account> accounts = new LinkedList<>();
        accounts.add(new Account("John", "Doe", 1, 2000));
        accounts.add(new Account("Jane", "Doe", 2, 1000));

        GUI gui = new GUI(accounts);
        gui.setVisible(true);
    }
}
