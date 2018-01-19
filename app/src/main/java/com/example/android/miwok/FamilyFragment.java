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
public class FamilyFragment extends Fragment {


   private MediaPlayer mp ;


    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Word> Family = new ArrayList<>();
        Family.add(new Word("Father" ,"Apa",R.drawable.family_father ,R.raw.family_father));
        Family.add(new Word("Mother" ,"Ata" ,R.drawable.family_mother ,R.raw.family_mother));
        Family.add(new Word("Son" ,"Angsi" ,R.drawable.family_son ,R.raw.family_son));
        Family.add(new Word("Daughter" ,"Tune" ,R.drawable.family_daughter ,R.raw.family_daughter));
        Family.add(new Word("Older Brother" ,"Taachi" ,R.drawable.family_older_brother ,R.raw.family_older_brother));
        Family.add(new Word("Younger Brother" ,"Chalitti" ,R.drawable.family_younger_brother ,R.raw.family_younger_brother));
        Family.add(new Word("Older Sister" ,"Tete" ,R.drawable.family_older_sister ,R.raw.family_older_sister));
        Family.add(new Word("Younger Sister" ,"Kolliti" ,R.drawable.family_younger_sister ,R.raw.family_younger_sister));
        Family.add(new Word("Grandmother" ,"Ama" ,R.drawable.family_grandmother ,R.raw.family_grandmother));
        Family.add(new Word("Grandfather" ,"Paapa" ,R.drawable.family_grandfather ,R.raw.family_grandfather));



        WordAdapter itemsAdapter = new WordAdapter(getActivity(), Family , R.color.category_family);


        ListView listView = (ListView) rootView.findViewById(R.id.List);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = Family.get(position);
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
