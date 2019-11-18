package com.basic.java.jdkfeature.jdk8.stream;

import com.basic.java.jdkfeature.entity.Worker;

import java.util.*;

public class StreamSort {
    public static void main(String[] args) {
        List<Worker> workers = new ArrayList<>();
        int i = 0;
        while (i<10){
            i++;
            Worker worker = new Worker();
            worker.setName(UUID.randomUUID().toString().substring(32));
            worker.setId(25 + new Random().nextInt(10));
            workers.add(worker);
        }

        Collections.sort(workers,Comparator.comparingInt(Worker::getId));
        Collections.reverse(workers);
        workers.stream().forEach(p->System.out.println(p.getId() + " - " + p.getName()));
    }
}
