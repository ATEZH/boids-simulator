package org.animation.boids.models;

public class Boid {
    public Direction direction;
    public Position position;

    public Boid(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }
}
