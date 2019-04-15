package com.test.property;

/**
 * Created by Batman on 2018/6/28.
 */
public interface Mortal {
      public void die();

    /**
     * 默认方法是JDK8新特性，指的是接口也可以提供具体方法了，而不像以前，只能提供抽象方法
     * 假设没有默认方法这种机制，那么如果要为Mortal增加一个新的方法revive,那么所有实现了Mortal接口的类，都需要做改动。
     * 但是引入了默认方法后，原来的类，不需要做任何改动，并且还能得到这个默认方法
     * 通过这种手段，就能够很好的扩展新的类，并且做到不影响原来的类
     *
     */


      default public void revive(){
          System.out.println("本英雄复活了");
    }
}
