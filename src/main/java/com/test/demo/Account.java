package com.test.demo;

import java.util.Scanner;

/**
 * Created by Batman on 2018/7/27.
 */
public class Account {

    private Scanner scaner = new Scanner(System.in);
    private double balance;  //余额
    private double deficit;  //透支额
    // 获取当前账号的余额
    private double getBanlance(){
        return this.balance;
    }
    // 设置余额的方法
    private void setAccountMoney(double deposit){
        this.balance = deposit;
    }

    // 存钱方法
    private void deposit() throws OverdraftException {
        System.out.println("请输入存钱的金额:");
        double amt = scaner.nextDouble();
        // 判断amt是否合法
        if(amt>0){
            setAccountMoney(getBanlance()+amt);
            System.out.println("存钱成功,当前余额为:"+getBanlance());
        }
        else{
            throw new OverdraftException("异常信息,存钱的金额不合法");
        }
    }

    // 取钱方法
    private void withdraw() throws OverdraftException{
        System.out.println("请输入你取钱的金额: ");
        double amt = scaner.nextDouble();
        if(amt>0 && amt<=getBanlance()){
            // 取钱金额是合法的
            // 更新余额
            double cha = getBanlance() - amt;
            setAccountMoney(cha);
            System.out.println("取钱成功,当前账户余额是:"+getBanlance());
        }
        else if(amt>getBanlance()){
            // 取钱金额大于账户余额
            double cha = amt - getBanlance();
            throw new OverdraftException("异常信息:取钱金额已经超过余额!超额数为:" + cha);
        }
        else{
            // 取钱金额不合法,取钱金额小于0
            throw new OverdraftException("异常信息:取钱金额不合法!");
        }
    }


    public static void main(String[] args){
        // 实例化一个账户实例
        Account a = new Account();
        try {
            a.deposit();
            a.withdraw();
            a.deposit();
        } catch (OverdraftException e) {
            e.printStackTrace();
        }
    }
}
