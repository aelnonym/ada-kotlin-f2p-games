package me.joaovictorsl.adafreetoplaygames

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import me.joaovictorsl.adafreetoplaygames.ui.gamelist.GameListActivity
import me.joaovictorsl.adafreetoplaygames.ui.recyclerview.adapter.GameAdapter
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class GameListActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(GameListActivity::class.java)

    @Test
    fun scrollToAndClickItem() {
        ActivityScenario.launch(GameListActivity::class.java).use { scenario ->
            // Delay for RecyclerView to populate with data
            Thread.sleep(2000)

            // Replace `desiredPosition` with the index of the desired cell you want to scroll to and click
            val desiredPosition = 10

            // Scroll to the desired position
            Espresso.onView(ViewMatchers.withId(R.id.game_list_recycler_view))
                .perform(
                    RecyclerViewActions.scrollToPosition<GameAdapter.GameViewHolder>(desiredPosition)
                )

            // Click on the desired cell
            Espresso.onView(ViewMatchers.withId(R.id.game_list_recycler_view))
                .perform(
                    RecyclerViewActions.actionOnItemAtPosition<GameAdapter.GameViewHolder>(
                        desiredPosition,
                        ViewActions.click()
                    )
                )
        }
    }
}
