package org.animation.boids.models;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Boid> boids;
    public int populationSize;
    public Pane world;

    public Simulation(Pane world, int populationSize) {
        this.world = world;
        this.populationSize = populationSize;
        boids = new ArrayList<>();
        createBoids();
    }

    public ArrayList<Boid> getBoids() {
        return boids;
    }

    public void createBoids() {
        for (int i = 0; i < populationSize; ++i) {
            Boid boid = new Boid(new Direction(), new Position(world));
            boids.add(boid);
        }
    }

    public void resetBoids() {
        boids.clear();
        createBoids();
    }
}
