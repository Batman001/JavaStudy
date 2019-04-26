package com.test.designpattern.adapter;

/**
 * @author Batman create on 2019-04-23 18:06
 */
public interface AdvancedMediaPlayer {
    /**
     * 播放vlc视频
     * @param fileName String 文件名称
     */
    void playVlc(String fileName);

    /**
     * 播放MP4视频
     * @param fileName String 文件名称
     */
    void playMp4(String fileName);

}
