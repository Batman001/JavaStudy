package com.test.collection;

import com.test.character.Hero;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Batman on 2018/8/2.
 */
public class HeroNode {
    public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero value;

    // 二叉树添加方法

    public void add(Hero a){
        // 如果当前节点没有值,就把数据放在当前节点上
        // 比当前节点英雄的血量小的话,放置在左子树,大于当前节点英雄血量的话,放置在右子树
        if(null == value)
            value = a;

        else{
            if(a.getHp() - value.getHp() <= 0){
                if(null == leftNode)
                    leftNode = new HeroNode();
                leftNode.add(a);
            }
            else{
                if(null == rightNode)
                    rightNode = new HeroNode();
                rightNode.add(a);
            }
        }
    }

    // 中序遍历
    public List<Hero> values(){
        List<Hero> values = new ArrayList<>();
        // 左子节点
        if(null != leftNode)
            values.addAll(leftNode.values());

        // 当前节点
        values.add(value);

        // 右子节点
        if(null != rightNode)
            values.addAll(rightNode.values());

        return values;
    }

    public static void main(String[] args) {
        System.out.println("初始化100个Hero");
        HeroNode root = new HeroNode();
        for(int i=0;i<100;i++){
            Hero h = new Hero("Hero" + i, (float)(Math.random() * 1000));
            root.add(h);
        }

        System.out.println("根据血量排序后的结果为:");
        for(Hero h:root.values()){
            System.out.println(h);
        }
    }

}
