package com.juraj.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juraj.model.model.local.BreweryLocal

@Database(entities = [(BreweryLocal::class)], version = 1)
abstract class BreweryDatabase : RoomDatabase() {

    abstract fun breweryDao(): BreweryDao

}