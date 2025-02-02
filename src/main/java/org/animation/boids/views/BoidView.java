package org.animation.boids.views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import org.animation.boids.models.Boid;

public class BoidView {
    private Boid boid;
    private double boidLength = 25;
    private double boidWidth = 16;

    public BoidView(Boid boid, Pane world) {
        this.boid = boid;
        world.getChildren().add(createBoidView());
    }

    private Polygon createBoidView() {
        Polygon boidView = new Polygon();
        double[] p1 = {boid.position.getX(), boid.position.getY()};
        double[] p2 = {
                getBackCoordinates()[0]-(boidWidth/2)*boid.direction.getDy(),
                getBackCoordinates()[1]+(boidWidth/2)*boid.direction.getDx()
        };
        double[] p3 = {
                getBackCoordinates()[0]+(boidWidth/2)*boid.direction.getDy(),
                getBackCoordinates()[1]-(boidWidth/2)*boid.direction.getDx()
        };
        boidView.getPoints().addAll(p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]);
        boidView.setFill(Color.WHITE);
        return boidView;
    }

    public double[] getCenterCoordinates() {
        return new double[]{
                boid.position.getX()-(boidLength/2)*boid.direction.getDx(),
                boid.position.getY()-(boidLength/2)*boid.direction.getDy()
        };
    }

    public double[] getBackCoordinates() {
        return new double[]{
            boid.position.getX()-boidLength*boid.direction.getDx(),
            boid.position.getY()-boidLength*boid.direction.getDy()
        };
    }
}
