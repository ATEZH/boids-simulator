package org.animation.boids.models;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Direction {
    private double dx;
    private double dy;
    static public double speed = 1;
    static private double absoluteMaxDx = 2;
    static private double absoluteMaxDy = 2;
    static public double fieldOfView = 70;
    private double wallAvoidanceFactor = 0.06*speed;
    private double wallAvoidanceAlt = 0.01*speed;

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
        alignment(thisBoid, simulation.getBoids(), fieldOfView);
        separation(thisBoid, simulation.getBoids(), fieldOfView);
        cohesion(thisBoid, simulation.getBoids(), fieldOfView);
        avoidWall(thisBoid, world, fieldOfView*2.5);
    }

    private void avoidWall(Boid thisBoid, Pane world, double fieldOfView) {
        if (thisBoid.position.getX() < fieldOfView) {
            dx += wallAvoidanceFactor*(fieldOfView-thisBoid.position.getX())/fieldOfView;
            if (dy > 0) dy += wallAvoidanceAlt; else dy -= wallAvoidanceAlt;
        } else if (thisBoid.position.getX() > world.getWidth() - fieldOfView) {
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

    private void alignment(Boid thisBoid, ArrayList<Boid> boids, double fieldOfView) {
        int localBoids = 0;
        double totalDx = 0;
        double totalDy = 0;
        for (Boid boid: boids) {
            double distance = measureDistance(thisBoid.position.getX(), boid.position.getX(),
                    thisBoid.position.getY(), boid.position.getY());
            if (distance < fieldOfView && distance > fieldOfView/3 && boid != thisBoid) {
                ++localBoids;
                totalDx += boid.direction.getDx();
                totalDy += boid.direction.getDy();
            }
        }
        if (localBoids == 0) return;
        dx += 0.003*(totalDx/localBoids);
        dy += 0.003*(totalDy/localBoids);
    }

    private void cohesion(Boid thisBoid, ArrayList<Boid> boids, double fieldOfView) {
        int localBoids = 0;
        double totalX = 0;
        double totalY = 0;
        for (Boid boid: boids) {
            double distance = measureDistance(thisBoid.position.getX(), boid.position.getX(),
                    thisBoid.position.getY(), boid.position.getY());
            if (distance < fieldOfView && distance > fieldOfView/2 && boid != thisBoid) {
                ++localBoids;
                totalX += boid.position.getX();
                totalY += boid.position.getY();
            }
        }
        if (localBoids == 0) return;
        double centerX = totalX/localBoids;
        double centerY = totalY/localBoids;
        dx += 0.001*(centerX - thisBoid.position.getX());
        dy += 0.001*(centerY - thisBoid.position.getY());
    }

    private void separation(Boid thisBoid, ArrayList<Boid> boids, double fieldOfView) {
        double totalDx = 0;
        double totalDy = 0;
        for (Boid boid: boids) {
            double distance = measureDistance(thisBoid.position.getX(), boid.position.getX(),
                    thisBoid.position.getY(), boid.position.getY());
            if (distance < fieldOfView/2 && boid != thisBoid) {
                totalDx += thisBoid.position.getX() - boid.position.getX();
                totalDy += thisBoid.position.getY() - boid.position.getY();
            }
        }
        dx += 0.001*totalDx;
        dy += 0.001*totalDy;
    }

    private double measureDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
