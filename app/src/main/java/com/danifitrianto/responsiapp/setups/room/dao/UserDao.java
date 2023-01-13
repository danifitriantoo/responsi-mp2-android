package com.danifitrianto.responsiapp.setups.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.danifitrianto.responsiapp.models.Users;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Users WHERE email = :email AND password LIKE :password")
    Users checkCredetials(String email, String password);

    @Query("UPDATE Users SET email=:email, password=:password, address=:address,name=:name WHERE user_id=:id")
    void updateData(String email, String password, String address, String name, int id);

    @Insert
    void insert(Users models);
}
