package com.test.temporary;

import java.util.Stack;

/**
 * Created by Batman on 2018/10/22.
 * @author Batman
 */
public class stackImplQueue{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 入队操作
     * @param item 待传入队列的元素
     */
    public void enQueue(int item){
        stack1.push(item);
        System.out.printf("进入队列的元素为:%d%n",item);
    }

    /**
     * 出队操作(先进先出)
     * @return
     */
    public Integer deQueue(){
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return null;
            }
            transfer();
        }
        System.out.printf("弹出队列的元素为:%d%n",stack2.peek());
        return stack2.pop();
    }

    private void transfer() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        stackImplQueue stackQueue = new stackImplQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(3);
        stackQueue.enQueue(5);
        stackQueue.deQueue();
        stackQueue.deQueue();
        stackQueue.enQueue(6);
        stackQueue.enQueue(9);
        stackQueue.deQueue();
        stackQueue.enQueue(10);
        stackQueue.deQueue();
    }


}
