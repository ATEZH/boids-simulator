package org.animation.boids;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import org.animation.boids.models.Boid;
import org.animation.boids.models.Simulation;
import org.animation.boids.views.BoidView;

public class Controller {
    public Simulation simulation;

    AnimationTimer timer;

    boolean running = false;

    @FXML
    Pane simulationPane;

    @FXML
    Slider alignmentSlider;

    @FXML
    Slider cohesionSlider;

    @FXML
    Slider separationSlider;

    @FXML
    public void initialize() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                step();
            }
        };
        simulationPane.setBackground(new Background(new BackgroundFill(Color.MIDNIGHTBLUE, null, null)));
    }

    @FXML
    public void step() {
//        System.out.println("Step Simulation");
    }

    @FXML
    public void resume() {
        System.out.println("Resume Simulation");
        if (!running) {
            running = true;
            timer.start();
        }
    }

    @FXML
    public void pause() {
        System.out.println("Pause Simulation");
        if (running) {
            running = false;
            timer.stop();
        }
    }

    private void clear() {
        System.out.println("Clear Simulation");
        simulationPane.getChildren().clear();
    }

    @FXML
    public void setup() {
        System.out.println("Setup Simulation");
        System.out.print(" - ");
        clear();
        System.out.print(" - ");
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