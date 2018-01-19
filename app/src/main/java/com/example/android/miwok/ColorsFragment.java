package com.example.android.miwok;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

   private MediaPlayer mp ;
    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Word> Colors = new ArrayList<>();
        Colors.add(new Word("Red" ,"Wetetti" ,R.drawable.color_red ,R.raw.color_red));

        Colors.add(new Word("Green" ,"Chokokki",R.drawable.color_green ,R.raw.color_green));

        Colors.add(new Word("Brown" ,"Takaakki",R.drawable.color_brown ,R.raw.color_brown));
        Colors.add(new Word("Gray" ,"Topoppi",R.drawable.color_gray ,R.raw.color_gray));
        Colors.add(new Word("Black" ,"Kululli",R.drawable.color_black ,R.raw.color_black));
        Colors.add(new Word("White" ,"Kelelli",R.drawable.color_white ,R.raw.color_white));
        Colors.add(new Word("Dusty Yellow" ,"Toplisa",R.drawable.color_dusty_yellow ,R.raw.color_dusty_yellow));
        Colors.add(new Word("Mustered Yello" ,"Chiwita",R.drawable.color_mustard_yellow ,R.raw.color_mustard_yellow));




        WordAdapter itemsAdapter = new WordAdapter(getActivity(),  Colors , R.color.category_colors);

        //ListView listView = (ListView) findViewById(R.id.list);

        //listView.setAdapter(itemsAdapter);
        ListView listView = (ListView) rootView.findViewById(R.id.List);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = Colors.get(position);
                mp  =  MediaPlayer.create(getActivity(),word.getMP());

                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                        //Toast.makeText(PhrasesActivity.this , "I'am done" , Toast.LENGTH_SHORT).show();
                    }
                });

                Toast.makeText(getActivity(),word.getEnglish()+"!",Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            // AM.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}
