package com.basic.java.juc.threadsafe;

import com.basic.java.juc.threadsafe.pojo.BankAccount;
import com.basic.java.juc.threadsafe.task.BankAccountThreadSafeConfirmTask;
import com.basic.java.util.ThreadPoolUtil;

import java.util.concurrent.ExecutorService;

public class ThreadSafeTest {

    private static final int THREAD_LIMIT = 100;

    private static volatile BankAccount account = BankAccount.builder().amount(10000).holderName("Nick").build();

    public static void main(String[] args) {
        ExecutorService pool = ThreadPoolUtil.pool;
        Runnable depositTask = new BankAccountThreadSafeConfirmTask(account);
        //目前的写法并不安全 todo
        for(int i=0;i<THREAD_LIMIT;i++){
            pool.submit(depositTask);
        }
    }
}
