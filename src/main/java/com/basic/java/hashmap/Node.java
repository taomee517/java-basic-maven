package com.basic.java.hashmap;

/**
 * 节点类，用于HashMap测试
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\3 0003 13:02
 */
public class Node {
    private int hash;
    private Node next;
    private Object key;
    private Object value;


    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node() {
    }

    public Node(int hash, Node next, Object key, Object value) {
        this.hash = hash;
        this.next = next;
        this.key = key;
        this.value = value;
    }
}
