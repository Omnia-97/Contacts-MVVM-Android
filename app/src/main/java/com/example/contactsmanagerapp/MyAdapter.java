package com.example.contactsmanagerapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Contacts> contactsArrayList;

    public MyAdapter(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding contactListItemBinding = ContactListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new MyViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Contacts currentContact = contactsArrayList.get(position);
        holder.contactListItemBinding.setContact(currentContact);

    }

    @Override
    public int getItemCount() {
        if(contactsArrayList != null){
            return contactsArrayList.size();

        }else {
            return 0;
        }
    }

    public void setContactsArrayList(ArrayList<Contacts> contactsArrayList) {
        this.contactsArrayList = contactsArrayList;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ContactListItemBinding contactListItemBinding;

        public MyViewHolder(@NonNull ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }
}
