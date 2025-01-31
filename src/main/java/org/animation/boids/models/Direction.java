package org.animation.boids.models;

public class Direction {
    private double dx;
    private double dy;
    static public double speed = 1;

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

    public void updateDirection(Simulation simulation) {
        for (Boid boid: simulation.getBoids()) {
            System.out.println("Boid direction updated");
        }
    }
}
