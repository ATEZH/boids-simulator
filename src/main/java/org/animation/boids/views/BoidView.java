package org.animation.boids.views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.animation.boids.models.Boid;

public class BoidView {
    public Boid boid;
    public Circle view;
    private double boidRadius = 12;

    public BoidView(Boid boid, Pane world) {
        this.boid = boid;
        view = createBoidView();
        world.getChildren().add(view);
    }

    private Circle createBoidView() {
        Circle boidView = new Circle();
        boidView.setCenterX(boid.position.getX());
        boidView.setCenterY(boid.position.getY());
        boidView.setRadius(boidRadius/2);
        boidView.setFill(Color.WHITE);
        return boidView;
    }
}
