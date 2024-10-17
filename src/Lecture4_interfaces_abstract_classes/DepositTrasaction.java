package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;

import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(int amount, @NotNull Calendar date){
        super(amount, date);
    }

    // Method t print a transaction receipt or details
    @Override
    public void printTransactionDetails(){
        System.out.println("Deposit Trasaction:___________ ");
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException{
        double curr_balance = ba.getBalance();
        double new_balance = curr_balance + getAmount();
        ba.setBalance(new_balance);
        System.out.println("Deposit successful. New balance: " + new_balance);
    }
}