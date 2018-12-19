package com.company.caini.character;

import com.company.caini.property.Weapon;
import com.company.caini.property.LifePotion;
import com.company.caini.property.MagicPotion;
import com.company.caini.property.Item;
import com.company.caini.property.Mortal;

import java.io.Serializable;
import java.lang.String;



/**
 * Created by sunchao on 2018/5/16.
 */


/**
 * 那么什么情况该用什么修饰符呢？
 * 从作用域来看，public能够使用所有的情况。 但是大家在工作的时候，又不会真正全部都使用public,那么到底什么情况该用什么修饰符呢？

 * 1. 属性通常使用private封装起来
 * 2. 方法一般使用public用于被调用
 * 3. 会被子类继承的方法，通常使用protected
 * 4. package用的不多，一般新手会用package,因为还不知道有修饰符这个东西

 * 再就是作用范围最小原则
 * 简单说，能用private就用private，不行就放大一级，用package,再不行就用protected，最后用public。 这样就能把数据尽量的封装起来，没有必要露出来的，就不用露出来了

 */

public class Hero implements Serializable,HeroItem {

    // Hero实现了Serializable 接口
    private static final long serialVersionUID=1L;

    // protected饰符的属性 hp
    // 自己可以访问
    // 同包子类可以继承
    // 不同包子类可以继承
    // 同包类可以访问
    // 其他类不能访问

    private int id;  //属性id是private,只有本身可以访问
    public String name;  //姓名 对象属性,非静态属性
    float maxHp;
    public float hp;    //血量
    float armor;   //护甲
    int moveSpeed = 300;   //移动速度
    static String copyright; // 类属性,静态属性
    public int price;
    int damage = 5;
    /*
    对象属性初始化有3种
    1. 声明该属性的时候初始化
    2. 构造方法中初始化
    3. 初始化块
     */

    // 类属性初始化两种形式(静态变量的两种初始化方式)
    public static int itemCapacity=8;  // 声明的时候初始化
    static{
        itemCapacity = 6;  // 静态初始化块 初始化
    }

    /*
    public Hero(String heroName, float heroHp, float heroArmor, int heroMoveSpeed){
        name = heroName;
        hp = heroHp;
        armor = heroArmor;
        moveSpeed = heroMoveSpeed;
    }
*/

    // this关键字在构造函数中的作用
    // this代表当前对象
    public void showAddressInMemory(){
        System.out.println("打印this看到的虚拟地址:"+this);
    }

    public void equip(Weapon w){

    }

    /*//带一个参数的this构造方法
    public Hero(String heroName){
        System.out.println("一个参数的构造方法");
        this.name = heroName;
    }

    //带两个参数的构造方法
    //在一个构造方法中调用另一个构造方法 用this()
    public Hero(String name,float hp){
        this(name);
        System.out.println("两个参数的构造方法");
        this.hp = hp;
    }

*/

    public Hero(String heroName,float heroHp){
        this.name = heroName;
        this.hp = heroHp;
//        System.out.println("调用带两个参数的父类Hero的构造方法");
    }

    public Hero(String heroName, float heroHp, float heroArmor, int heroMoveSpeed){
        this(heroName, heroHp);
        this.armor = heroArmor;
        this.moveSpeed = heroMoveSpeed;
//        System.out.println("调用多个参数的父类Hero的构造方法");
    }

    public Hero(){}
    public Hero(String strName){
        this.name = strName;

    }
    //参数名和属性名一样
    //在方法体中，只能访问到参数name

    public void setName1(String name){
        name = name;
    }

    public void setName2(String heroName){
        name = heroName;
    }

    public void setName3(String name){
        // name 代表的是参数name
        // this.name 代表的属性name
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public float getHp(){
        return this.hp;
    }


    // toString方法是object类调用的方法 返回当前对象的字符串表达
    public String toString(){
        return "当前英雄的Name是:"+this.name+",当前英雄的价格是:"+this.price+",当前英雄的血量是是:"+this.hp;
    }


    // finalize方法是object类调用方法,垃圾回收机制
    @Override
    public void finalize(){
        System.out.println("自己创建的重写object垃圾回收机制");
    }

    // equals() 方法用于判断两个对象的内容是否一样
    @Override
    public boolean equals(Object o){
        if(o instanceof Hero){
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        else
            return false;

    }

    // 回血操作
    public void huixue(int xp){
        hp = hp + xp;
        //回血完成后,血瓶=0
        xp = 0;
    }

    // 攻击一个英雄,并让他掉damage的血量
    public void attack(Hero hero, int damage) throws EnemyHeroIsDeadException{
        if(hero.hp == 0)
            throw new EnemyHeroIsDeadException(hero.name + " 已经挂了,不需要施放技能");
        hero.hp = hero.hp - damage;
        System.out.println(name + "攻击了" + hero.name + ",并使其掉了"+damage+"的血量");
    }



    // 英雄没血的时候调用die方法
    public void die(){
        hp = 0;
        System.out.println("英雄失血过多,已经挂掉");
        Hero.battleWin();
    }

    // 复活一个英雄
    public void revive(Hero hero){
        hero = new Hero("提莫", 378.f);
    }

    // 类方法,静态方法
    // 通过类就可以直接调用
    public static void battleWin(){
        //System.out.println(name + "battle win");  // 此行会报错,由于battleWin是静态方法,通过类名调用,而name属性为非静态属性
        System.out.println("battle win");  // 静态方法不可以调用非静态变量,只可以调用静态的属性
    }

    // 对象方法 直接获得对象的名字属性
    public String getHeroName(){
        System.out.println("当前英雄的名字属性是:"+name);
        return name;
    }

    // 类方法 没有调用对象的任何属性
    public static void playGameDuration(){
        System.out.println("已经玩了10份50秒");
    }

    public void useItem(Item i){
        i.effect();
    }

    public void kill(Mortal m){
        m.die();
    }

    @Override
    public void showId() {
        System.out.println("我是Hero");
    }


    // 应用枚举类型 将英雄进行分类
    public enum HeroType{
        TANK,WIZARD,ASSASSIN,ASSIST,WARRIOR,RANGED,PUSH,FARMING;
    }

    // 非静态内部类，只有一个外部类对象存在的时候，才有意义
    // 战斗成绩只有在一个英雄对象存在的时候才有意义
    // 英雄的战绩
    class BattleScore{
        int kill;
        int die;
        int assit;
        public void legendary(){
            if(kill>4)
                System.out.println(name+ "超神");
            else
                System.out.println(name + "尚未超神");
        }

    }

    // 静态内部类
    // 敌方水晶血量
    static class EnemyCrystal{
        int hp = 5000;
        // 如果水晶血量为0 则宣布获得胜利
        public void checkIfVictory(){
            if (hp==0)
                Hero.battleWin();
            // 静态内部类不能直接访问外部类的对象属性
            //System.out.println(name + "win this game");
            else
                System.out.println("地方水晶仍然坚挺,请加油推搭");
        }
    }

    public static void main(String[] args){
        /*
        Hero garen =  new Hero("盖伦");
        Hero garen1 = new Hero("盖伦", 1000.67f);
        Hero teemo =  new Hero("提莫");
        //直接打印对象，会显示该对象在内存中的虚拟地址
        //格式：Hero@c17164 c17164即虚拟地址，每次执行，得到的地址不一定一样
        System.out.println("打印对象看到的虚拟地址："+garen);

        garen.showAddressInMemory();

        System.out.println("打印对象看到的虚拟地址："+teemo);
        teemo.showAddressInMemory();


        garen.setName1("盖伦测试名称");
        System.out.println(garen.name);   // 打印结果仍然为garen ,并没有改变其name属性 该方法只能访问到参数

        teemo.setName2("提莫2");
        System.out.println(teemo.name);   // 打印结果提莫2

        teemo.setName3("提莫3");
        System.out.println(teemo.name);   // 打印结果提莫3
        */
        Hero.copyright = "版权由Riot Games公司所有";
        Hero teemo = new Hero("提莫", 378.f);

        Hero teemo1 = new Hero("提莫1", 383.f, 0.f, 10);
        Hero garen = new Hero("盖伦", 678.f);

        try{
            garen.attack(teemo,10);
        }
        catch (EnemyHeroIsDeadException e){
            System.out.println("异常的原因是:" + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("提莫的复活前地址为" + teemo);
        System.out.println("盖伦攻击提莫后,提莫剩余血量为"+teemo.hp);
        teemo.revive(teemo);

        System.out.println("提莫的复活后地址为" + teemo);
        System.out.println(teemo.name);
        System.out.println(teemo1.armor);
        /*
        都会改变的，因为copyright为类属性，类似于全局变量，任何地方修改了这个属性，那么其他使用这个属性的地方都会修改。
        通俗点讲就是大家都在一个水塘里取水，其中一个人往水塘里加盐了，那么其他人的水也会变咸
         */
        teemo.copyright = "核工业集团所有";
        System.out.println(teemo.copyright);
        System.out.println(garen.copyright);
        Hero.battleWin();  // 使用该种方法 类.类方法 的方式进行,符合语义的理解.
        garen.getHeroName();
        Hero.playGameDuration();
        /*
        (1)测试对象方法能否调用类方法  结果是可行的
        (2)类方法中不能调用对象方法, 对象方法要有实例化对象才可以调用
         */
        garen.die();

        System.out.println(Hero.itemCapacity);

        // 应用枚举类型对英雄进行分类
        HeroType hero = HeroType.WIZARD;
        System.out.println("全部英雄的类别为:");
        for (HeroType h:HeroType.values()){
            System.out.println(h);
        }
        switch (hero){
            case TANK:
                System.out.println("当前英雄类型为TANK (坦克)");
                break;
            case WIZARD:
                System.out.println("当前英雄类型为WIZARD (法师 )");
                break;
            case ASSASSIN:
                System.out.println("当前英雄类型为ASSASSIN (刺客)");
                break;
            case ASSIST:
                System.out.println("当前英雄类型为ASSIST (辅助)");
                break;
            case WARRIOR:
                System.out.println("当前英雄类型为WARRIOR (近战)");
                break;
            case RANGED:
                System.out.println("当前英雄类型为RANGED (远程 )");
                break;
            case PUSH:
                System.out.println("当前英雄类型为PUSH (推进)");
                break;
            case FARMING:
                System.out.println("当前英雄类型为FARMING (打野)");
                break;
        }


        //类型转换指的是把一个引用所指向的对象的类型，转换为另一个引用的类型
        //把ad引用所指向的对象的类型是ADHero
        //h引用的类型是Hero
        //把ADHero当做Hero使用，一定可以

        // 子类转父类 一定可行 这里用物理攻击英雄当做普通英雄一定是可以的
        Hero h = new Hero("亚瑟",178.f);

        // 匿名类指的是在声明一个类的同时实例化它，使代码更加简洁精练
        // 通常情况下，要使用一个接口或者抽象类，都必须创建一个子类
        // 这里使用内部类方法attack 在已经存在attack方法的基础上,添加对象自有的相关方法
        ADHero ad = new ADHero("李元芳",129.f){
            // 匿名类指的是在声明一个类的同时实例化它，使代码更加简洁精练
            public void attack(){
                System.out.println("李元芳射手新的进攻手段,可以发射biubiubiu");
            }
        };
        ad.attack();
        h = ad;
        System.out.println("子类转父类一定可行后的打印结果为"+h.name);

        // 父类转子类 一般不行 需要用到强制转换
        ad = (ADHero)h;
        System.out.println("强制转换父类转子类后打印结果为"+ad.name);


        // 另一种父类转子类 即出现子类不对应的情形,也会导致失败
        Support s = new Support("蔡文姬", 300.f);
        h = s;
        System.out.println(h.name);  // h指向为对象类型为Supprt,打印名称为蔡文姬
        //ad = (ADHero)h;  // 将h引用所指向的对象Support,转化为ad引用的类型ADHero,
        // 即将辅助英雄转化为ADHero,导致失败,并且抛出ClassCastException
        /*
        把一个ADHero类型转换为AD接口
        从语义上来讲，把一个ADHero当做AD来使用，
        而AD接口只有一个physicAttack方法，这就意味着转换后就有可能要调用physicAttack方法，
        而ADHero一定是有physicAttack方法的，所以转换是能成功的。
         */

        AD adi = ad;  //类转换成接口(向上转型) // 转型一定可以成功


        /*
        接口转换成实现类
         */

        ADHero adhero = new ADHero("孙尚香",100.f);
        /*
        adi引用所指向的对象是一个ADHero，要转换为ADAPHero就会失败
         */
        //ADAPHero adaphero = (ADAPHero) adi; // 报错信息为ClassCastException



        // 使用instanceof Hero 方法判断一个引用所指向的对象,是否是Hero类型,或者Hero的子类
        ADHero ad1 = new ADHero("甄姬", 136.f);
        APHero ap1 = new APHero("安琪拉", 136.f);

        Hero h1 = ad1;  // 子类向父类转型 向上转型
        Hero h2 = ap1;  // 子类向父类转型 向上转型
        //判断引用h1指向的对象，是否是ADHero类型
        System.out.println(h1 instanceof ADHero);

        //判断引用h2指向的对象，是否是APHero类型
        System.out.println(h2 instanceof APHero);

        //判断引用h1指向的对象，是否是Hero的子类型
        System.out.println(h1 instanceof Hero);



        // 多态 同样的物品使用同一种方法 可以考虑使用多态
        LifePotion lp = new LifePotion();
        MagicPotion mp = new MagicPotion();
        garen.useItem(lp);
        teemo.useItem(mp);

        // 多态使用
        garen.kill(ap1);
        garen.kill(ad1);


        System.out.println(garen);  // 盖伦 Object调用类中toString方法 返回当前对象的字符串的值

        // 当一个对象没有任何引用的时候,它就满足垃圾回收的条件
        // finalize()方法不是开发人员主动调用方法,是由虚拟机JVM调用的

//        Hero testh;
//        for(int i=0;i<1000000;i++){
//            testh = new Hero();
//        }

        System.out.println("测试ADHero与APHero的血量一样情况下两者相等的判断为:"+ad1.equals(ap1));

        // 测试非静态内部类
        // 实例化内部类
        // new 外部类().new 内部类()
        BattleScore bs = garen.new BattleScore();
        bs.kill = 9;
        bs.legendary();

        Hero.EnemyCrystal crystal = new Hero.EnemyCrystal();
        crystal.checkIfVictory();


//        本地类可以理解为有名字的匿名类
//        与内部类不一样的是，内部类必须声明在成员的位置，即与属性和方法平等的位置。
//        本地类和匿名类一样，直接声明在代码块里面，可以是主方法，for循环里等等地方

        class SomeHero extends Hero{

            public SomeHero(String heroName, float heroHp) {
                super(heroName, heroHp);
            }
            public void attack(){
                System.out.println( name+ " 新的进攻手段");
            }

        }

        SomeHero sh = new SomeHero("阿离", 100.f);
        sh.attack();



        // 在匿名类中使用外部的局部变量

        class AnonymousHero extends Hero{
            final int damage;
            public AnonymousHero(String heroName, float heroHp, int damage) {
                super(heroName, heroHp);
                this.damage = damage;
            }
            public void attack_in() {
                System.out.printf(name + "新的进攻手段，造成%d点伤害", this.damage);
            }
        }
        AnonymousHero caocao = new AnonymousHero("曹操",150.f, 10);
        caocao.attack_in();


        // 接口默认方法测试
        ad1.revive();
        ADAPHero adap = new ADAPHero("貂蝉", 100.f, 123.f, 189);
        adap.attack();


    }





}


