package com.cundy.workdesign.design.adapter.d3;

import com.cundy.workdesign.design.adapter.d1.AdvanceMediaPlayer;
import com.cundy.workdesign.design.adapter.d1.MediaPlayer;
import com.cundy.workdesign.design.adapter.d2.Mp4Player;
import com.cundy.workdesign.design.adapter.d2.VlcPlayer;

public class MediaAdapter implements MediaPlayer {

   AdvanceMediaPlayer advanceMediaPlayer;

   public MediaAdapter(String audioType)
   {
       if (audioType.equalsIgnoreCase("vlc"))
       {
           advanceMediaPlayer = new VlcPlayer();
       }
       else if (audioType.equalsIgnoreCase("mp4"))
       {
           advanceMediaPlayer = new Mp4Player();
       }
   }


    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc"))
        {
            advanceMediaPlayer.playVlc(fileName);
        }
        else if(audioType.equalsIgnoreCase("mp4"))
        {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
