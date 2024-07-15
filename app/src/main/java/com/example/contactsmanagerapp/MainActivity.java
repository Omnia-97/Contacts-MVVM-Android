package com.example.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contactsmanagerapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

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
        myAdapter = new MyAdapter(contactsArrayList);
        contactDataBase = ContactDataBase.getInstance(this);
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        Contacts c1 = new Contacts(1 , "John Doe"  , "123 Main Street");
        Contacts c2 = new Contacts(2 , "Jane Doe" ,"456 Oak Street");
        Contacts c3 = new Contacts(3 , "Bob Smith" , "789 Pine Street");
        myViewModel.addContact(c1);
        myViewModel.addContact(c2);
        myViewModel.addContact(c3);


       /* myViewModel.getAllContacts().observe(this, contacts -> {
            myAdapter.setContactsArrayList(contacts);
            recyclerView.setAdapter(myAdapter);
        });*/

    }
}