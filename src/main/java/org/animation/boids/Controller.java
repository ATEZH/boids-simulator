package org.animation.boids;

import javafx.fxml.FXML;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import org.animation.boids.models.Boid;
import org.animation.boids.models.Simulation;
import org.animation.boids.views.BoidView;

public class Controller {
    @FXML
    Pane simulationPane;

    public Simulation simulation;

    @FXML
    public void initialize() {
        simulationPane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        System.out.println(simulationPane.getWidth() + " " + simulationPane.getHeight());
    }

    @FXML
    public void resume() {
        System.out.println("Start Simulation");
    }

    @FXML
    public void pause() {
        System.out.println("Pause Simulation");
    }

    @FXML
    public void reset() {
        System.out.println("Reset Simulation");
        simulationPane.getChildren().clear();
        create();
    }

    @FXML
    private void create() {
        System.out.println("Create Simulation");
        simulation = new Simulation(simulationPane, 30);
        for (Boid boid: simulation.getBoids()) {
            new BoidView(boid, simulationPane);
        }
    }
}