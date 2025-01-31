package org.animation.boids.models;

import javafx.scene.layout.Pane;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position(Pane world) {
        this(50 + Math.random() * (world.getWidth() - 100),
                50 + Math.random() * (world.getHeight() - 100));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(Direction direction) {
        x += direction.getDx();
        y += direction.getDy();
    }
}
