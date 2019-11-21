package com.basic.java.juc.threadsafe.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@Slf4j
public class BankAccount {
    String holderName;
    float amount;

    public synchronized void deposit(float amt) {
        amount += amt;
        log.info("线程：{}存入1元,账户总金额现为：{}",Thread.currentThread().getName(),amount);
    }
    public void withdraw(float amt) {
        amount -= amt;
    }
    public float checkBalance() {
        return amount;
    }
}