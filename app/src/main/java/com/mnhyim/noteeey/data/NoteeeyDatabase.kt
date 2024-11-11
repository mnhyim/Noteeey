package com.mnhyim.noteeey.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.mnhyim.noteeey.data.dao.CategoryDao
import com.mnhyim.noteeey.data.entity.CategoryEntity
import com.mnhyim.noteeey.data.util.LocalDateTimeConverters

@Database(
    entities = [CategoryEntity::class],
    version = 1,
)
@TypeConverters(LocalDateTimeConverters::class)
abstract class NoteeeyDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}