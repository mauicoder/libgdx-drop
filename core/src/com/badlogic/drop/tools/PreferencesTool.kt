package com.badlogic.drop.tools

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Preferences


private const val PREFS_NAME = "drop.prefs"
private const val HIGH_SCORE_PREF_NAME = "high.score"

object PreferencesTool {
    fun getHighScore(): Int {
        val prefs: Preferences = Gdx.app.getPreferences(PREFS_NAME)
        return  prefs.getInteger(HIGH_SCORE_PREF_NAME, 0)
    }

    fun saveHighScore(score: Int) {
        val prefs: Preferences = Gdx.app.getPreferences(PREFS_NAME)
        prefs.putInteger(HIGH_SCORE_PREF_NAME, score)
        prefs.flush()
    }
}