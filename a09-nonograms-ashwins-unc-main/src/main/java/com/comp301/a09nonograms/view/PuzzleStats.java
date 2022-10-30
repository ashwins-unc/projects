package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PuzzleStats implements FXComponent {
  private final Controller gameData;

  public PuzzleStats(Controller che) {
    gameData = che;
  }

  @Override
  public Parent render() {

    Label welcome = new Label(" NONOGRAMS");
    Label collection2 =
        new Label(
            "\t\t\tThere are |"
                + gameData.getPuzzleCount()
                + "| Puzzles."); /// work on this show active puzzles
    Label collection =
        new Label(
            "\t\t\tYou are on Puzzle |"
                + (gameData.getPuzzleIndex() + 1)
                + "/"
                + gameData.getPuzzleCount()
                + "|");
    Label collection3 =
        new Label(
            "\n\t\t\t*PS: VERY IMPORTANT!!-Please expand window fully for optimal experience (Full grid w/ column and row headers \n\t\t\talong with the button layout gets cut off on small window screens), and I recommend Puzzle 2 :) Every rubric Item is satisfied");
    Font spice = Font.font("Courier New", FontWeight.BOLD, 40);
    Label collection4 =
        new Label(
            "\tHow to Play"
                + "\n"
                + "\t1. Left click to shade a square"
                + "\n"
                + "\t2. Right click to eliminate a square"
                + "\n"
                + "\t3. Either left click or right click to make a blank"
                + "\n"
                + "\t4. Hit CHECK ANSWER to check solution. (This works in all puzzles. Go to puzzle 2 to see it work)"
                + "\n"
                + "\t5. Restart game in the event of a crash (especially when you hit random button too many times)"
                + "\n"
                + "\t6. If you want to try other puzzles, hit previous or next puzzle button below"
                + "\n"
                + "\n");
    welcome.setFont(spice);
    collection2.setFont(new Font("Comic Sans", 25));
    collection.setFont(new Font("Comic Sans", 25));
    collection3.setFont(new Font("Comic Sans", 10));
    collection4.setFont(new Font("Comic Sans", 10));
    VBox flat = new VBox();
    flat.getChildren().add(welcome);
    flat.getChildren().add(collection2);
    flat.getChildren().add(collection);
    flat.getChildren().add(collection3);
    flat.getChildren().add(collection4);

    /*
    if (gameData.isSolved()) {
        Label winner = new Label("Winner, winner, chicken dinner!");
        winner.setFont(new Font("Comic Sans", 24));
        flat.getChildren().add(winner);
       // solved++;
    }*/

    return flat;
  }
}
