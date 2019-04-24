package com.test.designpattern.adapter;

/**
 * @author Batman create on 2019-04-23 18:07
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName){
        System.out.println("Playing vlc file.Name: " + fileName);
    }
    @Override
    public void playMp4(String fileName) {
        // TODO
    }
}
