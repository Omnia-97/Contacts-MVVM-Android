package com.example.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.contactsmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ContactDataBase contactDataBase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();
    private MyAdapter myAdapter;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers mainActivityClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityClickHandlers = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(mainActivityClickHandlers);
        RecyclerView recyclerView = activityMainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        contactDataBase = ContactDataBase.getInstance(this);
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Contacts c1 = new Contacts("John Doe"  , "123 Main Street");
        myViewModel.addContact(c1);
        myViewModel.getAllContacts().observe(this, new Observer<List<Contacts>>() {
            @Override
            public void onChanged(List<Contacts> contacts) {
                contactsArrayList.clear();
                for(Contacts c  : contacts){
                    Log.v("Tagy" ,c.toString());
                    contactsArrayList.add(c);
                }
                myAdapter.notifyDataSetChanged();
            }
        });
        myAdapter = new MyAdapter(contactsArrayList);
        recyclerView.setAdapter(myAdapter);

    }
}