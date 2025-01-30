module org.animation.boids {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;

    opens org.animation.boids to javafx.fxml;
    exports org.animation.boids;
}