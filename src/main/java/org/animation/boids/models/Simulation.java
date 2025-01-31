package org.animation.boids.models;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Simulation {
    public ArrayList<Boid> boids;
    public int populationSize;

    Simulation(Pane world, int populationSize) {
        this.populationSize = populationSize;
        boids = new ArrayList<>();

        for (int i = 0; i < populationSize; ++i) {
            Boid boid = new Boid(new Direction(), new Position(world));
            boids.add(boid);
        }
    }

    public ArrayList<Boid> getBoids() {
        return boids;
    }
}
