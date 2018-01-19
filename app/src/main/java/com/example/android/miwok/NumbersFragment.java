package com.example.android.miwok;



import android.content.Context;
import android.media.AudioManager;
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
public class NumbersFragment extends Fragment {


    private MediaPlayer mp;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    public NumbersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus

        final ArrayList<Word> numbers = new ArrayList<>();
        numbers.add(new Word("one" ,"lutti" ,R.drawable.number_one ,R.raw.number_one));
        numbers.add(new Word("two" ,"otiiko",R.drawable.number_two ,R.raw.number_two));
        numbers.add(new Word("three" ,"tolookosu",R.drawable.number_three ,R.raw.number_three));
        numbers.add(new Word("four" ,"oyyisa",R.drawable.number_four ,R.raw.number_four));
        numbers.add(new Word("five" ,"massokka",R.drawable.number_five  ,R.raw.number_five));
        numbers.add(new Word("six" ,"temmokka",R.drawable.number_six ,R.raw.number_six));
        numbers.add(new Word("seven" ,"kenekaku",R.drawable.number_seven ,R.raw.number_seven));
        numbers.add(new Word("eight" ,"kawinta",R.drawable.number_eight ,R.raw.number_eight));
        numbers.add(new Word("nine" ,"wo'e",R.drawable.number_nine ,R.raw.number_nine));
        numbers.add(new Word("ten" ,"na'aacha",R.drawable.number_ten ,R.raw.number_ten));



        WordAdapter itemsAdapter = new WordAdapter(getActivity(),  numbers ,R.color.category_numbers);

        //ListView listView = (ListView) findViewById(R.id.list);

        //listView.setAdapter(itemsAdapter);
        ListView listView = (ListView) rootView.findViewById(R.id.List);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                Word word = numbers.get(position);

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

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
