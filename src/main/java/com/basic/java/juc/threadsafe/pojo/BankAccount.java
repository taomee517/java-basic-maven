package com.basic.java.juc.threadsafe.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Data
@Builder
@Slf4j
public class BankAccount {
    String holderName;
    float amount;
    private static ReentrantLock lock = new ReentrantLock(true);

    public void deposit(float amt) {
        lock.lock();
        amount += amt;
        log.info("存入1元后,账户总金额为：{}",amount);
        lock.unlock();
    }
    public void withdraw(float amt) {
        amount -= amt;
    }
    public float checkBalance() {
        return amount;
    }
}
