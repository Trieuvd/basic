package com.mor.trieuvd.basic.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mor.trieuvd.basic.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun followerDao(): FollowerDao

    companion object {
        var INSTANCE: AppDb? = null

        fun getAppDb(context: Context): AppDb? {
            if (INSTANCE == null) {
                synchronized(AppDb::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDb::class.java, "myDB").build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase() {
            INSTANCE = null
        }
    }
}