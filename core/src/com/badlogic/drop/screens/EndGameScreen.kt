package com.badlogic.drop.screens

import com.badlogic.drop.Drop
import com.badlogic.drop.tools.PreferencesTool
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.ScreenUtils

class EndGameScreen(private val game: Drop, private val score: Int) : Screen {
    private var camera: OrthographicCamera = OrthographicCamera()
    private val highScore = PreferencesTool.getHighScore()

    init {
        camera.setToOrtho(false, 800f, 480f)
        if (score > highScore) PreferencesTool.saveHighScore(score)
    }

    override fun show() {
    }

    override fun render(delta: Float) {
        ScreenUtils.clear(0f, 0f, 0.2f, 1f)
        camera.update()
        game.batch!!.projectionMatrix = camera.combined
        game.batch!!.begin()
        game.font!!.draw(game.batch, "Game Over!", 100f, 200f)
        game.font!!.draw(game.batch, "Score: $score", 100f, 150f)
        if(score>highScore)
            game.font!!.draw(game.batch, "Congratulations! New High Score: $score", 100f, 100f)
        else
            game.font!!.draw(game.batch, "Current High Score: $highScore", 100f, 100f)
        game.font!!.draw(game.batch, "Tap anywhere to start again...", 100f, 50f)

        game.batch!!.end()
        if (Gdx.input.isTouched) {
            game.screen = GameScreen(game)
            dispose()
        }
    }

    override fun resize(width: Int, height: Int) {
    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
    }
}