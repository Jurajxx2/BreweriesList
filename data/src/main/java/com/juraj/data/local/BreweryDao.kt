package com.juraj.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.juraj.model.model.local.BreweryLocal

@Dao
interface BreweryDao {

    @Query("SELECT * FROM breweries")
    suspend fun allBreweries(): List<BreweryLocal>

    @Query("SELECT * FROM breweries where id = :id")
    suspend fun getBreweryById(id: String): BreweryLocal

    @Query("DELETE FROM breweries")
    fun deleteAllBreweries()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBrewery(brewery: BreweryLocal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBrewery(breweries: List<BreweryLocal>)

    @Delete
    fun deleteBrewery(brewery: BreweryLocal)

    @Update
    fun updateBrewery(brewery: BreweryLocal)
}