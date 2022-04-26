package com.example.android2hm1.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.android2hm1.data.model.TaskModel;

@Database(entities = {TaskModel.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
