package com.company.caini.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Batman on 2018/10/9.
 * @author Batman
 */
public class MyNode<T> {

    /**
     * 左子节点
     */
    public MyNode<T> leftNode;

    /**
     * 右子节点
     */
    public MyNode<T> rightNode;

    /**
     * 值
     * @param args
     */
    public T value;

    /**
     * 插入数据
     * @param t value of Node
     */
    public void add(T t){
        // 如果当前节点没有值,就把数据放在当前节点上
        if(null == value)
            value = t;
        // 如果当前节点有值,进行判断新增至与当前值的大小关系
        else{
            if((Integer) t - (Integer) value <= 0){
                if(null==leftNode)
                    leftNode = new MyNode<T>();
                leftNode.add(t);
            }
            else{
                if(null == rightNode)
                    rightNode = new MyNode<T>();
                rightNode.add(t);
            }
        }

    }

    /**
     * 中序遍历所有节点
     */
    public List<T> values(){
        List<T> values = new ArrayList<T>();

        // 左节点的遍历结果
        if(null != leftNode){
            values.addAll(leftNode.values());
        }

        // 当前节点
        values.add(value);

        // 右节点
        if(null != rightNode){
            values.addAll(rightNode.values());
        }
        return values;

    }

    public static void main(String[] args) {
        int[] randoms = new int[] {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        MyNode<Integer> root = new MyNode<>();
        for(int number:randoms){
            root.add(number);
        }
        System.out.println(root.values());
    }



}


