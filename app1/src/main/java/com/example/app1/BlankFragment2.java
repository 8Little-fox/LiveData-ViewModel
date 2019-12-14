package com.example.app1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {
private ListView listView;
private UserAdapter adapter;
private List<User1> list=new ArrayList<>();
private BlankViewModel mViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        listView=view.findViewById(R.id.lv);
        adapter=new UserAdapter(getActivity(),R.layout.item_layout,list);
        mViewModel=new BlankViewModel();
        mViewModel= ViewModelProviders.of(getActivity()).get(BlankViewModel.class);
        mViewModel.getData().observe(this, new Observer<User1>() {
            @Override
            public void onChanged(User1 user1) {
                //添加数据
               User1 user11=new User1();
               user11.setName(user1.getName());
               user11.setAge(user1.getAge());
               list.add(user11);
               listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                User1 user11=list.get(position);
                Toast.makeText(getContext(),user11.getName(),Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
