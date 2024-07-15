package com.example.contactsmanagerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contactsmanagerapp.databinding.ActivityAddNewContactBinding;
import com.example.contactsmanagerapp.databinding.ActivityMainBinding;

public class AddNewContactActivity extends AppCompatActivity {
    private ActivityAddNewContactBinding activityAddNewContactBinding;
    private AddNewContactClickHandler addNewContactClickHandler;
    private Contacts contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        contacts = new Contacts();
        activityAddNewContactBinding = DataBindingUtil.setContentView(this , R.layout.activity_add_new_contact);

        MyViewModel myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);
      addNewContactClickHandler = new AddNewContactClickHandler(contacts, this ,myViewModel );
        activityAddNewContactBinding.setContact(contacts);
        activityAddNewContactBinding.setClickHandler(addNewContactClickHandler);
    }
}