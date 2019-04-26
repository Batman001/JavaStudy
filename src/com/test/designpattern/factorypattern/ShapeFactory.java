package com.test.designpattern.factorypattern;

/**
 * @author Batman create on 2019-04-26 14:58
 * 创建一个工厂 生成基于给定信息的实体类对象
 */
public class ShapeFactory {
    Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }else if(("CIRCLE").equalsIgnoreCase(shapeType)){
            return new Circle();
        }else if(("RECTANGLE").equalsIgnoreCase(shapeType)){
            return new Rectangle();
        }else if(("SQUARE").equalsIgnoreCase(shapeType)){
            return new Square();
        }
        return null;
    }
}
