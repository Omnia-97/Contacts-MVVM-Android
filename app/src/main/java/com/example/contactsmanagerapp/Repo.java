package com.example.contactsmanagerapp;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repo {
    private final ContactsDAO contactsDAO;
    ExecutorService executorService;
    Handler handler;

    public Repo(Application application) {
        ContactDataBase contactDataBase = ContactDataBase.getInstance(application);
        this.contactsDAO = contactDataBase.getContactsDAO();
        executorService= Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }
    public void addContact (Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.insert(contacts);

            }
        });

    }
    public void deleteContact(Contacts contacts){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                contactsDAO.delete(contacts);

            }
        });

    }
    public LiveData<List<Contacts>> getAllContacts(){
        return contactsDAO.getAllContacts();
    }
}
