package com.chinasoft.module1

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase

object DbManager {
    private const val dbName: String = "zroom"

    val db: ZRoomDB by lazy {
        Room.databaseBuilder(
            App.app.applicationContext, ZRoomDB::class.java, dbName
        ).allowMainThreadQueries()
            .addCallback(DbCreateCallback)
            .addMigrations()
            .build()
    }

    private object DbCreateCallback : RoomDatabase.Callback() {
        override fun onCreate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d("TAG", "first onCreate db version: " + db.version)
        }
    }
}