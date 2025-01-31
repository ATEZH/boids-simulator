package org.animation.boids.views;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import org.animation.boids.models.Boid;

public class BoidView {
    private Boid boid;

    public BoidView(Boid boid, Pane world) {
        this.boid = boid;
        world.getChildren().add(createBoidView());
    }

    private Polygon createBoidView() {
        Polygon boidView = new Polygon();
        double[] p1 = {boid.position.getX(), boid.position.getY()};
        double[] p2 = {
                boid.position.getX()-40*boid.direction.getDx()-10*boid.direction.getDy(),
                boid.position.getY()-40*boid.direction.getDy()+10*boid.direction.getDx()
        };
        double[] p3 = {
                boid.position.getX()-40*boid.direction.getDx()+10*boid.direction.getDy(),
                boid.position.getY()-40*boid.direction.getDy()-10*boid.direction.getDx()
        };
        boidView.getPoints().addAll(new Double[]{
            p1[0], p1[1], p2[0], p2[1], p3[0], p3[1]
        });
        return boidView;
    }
}
