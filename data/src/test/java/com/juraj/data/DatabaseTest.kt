package com.juraj.data

import android.os.Build.VERSION_CODES.Q
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.juraj.data.local.BreweryDao
import com.juraj.data.local.BreweryDatabase
import com.juraj.model.model.Brewery
import com.juraj.model.model.transformations.brewery.BreweryTransformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Q])
@SmallTest
class DatabaseTest {

    private lateinit var database: BreweryDatabase
    private lateinit var breweryDao: BreweryDao

    private val breweries = (0..10).map {
        Brewery(
            id = "test${it}",
            name = "Mary",
            breweryType = "test",
            street = "test",
            city = "test",
            state = "test",
            postalCode = "test",
            country = "test",
            longitude = "test",
            latitude = "test",
            phone = "test",
            websiteURL = "test",
            updatedAt = "test",
            createdAt = "test"
        )
    }

    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            BreweryDatabase::class.java
        ).allowMainThreadQueries().build()

        breweryDao = database.breweryDao()
    }

    @Test
    fun insertBreweries_returnsTrue() = runBlocking {

        breweryDao.insertBrewery(breweries.map {BreweryTransformations.toLocal(it)})

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            val result = breweryDao.allBreweries()
            assertThat("All breweries were saved: ", result.size == breweries.size)
            latch.countDown()
        }
        latch.await()
        job.cancelAndJoin()
    }

    @After
    fun closeDatabase() {
        database.close()
    }
}