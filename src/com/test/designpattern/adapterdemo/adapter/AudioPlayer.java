package com.test.designpattern.adapterdemo.adapter;

/**
 * 音频播放器类
 * @author Batman create on 2019-04-23 18:18
 */
public class AudioPlayer implements MediaPlayer{
     private MediaAdapter mediaAdapter;
    static String vlcType = "vlc";
    static String mp4Type = "mp4";
    static String mp3Type = "mp3";

    @Override
    public void play(String audioType, String fileName) {
        /** 播放mp3的内置支持 */
        if(mp3Type.equalsIgnoreCase(audioType)){
            System.out.println("Playing mp3 file. Name:" + fileName);
        }
        /** mediaAdapter提供播放其他文件格式的支持 */
        else if (vlcType.equalsIgnoreCase(audioType) || mp4Type.equalsIgnoreCase(audioType)){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);

        } else{
            System.out.println("Invalid media " + audioType + " format not supported");
        }


    }
}
