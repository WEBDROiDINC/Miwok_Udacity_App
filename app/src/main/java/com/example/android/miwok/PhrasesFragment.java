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
public class PhrasesFragment extends Fragment {

    private MediaPlayer mp;
    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<Word> Phrases = new ArrayList<>();
        Phrases.add(new Word("Where are you going?"
                ,"minto wuksus" ,R.raw.phrase_where_are_you_going));

        Phrases.add(new Word("What is your name?"
                ,"tinnә oyaase'nә" ,R.raw.phrase_what_is_your_name));

        Phrases.add(new Word("My name is..."
                ,"oyaaset" ,R.raw.phrase_my_name_is));

        Phrases.add(new Word("How are you feeling?"
                ,"michәksәs?" ,R.raw.phrase_how_are_you_feeling));

        Phrases.add(new Word("I’m feeling good."
                ,"kuchi achit" ,R.raw.phrase_im_feeling_good));

        Phrases.add(new Word("Are you coming?"
                ,"әәnәs'aa?" ,R.raw.phrase_are_you_coming));

        Phrases.add(new Word("Yes, I’m coming."
                ,"hәә’ әәnәm" ,R.raw.phrase_yes_im_coming));

        Phrases.add(new Word("I’m coming."
                ,"әәnәm" ,R.raw.phrase_im_coming));

        Phrases.add(new Word("Let’s go."
                ,"yoowutis" ,R.raw.phrase_lets_go));

        Phrases.add(new Word("Come here."
                ,"әnni'nem" ,R.raw.phrase_come_here));




        WordAdapter itemsAdapter = new WordAdapter(getActivity(), Phrases , R.color.category_phrases);

        //ListView listView = (ListView) findViewById(R.id.list);

        //listView.setAdapter(itemsAdapter);
        ListView listView = (ListView) rootView.findViewById(R.id.List);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = Phrases.get(position);
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

        return  rootView;
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
