package com.basic.java.hashmap;

import java.util.Arrays;

/**
 * 手动实现HashMap
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\3 0003 13:04
 */
public class MyHashMap {
    private Node[] table;
    private int size;
    public static final int DEFAULT_SIZE = 16;

    public MyHashMap(){
        table = new Node[DEFAULT_SIZE];
    }

    public void put(Object key, Object value){
        Node node = new Node();
        node.setKey(key);
        node.setValue(value);
        node.setNext(null);
        node.setHash(hash(key.hashCode(),table.length));

        Node temp = table[node.getHash()];
        /**链表遍历的最后一个节点*/
        Node iterLast = null;
        boolean repeat = false;
        if(temp==null){
            /** 如果Node数组在hash索引位置是空，则新加入的node就放在此处 */
            table[node.getHash()] = node;
        }else{
            /** 如果Node数组在hash索引位置不为空,则遍历此hash位的链表*/
            while (temp!=null){
                /**如果key重复,则新加入的node覆盖节点的value */
                if(key.equals(temp.getKey())){
                    temp.setValue(value);
                    repeat = true;
                    size--;
                    break;
                }else {
                    iterLast = temp;
                    temp = temp.getNext();
                }
            }
            /** 如果key不重复，则新加入的node需要添加到链表的最后 */
            if(!repeat){
                iterLast.setNext(node);
            }
        }
        size++;
    }

    public Object get(Object key){
        int hash = hash(key.hashCode(),this.table.length);
        Node temp = table[hash];
        if(temp!=null){
            while (temp!=null){
                if(temp.getKey().equals(key)){
                    return temp.getValue();
                }
                temp = temp.getNext();
            }
            return null;
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashMap:[");
        for(Node node : table){
            while (node!=null) {
                sb.append(node.getKey() + ":" + node.getValue() + ",");
                node = node.getNext();
            }
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public int hash(int hashCode, int length){
//        int hash = hashCode % (length-1);
        int hash = (hashCode & (length-1));
        return hash;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1,"one");
        hashMap.put(2,"two");
        hashMap.put(3,"three");
        hashMap.put(10,"ten");
        hashMap.put(17,"seventeen");
        hashMap.put(1,"一");
        System.out.println(hashMap);
        System.out.println(hashMap.get(17));
    }

}
