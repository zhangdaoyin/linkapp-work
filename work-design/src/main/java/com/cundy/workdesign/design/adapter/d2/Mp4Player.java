package com.cundy.workdesign.design.adapter.d2;

import com.cundy.workdesign.design.adapter.d1.AdvanceMediaPlayer;

public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //
    }

    @Override
    public void playMp4(String fileName) {

        System.out.println("使用了MP4");
    }
}
