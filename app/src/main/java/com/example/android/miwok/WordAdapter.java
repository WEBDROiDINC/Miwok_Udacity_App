package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by Blood_seeker on 11/9/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorRI ;

    private MediaPlayer MP ;

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> objects , int color) {
        super(context, 0,objects);
        this.colorRI = color;

    }

    @NonNull

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout, parent, false);
        }



        Word currentWord = getItem(position);



        ImageView im = (ImageView) listItemView.findViewById(R.id.pic);

        if(currentWord.getIm()!=0)
        {
            im.setImageResource(currentWord.getIm());
            im.setVisibility(View.VISIBLE);

        }
        
        else
        {
            im.setVisibility(View.GONE);
        }

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok);

        miwokTextView.setText(currentWord.getMiwok());



        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english);

        englishTextView.setText(currentWord.getEnglish());


        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.LinearLayout);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), colorRI);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }


}
