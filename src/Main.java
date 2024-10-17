import Lecture1_adt.*; // Import all classes from Lecture1_adt package to be used in this client code
import Lecture4_interfaces_abstract_classes.BankAccount;
import Lecture4_interfaces_abstract_classes.DepositTransaction;
import Lecture4_interfaces_abstract_classes.InsufficientFundsException;
import Lecture4_interfaces_abstract_classes.WithdrawalTransaction;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
 * Client Code for accessing the Lecture1_adt.TransactionInterface.java module
 */
public class Main {
    public static void testDeposit() {
        System.out.println("\n Testing Deposit Transaction");
        BankAccount account = new BankAccount(5000);
        Calendar date = new GregorianCalendar();
        DepositTransaction deposit = new DepositTransaction(7000, date);

        System.out.println("Initial balance: " + account.getBalance());
        deposit.printTransactionDetails();
        try {
            deposit.apply(account);
            System.out.println("Final balance: " + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void testWithdrawal() {
        System.out.println("\n Testing Withdrawal Transaction");
        BankAccount account = new BankAccount(20000);
        Calendar date = new GregorianCalendar();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(8000, date);

        System.out.println("Initial balance: " + account.getBalance());
        withdrawal.printTransactionDetails();
        try {
            withdrawal.apply(account);
            System.out.println("Withdrawal successful");

            /* Test reversal
            System.out.println("\nTesting reversal...");
            boolean reversed = withdrawal.reverse();
            System.out.println("Reversal successful: " + reversed);
            System.out.println("Balance after reversal: " + account.getBalance());*/
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testDeposit();
        testWithdrawal();
    }
}