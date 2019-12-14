package com.example.app1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {
    private List<User1> list=new ArrayList<>();
    private BlankViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        TextView textView=view.findViewById(R.id.tv1);
        TextView textView1=view.findViewById(R.id.tv2);
        viewModel=new BlankViewModel();
        viewModel=ViewModelProviders.of(getActivity()).get(BlankViewModel.class);
        viewModel.getData().observe(getActivity(), new Observer<User1>() {
            @Override
            public void onChanged(User1 user1) {
                User1 user11=new User1();
                user11.setName(user11.getName());
                user11.setAge(user11.getAge());
                textView.setText(user1.getName());
                textView1.setText(user1.getAge());
                list.add(user11);
            }
        });
        return view;
    }
}
