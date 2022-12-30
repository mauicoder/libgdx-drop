package com.badlogic.drop

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.drop.screens.MainMenuScreen
import com.badlogic.gdx.Gdx

class Drop : Game() {
    @JvmField
	var batch: SpriteBatch? = null
    @JvmField
	var font: BitmapFont? = null
    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont() // use libGDX's default Arial font
        setScreen(MainMenuScreen(this))
    }

    override fun dispose() {
        Gdx.app.log("MyTag", "disposing Game")
        batch!!.dispose()
        font!!.dispose()
        screen?.dispose().also {  Gdx.app.log("MyTag", "disposing the screen")}
    }
}