package com.mnhyim.noteeey.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.noteeey.data.dao.CategoryDao
import com.mnhyim.noteeey.data.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class],
    version = 1
)
abstract class NoteeeyDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}