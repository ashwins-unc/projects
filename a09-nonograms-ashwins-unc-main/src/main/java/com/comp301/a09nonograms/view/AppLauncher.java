package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) {
    // TODO: Launch your GUI here

    Model app = new ModelImpl(new PuzzleLibrary().create());
    Controller link = new ControllerImpl(app);

    stage.setTitle("NONOGRAMS by Ashwin Yerramsetty");

    PuzzleGrid grid = new PuzzleGrid(link);
    PuzzleControls controls = new PuzzleControls(link);
    PuzzleStats inform = new PuzzleStats(link);
    PuzzleMessages message = new PuzzleMessages(link);

    BorderPane base = new BorderPane();
    base.setTop(inform.render());
    base.setCenter(grid.render());
    base.setBottom(controls.render());
    Scene scene = new Scene(base);
    stage.setScene(scene);
    stage.setTitle("NONOGRAMS by Ashwin Yerramsetty");

    stage.setScene(scene);
    stage.show();

    app.addObserver(
        (Model m) -> {
          BorderPane layout = new BorderPane();
          layout.setTop(inform.render());
          layout.setCenter(grid.render());
          layout.setBottom(controls.render());
          Scene background = new Scene(layout);
          stage.setScene(background);
          stage.sizeToScene();
          stage.show();
        });
  }
}
