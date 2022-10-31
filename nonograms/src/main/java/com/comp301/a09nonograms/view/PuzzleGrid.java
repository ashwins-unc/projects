package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class PuzzleGrid implements FXComponent {

  private final Controller gameData;

  public PuzzleGrid(Controller che) {
    gameData = che;
  }

  @Override
  public Parent render() {

    VBox layout = new VBox();
    HBox above = new HBox();
    HBox solutoi = new HBox();
    HBox bottom = new HBox();
    HBox empty = new HBox();
    HBox midr = new HBox();
    HBox toprow = new HBox();
    HBox uppermid = new HBox();
    layout.getChildren().add(solutoi);
    layout.getChildren().add(above);
    layout.getChildren().add(toprow);
    BorderPane background = new BorderPane();
    GridPane nonograms = new GridPane();

    Button ebuttonemp = new Button();
    ebuttonemp.setPrefHeight(25); // 100
    ebuttonemp.setPrefWidth(25);

    layout.getChildren().add(uppermid);
    empty.getChildren().add(ebuttonemp);
    layout.getChildren().add(bottom);
    uppermid.getChildren().add(nonograms);
    layout.getChildren().add(midr);

    GridPane nonogrampane = new GridPane();

    Button but_tog;
    String blankspacing = "";
    for (int a = gameData.getClues().getHeight() - 1; a > -1; a--) {
      for (int J = 0; J < gameData.getClues().getRowClues(J).length; J++) {
        if (gameData.getClues().getRowClues(a)[J] == 0) {
          blankspacing = " ";
        } else {
          blankspacing = blankspacing + " " + gameData.getClues().getRowClues(a)[J];
        }
      }
      but_tog = new Button(blankspacing);
      but_tog.setStyle("-fx-background-color: faba02");
      but_tog.setPrefWidth(100);
      but_tog.setPrefHeight(50);
      nonogrampane.add(but_tog, 0, a, 1, 1);
      blankspacing = "";
    }
    HBox secondHbox = new HBox();
    Button donothung = new Button();
    donothung.setStyle("-fx-background-color: #bd37bd");
    donothung.setPrefWidth(100);
    donothung.setPrefHeight(100);
    secondHbox.getChildren().add(donothung);

    HBox thirdHbox = new HBox();
    for (int a = 0; a < gameData.getClues().getWidth(); a++) {
      for (int J = 0; J < gameData.getClues().getColClues(J).length; J++) {
        if (gameData.getClues().getColClues(a)[J] == 0) {
          blankspacing = " ";
        } else {
          blankspacing = blankspacing + "\n" + gameData.getClues().getColClues(a)[J];
        }
      }
      // HBox thirdHbox = new HBox();
      but_tog = new Button(blankspacing);
      but_tog.setStyle("-fx-background-color: #faba02 ");
      but_tog.setPrefWidth(50);
      but_tog.setPrefHeight(100);
      thirdHbox.getChildren().add(but_tog);
      blankspacing = "";
    }
    GridPane _M_i_d_d_lerid = new GridPane();
    Button t_o_midGrid_sg2;
    for (int a = 0; a < gameData.getClues().getHeight(); a++) {
      for (int J = 0; J < gameData.getClues().getWidth(); J++) {
        t_o_midGrid_sg2 = new Button();
        int f_J = J;
        int f_a = a;
        t_o_midGrid_sg2.setOnMouseClicked(
            new EventHandler<MouseEvent>() {
              @Override
              public void handle(MouseEvent mouseEvent) {
                // mouseEvent elim = new MouseEvent.
                int first = f_a;
                int last = f_J;
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                  gameData.toggleShaded(first, last);
                }
                if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
                  gameData.toggleEliminated(first, last);
                }
              }
            });
        if (gameData.isShaded(a, J)) {
          t_o_midGrid_sg2.setStyle("-fx-background-color: #000000"); //
        }
        if (gameData.isEliminated(a, J)) {
          t_o_midGrid_sg2.setText(" \u274C"); // x
        }
        t_o_midGrid_sg2.setPrefHeight(50);
        t_o_midGrid_sg2.setPrefWidth(50);
        _M_i_d_d_lerid.add(t_o_midGrid_sg2, J, a);
      }
    }
    uppermid.getChildren().add(nonogrampane);
    toprow.getChildren().add(secondHbox);
    toprow.getChildren().add(thirdHbox);
    uppermid.getChildren().add(_M_i_d_d_lerid);
    // uppermid.getChildren().add(nonogrampane);
    Button s_o_l_v_ed_or_not_checker =
        new Button("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCHECK ANSWER\t\t\t\t\t\t\t\t\t");
    Button solved_it_message = new Button("Let's go!!! Dababy. YOU SOLVED IT!!");
    Button wrong_message = new Button("YOU ARE VERY WRONG BRUH");
    s_o_l_v_ed_or_not_checker.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            // control.isSolved();
            if (gameData.isSolved()) {
              above.getChildren().add(solved_it_message);
            }
            if (!gameData.isSolved()) {
              above.getChildren().add(wrong_message);
              // topclues.getChildren().add(solved_it_message);
            }
          }
        });
    bottom.getChildren().add(s_o_l_v_ed_or_not_checker);
    /*for (int i = 0; i < 5; i++) {
      Button fill = new Button("I");
      topclues.getChildren().add(fill);
    }*/
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
    // space.setMouseTransparent(true);
    // nonograms.setMouseTransparent(true);
    // ackground.setMouseTransparent(true);
    background.setRight(space);
    // layout.setPadding(new Insets(100));
    return layout; // background
  }
}
