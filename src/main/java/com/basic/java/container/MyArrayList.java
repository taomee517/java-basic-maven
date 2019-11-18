package com.basic.java.container;

/**
 * 手动实现ArrayList的基本功能
 *
 * @Author luotao
 * @E-mail taomee517@qq.com
 * @Date 2019\2\3 0003 10:04
 */
public class MyArrayList<E>{
    private Object[] elementData;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;
    public static final Object[] EMPTY_GROUP = {};

    public MyArrayList(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int length) throws Exception{
        if(length > 0){
            this.elementData = new Object[length];
        }else if(length == 0){
            this.elementData = EMPTY_GROUP;
        }else{
            throw new Exception("数据长度不能为负数");
        }
    }

    public void add(E e){
        ensureCapacity();
        this.elementData[size++] = e;
    }

    public void remove(int index){
        System.arraycopy(elementData,index+1,elementData,index,elementData.length-1-index);
        elementData[elementData.length-1] = null;
        size--;
    }

    public void ensureCapacity(){
        if(size>=elementData.length){
            int extendCapacity = (size + (size>>1));
            Object[] temp = new Object[extendCapacity];
            System.arraycopy(elementData,0,temp,0,elementData.length);
            elementData = temp;
        }
    }

    public E get(int index) throws Exception{
        if(index<0||index>=size){
            throw new Exception("索引不合法：" + index);
        }
        return (E)elementData[index];
    }

    public void edit(int index,E e) throws Exception{
        if(index<0||index>=size){
            throw new Exception("索引不合法：" + index);
        }
        elementData[index] = e;
    }

    public boolean contains(E e){
       return indexOf(e) >= 0;

    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Object o : elementData){
            if(o!=null){
                sb.append(o + ",");
            }
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        MyArrayList arr = new MyArrayList(5);
        System.out.println("--------新增测试--------");
        arr.add("aa");
        arr.add("bb");
        arr.add("cc");
        arr.add("dd");
        arr.add("ee");
        arr.add("ff");
        System.out.println(arr);
        System.out.println(arr.elementData.length);
        System.out.println(arr.size);
        System.out.println("--------删除测试--------");
        arr.remove(5);
        System.out.println(arr);
        System.out.println(arr.elementData.length);
        System.out.println(arr.size);
        System.out.println("--------查询测试--------");
        System.out.println(arr.get(3));
        System.out.println("--------修改测试--------");
        arr.edit(2,"alibaba");
        System.out.println(arr);
        System.out.println("--------包含测试--------");
        System.out.println(arr.contains("ali"));
    }
}
