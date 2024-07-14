package com.example.contactsmanagerapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private Repo repo;
    private LiveData<List<Contacts>> contacts;

    public MyViewModel(@NonNull Application application, Repo repo) {
        super(application);
        this.repo =  new Repo(application);
    }

    public LiveData<List<Contacts>> getAllContacts() {
        contacts = repo.getAllContacts();
        return contacts;
    }

    public void addContact(Contacts contacts) {
        repo.addContact(contacts);
    }

    public void deleteContact(Contacts contacts) {
        repo.deleteContact(contacts);
    }
}
