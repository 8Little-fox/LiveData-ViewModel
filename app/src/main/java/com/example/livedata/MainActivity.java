package com.example.livedata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private TextView textView;
    private SeekBar seekBar;
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        button.setOnClickListener(this);
        myViewModel = new MyViewModel();
        //创建时关联Activity视图
        myViewModel = ViewModelProviders.of(this)
                .get(MyViewModel.class);
        //注册观察者
        //法一
        myViewModel.getData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                textView.setText(user.getName());
                textView.setText(user.getAge()+"");
            }
        });
        //法二 lamuda表达式
//        myViewModel.getData().observe(this,obj->seekBar.setProgress(Integer.parseInt(obj.getAge())));
        myViewModel.getData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                seekBar.setProgress(Integer.parseInt(user.getAge()));
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                User user=new User();
                user.setName("Sun");
                user.setAge("80");
                myViewModel.setUser(user);
        }
    }
}
