package com.test.designpattern.adapter;

/**
 * @author Batman create on 2019-04-23 18:09
 */
public class Mp4Player implements AdvancedMediaPlayer {
    /**
     * @param fileName String 文件名称
     */
    @Override
    public void playVlc(String fileName) {
        // TODO

    }

    /**
     * @param fileName String 文件名称
     */
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);

    }
}
