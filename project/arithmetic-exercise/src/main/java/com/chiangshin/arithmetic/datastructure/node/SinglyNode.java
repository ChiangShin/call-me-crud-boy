package com.chiangshin.arithmetic.datastructure.node;

/**
 * 单向链表
 * @Author jx
 * @Date 2021/1/12 22:38
 */
public class SinglyNode<T> {
    public T value;
    public SinglyNode<T> next;

    public SinglyNode(T value){
        this.value = value;
    }
}
