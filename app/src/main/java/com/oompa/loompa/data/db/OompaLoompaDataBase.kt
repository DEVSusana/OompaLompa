package com.oompa.loompa.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.oompa.loompa.data.model.OompaDetail

@Database(
    entities = [OompaDetail::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class OompaLoompaDataBase: RoomDatabase() {
    abstract fun getOompaLoompaDAO(): OompaLoompaDAO
}