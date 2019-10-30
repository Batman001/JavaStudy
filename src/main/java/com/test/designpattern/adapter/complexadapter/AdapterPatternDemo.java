package com.test.designpattern.adapter.complexadapter;

/**
 * @author Batman create on 2019-04-23 18:27
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "someone like you.vlc");
        audioPlayer.play("avi", "tokyo hot.avi");
    }
}
