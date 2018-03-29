package com.example.amir.chat;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.client.Query;


public class ChatListAdapter extends FirebaseListAdapter<Chat> {

    private String mUsername;
    private int[] colors = new int[] { 0x30FF0000, 0x300000FF };

    public ChatListAdapter(Query ref, Activity activity, int layout, String mUsername) {
        super(ref, Chat.class, layout, activity);
        this.mUsername = mUsername;
    }


    @Override
    protected void populateView(View view, Chat chat) {
        String author = chat.getAuthor();
        TextView authorText = (TextView) view.findViewById(R.id.A_Mess);
        TextView messText = (TextView) view.findViewById(R.id.Mess);
        authorText.setText(author);
        messText.setText(chat.getMessage());
        if (author != null && author.equals(mUsername)) {
            authorText.setText("You");
            messText.setTextColor(Color.GREEN);
            messText.setTextSize(18);

        } else {
            messText.setTextColor(Color.BLACK);
            messText.setTextSize(22);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        int colorPos = position % colors.length;
        view.setBackgroundColor(colors[colorPos]);
        return view;
    }
}