package com.test.designpattern.abstaractfactorypattern;

/**
 * @author Batman create on 2019-04-26 15:13
 * 创建一个工厂 生成基于给定颜色信息的实体类对象
 */
public class ColorFactory extends AbstractFactory {
    @Override
    Color getColor(String color) {
        if(color == null){
            return null;
        }else if(("RED").equalsIgnoreCase(color)){
            return new Red();
        }else if(("Blue").equalsIgnoreCase(color)){
            return new Blue();
        }else if(("Green").equalsIgnoreCase(color)){
            return new Green();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
