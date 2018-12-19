package com.company.caini.character;

/**
 * Created by sunchao on 2018/6/25.
 */
public class Support extends Hero implements Healer {
    public Support(String heroName, float heroHp) {
        super(heroName, heroHp);
    }

    @Override
    public void heal(){
        System.out.println("为英雄"+name+"进行了一次治疗");
    }



    // 利用可变数量对多个英雄进行加血操作
    /*
    当可变参数个数多余一个时，必将有一个不是最后一项，所以只支持有一个可变参数。
    因为参数个数不定，所以当其后边还有相同类型参数时，
    java无法区分传入的参数属于前一个可变参数还是后边的参数，所以只能让可变参数位于最后一项。
     */
    public void heal(int inp, Hero...heros){
        for(int i=0;i<heros.length;i++){
            System.out.println(name + "为英雄"+ heros[i].name+"恢复了"+inp+"的血量");
        }
    }

    public static void main(String[] args){
        Support s = new Support("扁鹊", 100.f);

        s.heal();

        Hero h1 = new Hero("后羿", 78.f);
        Hero h2 = new Hero("狄仁杰",79.f);

        s.heal(50,h1,h2);


    }

}
