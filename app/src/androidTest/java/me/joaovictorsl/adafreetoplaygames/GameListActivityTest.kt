package me.joaovictorsl.adafreetoplaygames

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import me.joaovictorsl.adafreetoplaygames.ui.gamelist.GameListActivity
import me.joaovictorsl.adafreetoplaygames.ui.recyclerview.adapter.GameAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameListActivityTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(GameListActivity::class.java)

    @Test
    fun testScrollAndClickRecyclerViewItem() {
        // Espera API
        Thread.sleep(3000)

        // Realiza a rolagem até a posição desejada
        onView(withId(R.id.game_list_recycler_view))
            .perform(RecyclerViewActions.scrollToPosition<GameAdapter.GameViewHolder>(10))

        Thread.sleep(3000)

        // Clica no item na posição desejada
        onView(withId(R.id.game_list_recycler_view))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<GameAdapter.GameViewHolder>(
                    10,
                    click(),
                ),
            )

        Thread.sleep(3000)
    }
}
