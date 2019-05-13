package com.test.designpattern.adapter.complexadapter;

import static com.test.designpattern.adapter.complexadapter.AudioPlayer.mp4Type;
import static com.test.designpattern.adapter.complexadapter.AudioPlayer.vlcType;

/**
 * @author Batman create on 2019-04-23 18:11
 */
public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMusicPlayer;

    MediaAdapter(String audioType){
        if(vlcType.equalsIgnoreCase(audioType)){
            advancedMusicPlayer = new VlcPlayer();
        }else if(mp4Type.equalsIgnoreCase(audioType)){
            advancedMusicPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if(vlcType.equalsIgnoreCase(audioType)) {
            advancedMusicPlayer.playVlc(fileName);
        } else if (mp4Type.equalsIgnoreCase(audioType)) {
            advancedMusicPlayer.playMp4(fileName);
        }
    }
}
