package com.basic.java.juc.threadsafe.task;


import com.basic.java.juc.threadsafe.pojo.BankAccount;
import lombok.Data;

import java.util.Random;

@Data
public class BankAccountThreadSafeConfirmTask implements Runnable{

    private BankAccount account;

    public BankAccountThreadSafeConfirmTask(BankAccount account){
        this.account = account;
    }

    @Override
    public void run() {
//        boolean flag = new Random().nextBoolean();
//        float amt = account.checkBalance();
//        int sign = flag?1:-1;
//        if(flag){
//            float income = new Random().nextFloat() * 100;
//            account.deposit(sign);
//        }else {
//            float output = new Random().nextFloat() * amt;
//            account.withdraw(sign);
//        }

        account.deposit(1);
    }
}
