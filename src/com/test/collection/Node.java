package com.test.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Batman on 2018/8/2.
 * @author Batman
 */
public class Node {
    /**
     * 左子节点
     */
    public Node leftNode;
    /**
     * 右子节点
     */
    public Node rightNode;
    /**
     * 节点的值
     */
    public Object value;

    public Node(Object value, Node left, Node right){
        this.value = value;
        this.leftNode = left;
        this.rightNode = right;
    }
    public Node(){}

    public Node getLeft(){return leftNode;}
    public Node getRight(){return rightNode;}
    public Object getVal(){return value;}


    /**
     * 插入数据
     * 感觉像堆排序 建堆的过程
     * @param v 传入Node的值
     */
    public void add(Object v){
        // 如果当前节点没有值,就把数据放在当前节点上
        if(null == value)
            value = v;
        // 如果当前节点有值,就进行判断,新增的值与当前值的大小关系
        else{
            // 新增的值, 比当前值小或者相同
            if((Integer) v - ((Integer) value) <= 0){
                if(null == leftNode)
                    leftNode = new Node();
                leftNode.add(v);
            }

            // 新增的值比当前值大
            else{
                if(null == rightNode)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }


    /**
     * 中序遍历 (递归实现)
     * @return
     */
    public List<Object> middleTravel(){
        List<Object> values = new ArrayList<>();

        // 左节点的的遍历结果
        if(null != leftNode)
            values.addAll(leftNode.middleTravel());

        // 当前节点
        values.add(value);

        // 右节点的遍历结果
        if(null != rightNode)
            values.addAll(rightNode.middleTravel());
        return values;
    }


    /**
     * 前序遍历
     * @return
     */
    public List<Object> preorderTravel(){
        List<Object> values = new ArrayList<>();
        // 添加根节点值
        values.add(value);
        // 遍历左子节点
        if(null != leftNode)
            values.addAll(leftNode.preorderTravel());
        if(null != rightNode)
            values.addAll(rightNode.preorderTravel());
        return values;
    }

    /**
     * 后序遍历
     */
    public List<Object> postOrderTravel(){
        List<Object> values = new ArrayList<>();
        if(null != leftNode)
            values.addAll(leftNode.preorderTravel());
        if(null != rightNode)
            values.addAll(rightNode.preorderTravel());
        values.add(value);
        return values;
    }


    /**
     * 打印二叉树的值
     */

    public void visit(){
        System.out.println(value);
    }

    /**
     * 层遍历二叉树并打印
     * @param root
     */

    public static void LevelTravel(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node visitedNode = queue.poll();
            visitedNode.visit();
            if(visitedNode.getLeft() != null)
                queue.add(visitedNode.getLeft());
            if(visitedNode.getRight() != null)
                queue.add(visitedNode.getRight());
        }
    }


    public static void main(String[] args) {
        int randoms[] = new int[] {67,7,30,74,10,0,78,81,34};
        Node roots = new Node();
        for(int number:randoms){
            roots.add(number);
        }

        System.out.println("中序遍历为:"+roots.middleTravel());
        System.out.println("前序遍历为:"+roots.preorderTravel());
        LevelTravel(roots);
        System.out.println("后序遍历为:"+roots.postOrderTravel());
    }
}
