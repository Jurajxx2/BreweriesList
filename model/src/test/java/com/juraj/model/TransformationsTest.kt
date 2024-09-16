package com.juraj.model

import android.os.Build
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.juraj.model.model.Brewery
import com.juraj.model.model.transformations.brewery.BreweryTransformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.Q])
@SmallTest
class TransformationsTest {

    private val brewery = Brewery(
        id = "test1",
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

    @Test
    fun breweriesTransformationsFromLocal_returnsTrue() {

    }

    @Test
    fun breweriesTransformationsFromRemote_returnsTrue() {

    }
}