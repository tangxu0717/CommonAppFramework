package com.chinasoft.module1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class ZRoomDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}