package com.example.app1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User1> {
    private int resourceId;
    public UserAdapter(@NonNull Context context, int resource, List<User1> textViewResourceId) {
        super(context, resource, textViewResourceId);
        resourceId=resource;
        this.resourceId=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User1 user1=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(R.layout.item_layout,parent,false);
        TextView textView=view.findViewById(R.id.tv_name);
        textView.setText(user1.getName());
        return view;
    }
}
