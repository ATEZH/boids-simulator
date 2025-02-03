package org.animation.boids.models;

import javafx.scene.layout.Pane;

public class Direction {
    private double dx;
    private double dy;
    static public double speed = 1;
    static private double absoluteMaxDx = 1;
    static private double absoluteMaxDy = 1;
    static public double fieldOfView = 120;
    private double wallAvoidanceFactor = 0.02*speed;
    private double wallAvoidanceAlt = 0.003*speed;

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
        if (thisBoid.position.getX() < fieldOfView) {
            // (fieldOfView-thisBoid.position.getX())/fieldOfView -> distance from wall, ranges from 0 to 1
            dx += wallAvoidanceFactor*(fieldOfView-thisBoid.position.getX())/fieldOfView;
            if (dy > 0) dy += wallAvoidanceAlt; else dy -= wallAvoidanceAlt;
        } else if (thisBoid.position.getX() > world.getWidth() - fieldOfView) {
            // (thisBoid.position.getX() - world.getWidth() + fieldOfView)/fieldOfView -> distance from wall, ranges from 0 to 1
            dx -= wallAvoidanceFactor*(thisBoid.position.getX() - world.getWidth() + fieldOfView)/fieldOfView;
            if (dy > 0) dy += wallAvoidanceAlt; else dy -= wallAvoidanceAlt;
        }
        if (thisBoid.position.getY() < fieldOfView) {
            dy += wallAvoidanceFactor*(fieldOfView-thisBoid.position.getY())/fieldOfView;
            if (dx > 0) dx += wallAvoidanceAlt; else dx -= wallAvoidanceAlt;
        } else if (thisBoid.position.getY() > world.getHeight() - fieldOfView) {
            dy -= wallAvoidanceFactor*(thisBoid.position.getY() - world.getHeight() + fieldOfView)/fieldOfView;
            if (dx > 0) dx += wallAvoidanceAlt; else dx -= wallAvoidanceAlt;
        }
        if (Math.abs(dx) > absoluteMaxDx) dx = absoluteMaxDx*Math.signum(dx);
        if (Math.abs(dy) > absoluteMaxDy) dy = absoluteMaxDy*Math.signum(dy);
    }

    private void alignment() {

    }

    private void cohesion() {

    }

    private void separation() {

    }
}
