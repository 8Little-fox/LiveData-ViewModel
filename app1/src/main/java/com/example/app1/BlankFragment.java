package com.example.app1;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class BlankFragment extends Fragment implements View.OnClickListener {
    private EditText editText1;
    private EditText editText2;
    private Button button;
    private BlankViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blank_fragment, container, false);
        editText1 = view.findViewById(R.id.name);
        editText2 = view.findViewById(R.id.age);
        button=view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel=new BlankViewModel();
        mViewModel=ViewModelProviders.of(getActivity()).get(BlankViewModel.class);
        mViewModel.getData().observe(this, new Observer<User1>() {
            @Override
            public void onChanged(User1 user1) {
                editText1.setText(user1.getName());
                editText2.setText(user1.getAge());
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                User1 user1 = new User1();
                user1.setName(editText1.getText().toString());
                user1.setAge(editText2.getText().toString());
                mViewModel.setUser(user1);
        }
    }
}
