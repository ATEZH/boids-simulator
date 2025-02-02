package org.animation.boids.models;

import javafx.scene.layout.Pane;

public class Direction {
    private double dx;
    private double dy;
    static public double speed = 1;
    static public double wallAvoidance = 0.01*speed;
    static public double wallAvoidanceAlt = 0.005*speed;

    Direction() {
        double direction = Math.random()*2*Math.PI;
        this.dy = Math.sin(direction)*speed;
        this.dx = Math.cos(direction)*speed;
    }

    public double getDx() {
       return dx;
    }

    public double getDy() {
        return dy;
    }

    public void updateDirection(Boid thisBoid, Simulation simulation, Pane world) {
        avoidWall(thisBoid, world);
    }

    private void avoidWall(Boid thisBoid, Pane world) {
        if (thisBoid.position.getX() < 40) {
            dx += wallAvoidance*(40-thisBoid.position.getX())/40;
            if (dy > 0) dy += wallAvoidanceAlt;
            else dy -= wallAvoidanceAlt;
        } else if (thisBoid.position.getX() > world.getWidth() - 40) {
            dx -= wallAvoidance*(thisBoid.position.getX() - world.getWidth() + 40)/40;;
            if (dy > 0) dy += wallAvoidanceAlt;
            else dy -= wallAvoidanceAlt;
        }
        if (thisBoid.position.getY() < 40) {
            dy += wallAvoidance*(40-thisBoid.position.getY())/40;
            if (dx > 0) dx += wallAvoidanceAlt;
            else dx -= wallAvoidanceAlt;
        } else if (thisBoid.position.getY() > world.getHeight() - 40) {
            dy -= wallAvoidance*(thisBoid.position.getY() - world.getHeight() + 40)/40;;
            if (dx > 0) dx += wallAvoidanceAlt;
            else dx -= wallAvoidanceAlt;
        }
    }

    private void alignment() {

    }

    private void cohesion() {

    }

    private void separation() {

    }
}
