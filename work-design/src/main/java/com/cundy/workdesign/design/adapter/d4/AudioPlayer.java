package com.cundy.workdesign.design.adapter.d4;

import com.cundy.workdesign.design.adapter.d1.MediaPlayer;
import com.cundy.workdesign.design.adapter.d3.MediaAdapter;

public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        if (audioType.equalsIgnoreCase("mp3"))
        {
            System.out.println("播放MP3");
        }
        else
        {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }
    }
}
