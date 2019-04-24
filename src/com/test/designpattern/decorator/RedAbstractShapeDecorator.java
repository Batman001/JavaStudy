package com.test.designpattern.decorator;

/**
 * @author Batman create on 2019-04-24 10:57
 */
public class RedAbstractShapeDecorator extends AbstractShapeDecorator {

    public RedAbstractShapeDecorator(Shape decorateShape) {
        super(decorateShape);
    }

    /**
     * shape 打印具体的形状
     */
    @Override
    public void draw() {
        decorateShape.draw();
        setRedBorder(decorateShape);
    }

    private void setRedBorder(Shape decorateShape) {
        System.out.println("Border Color : Red");
    }

}
