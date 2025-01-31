package org.animation.boids.models;

public class Direction {
    private double dx;
    private double dy;
    static public double speed = 1;

    Direction() {
        this.dy = Math.sin(Math.random()*2*Math.PI)*speed;
        this.dx = Math.cos(Math.random()*2*Math.PI)*speed;
    }

    public double getDx() {
       return dx;
    }

    public double getDy() {
        return dy;
    }

    public void updateDirection(Simulation simulation) {
        for (Boid boid: simulation.getBoids()) {
            System.out.println("Hi");
        }
    }
}
