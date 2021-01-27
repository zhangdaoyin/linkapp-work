package com.cundy.workdesign.design.adapter.d2;

import com.cundy.workdesign.design.adapter.d1.AdvanceMediaPlayer;

public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("使用了VLC");
    }

    @Override
    public void playMp4(String fileName) {

    }
}
