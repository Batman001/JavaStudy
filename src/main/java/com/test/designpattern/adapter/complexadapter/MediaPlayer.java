package com.test.designpattern.adapter.complexadapter;

/**
 * 播放器接口
 * @author Batman create on 2019-04-23 18:04
 */
public interface MediaPlayer {
    /**
     * 播放器播放接口
     * @param audioType String 音视频类型
     * @param fileName String 文件名称
     */
    void play(String audioType, String fileName);
}
