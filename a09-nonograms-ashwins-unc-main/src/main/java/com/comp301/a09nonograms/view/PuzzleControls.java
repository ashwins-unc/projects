package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PuzzleControls implements FXComponent {

  private final Controller gameData;

  public PuzzleControls(Controller conmod) {
    gameData = conmod;
  }

  @Override
  public Parent render() {
    Button previous = new Button("|| Previous Puzzle ||");
    Button next = new Button("|| Next Puzzle ||");
    Button clear = new Button("|| Clear Puzzle ||");
    Button _r_a_n_d_o_m_button = new Button("|| Random Puzzle ||");
    Font spice = Font.font("Courier New", FontWeight.BOLD, 12);
    previous.setFont(spice);
    clear.setFont(spice);
    _r_a_n_d_o_m_button.setFont(spice);
    next.setFont(spice);
    previous.setStyle("-fx-text-fill: white;-fx-background-color: #000000");
    next.setStyle("-fx-text-fill: white;-fx-background-color: #000000");
    _r_a_n_d_o_m_button.setStyle("-fx-text-fill: white;-fx-background-color: #000000");
    clear.setStyle("-fx-text-fill: white;-fx-background-color: #000000");
    _r_a_n_d_o_m_button.setOnAction(actionEvent -> gameData.randPuzzle());
    previous.setOnAction(actionEvent -> gameData.prevPuzzle());
    clear.setOnAction(actionEvent -> gameData.clearBoard());
    next.setOnAction(actionEvent -> gameData.nextPuzzle());
    return new HBox(previous, next, clear, _r_a_n_d_o_m_button);
  }
}
