package com.test.designpattern.proxy;

/**
 * @author Batman create on 2019-04-25 14:56
 */
public class ProxyImage implements Image {
    /** 实际的图片对象 */
    private RealImage realImage;
    private String fileName;

    public ProxyImage(RealImage realImage, String fileName) {
        this.realImage = realImage;
        this.fileName = fileName;
    }

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 图片展示的接口
     */
    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
