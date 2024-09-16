package com.juraj.beerlist

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShowBreweryDetailUiTest {

    @Test
    fun showBreweryDetailUiTest() {
        ActivityScenario.launch(MainActivity::class.java)
        Thread.sleep(2000)
        onView(withId(com.juraj.breweries.R.id.breweries_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        Thread.sleep(2000)
        onView(withId(com.juraj.breweries.R.id.brewery_name)).check(matches(isDisplayed()))
    }
}