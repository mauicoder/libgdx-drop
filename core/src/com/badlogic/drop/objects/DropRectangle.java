package com.badlogic.drop.objects;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Pool;

public class DropRectangle implements Pool.Poolable {

    private final Rectangle rectangle = new Rectangle();
    /**
     * Initialize the bullet. Call this method after getting a DropRectangle from the pool.
     */
    public void init() {
        rectangle.x = MathUtils.random(0, 800 - 64);
        rectangle.y = 480;
        rectangle.width = 64;
        rectangle.height = 64;
    }

    public float getX() {
        return rectangle.x;
    }

    public float getY() {
        return rectangle.y;
    }

    @Override
    public void reset() {

    }

    public void update(float delta) {
        rectangle.y -= 200 * delta;
    }

    public boolean overlaps(Rectangle bucket) {
        return rectangle.overlaps(bucket);
    }
}
