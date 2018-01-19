package com.example.android.miwok;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Blood_seeker on 11/9/2017.
 */

public class Word {

    private int im = 0;
    private int MP = 0;
    private String english;

    private String miwok;

    public Word(String english, String miwok , int MP ) {
        this.english = english;
        this.miwok = miwok;
        this.MP = MP;

    }
    public Word(String english, String miwok , int im , int MP) {
        this.english = english;
        this.miwok = miwok;
        this.im = im;
        this.MP = MP;
    }

    public String getEnglish() {

        return english;
    }

    public void setEnglish(String english) {

        this.english = english;
    }

    public String getMiwok() {

        return miwok;
    }

    public void setMiwok(String miwok) {

        this.miwok = miwok;
    }


    public int getIm() {
        return im;
    }

    public void setIm(int im) {

        this.im = im;
    }

    public int getMP(){return MP;}
}
