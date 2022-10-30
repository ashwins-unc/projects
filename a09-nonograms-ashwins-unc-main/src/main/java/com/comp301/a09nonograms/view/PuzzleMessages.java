package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class PuzzleMessages implements FXComponent {

  private final Controller gameData;

  public PuzzleMessages(Controller che) {
    gameData = che;
  }

  @Override
  public Parent render() {
    BorderPane background = new BorderPane();
    String instructions =
        "\tHow to Play"
            + "\n"
            + "\t1. Left click to shade a square"
            + "\n"
            + "\t2. Right click to eliminate a square"
            + "\n"
            + "\t3. Either left click or right click to make a blank"
            + "\n"
            + "\t4. If you want to try other puzzles, hit a button below :)"
            + "\n"
            + "\n";
    Pane space = new Pane(new Label(instructions));
    space.setMouseTransparent(true);
    // nonograms.setMouseTransparent(true);
    background.setMouseTransparent(true);
    background.setRight(space);
    return background;
  }
}
