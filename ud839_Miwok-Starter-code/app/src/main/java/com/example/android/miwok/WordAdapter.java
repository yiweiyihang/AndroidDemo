package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 32618 on 2016/12/5.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of Word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused,otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false);
        }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);
        TextView mMiwokView = (TextView)listItemView.findViewById(R.id.miwok_text_view);
        mMiwokView.setText(currentWord.getMiwokTran());

        TextView mEngView = (TextView)listItemView.findViewById(R.id.eng_text_view);
        mEngView.setText(currentWord.getEngTran());
        ImageView mImageView = (ImageView)listItemView.findViewById(R.id.word_image_view);
        if(currentWord.hasImage()){
            //Set the imageView Resource
            mImageView.setImageResource(currentWord.getmImageViewId());
            mImageView.setVisibility(View.VISIBLE);
        } else{
            // Otherwise hide imageView
            mImageView.setVisibility(View.GONE);
        }

        return listItemView;

    }
}
