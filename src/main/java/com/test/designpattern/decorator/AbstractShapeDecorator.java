package com.test.designpattern.decorator;

/**
 * @author Batman create on 2019-04-24 10:08
 */
public abstract class AbstractShapeDecorator implements Shape {

    protected Shape decorateShape;
    public AbstractShapeDecorator(Shape decorateShape){
        this.decorateShape = decorateShape;
    }
    /**
     * shape 打印具体的形状
     */
    @Override
    public void draw() {
        decorateShape.draw();
    }
}
