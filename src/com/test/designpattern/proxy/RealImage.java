package com.test.designpattern.proxy;

/**
 * @author Batman create on 2019-04-25 14:53
 */
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Image loading " + fileName);
    }

    /**
     * 图片展示的接口
     */
    @Override
    public void display() {
        System.out.println("Image displaying in " + fileName);
    }
    


}
