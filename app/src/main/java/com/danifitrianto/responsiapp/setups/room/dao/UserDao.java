package com.danifitrianto.responsiapp.setups.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.danifitrianto.responsiapp.models.Users;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Users WHERE email = :email AND password LIKE :password")
    Users checkCredetials(String email, String password);

    @Insert
    void insert(Users models);
}
