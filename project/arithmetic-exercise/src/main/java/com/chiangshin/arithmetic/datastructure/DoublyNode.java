package com.chiangshin.arithmetic.datastructure;

/**
 * 双向链表
 * @Author jx
 * @Date 2021/1/12 22:38
 */
public class DoublyNode<T> {
    public T value;
    public DoublyNode<T> pre;
    public DoublyNode<T> next;

    public DoublyNode(T value){
        this.value = value;
        next = null;
        pre = null;
    }
}
