package com.badlogic.drop.screens

import com.badlogic.drop.Drop
import com.badlogic.drop.tools.PreferencesTool
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport

class MainMenuScreen(private val game: Drop) : Screen {
    private val highScore = PreferencesTool.getHighScore()
    private val camera: OrthographicCamera = OrthographicCamera()
    private var viewPort : Viewport = FitViewport(game.V_WIDTH, game.V_HEIGHT , camera)

    init {
        viewPort.apply(true)
    }

    override fun show() {}
    override fun render(delta: Float) {
        camera.update()

        ScreenUtils.clear(0f, 0f, 0.2f, 1f)
        game.batch!!.projectionMatrix = camera.combined
        game.batch!!.begin()
        game.font!!.draw(game.batch, "Welcome to Drop!!! ", 0f, 200f)
        game.font!!.draw(game.batch, "Tap anywhere to begin!", 0f, 150f)
        game.font!!.draw(game.batch, "Current High Score: $highScore", 0f, 100f)
        game.batch!!.end()
        if (Gdx.input.isTouched) {
            //Gdx.app.log("MyTag", "Creating GameScreen")
            game.screen = GameScreen(game)
            dispose()
        }
    }

    override fun resize(width: Int, height: Int) = viewPort.update(width, height, true)

    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun dispose() {}
}