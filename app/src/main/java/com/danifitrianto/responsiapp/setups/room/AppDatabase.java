package com.danifitrianto.responsiapp.setups.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.danifitrianto.responsiapp.models.Users;
import com.danifitrianto.responsiapp.setups.room.dao.UserDao;

@Database(entities = {
        Users.class
}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
