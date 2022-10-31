package com.comp301.a09nonograms;

import static org.junit.Assert.assertTrue;


import com.comp301.a09nonograms.model.Clues;
import org.junit.Test;
import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Board;
import com.comp301.a09nonograms.model.Boardimpl;

import com.comp301.a09nonograms.model.CluesImpl;
import java.util.ArrayList;
import java.util.List;

/** Unit test for simple App. */
public class AppTest {
  /** Rigorous Test :-) */
  @Test
  public void shouldAnswerWithTrue() {
    assertTrue(true);
  }

  @Test
  public void cluesImpltest() {
    ArrayList<Clues> clues = new ArrayList<Clues>();
    int[][] row1 =
        new int[][] {
          new int[] {0, 0},
          new int[] {0, 4},
          new int[] {0, 6},
          new int[] {2, 2},
          new int[] {2, 2},
          new int[] {0, 6},
          new int[] {0, 4},
          new int[] {0, 2},
          new int[] {0, 2},
          new int[] {0, 2},
          new int[] {0, 0},
        };
    int[][] col1 =
        new int[][] {
          new int[] {0, 0},
          new int[] {0, 9},
          new int[] {0, 9},
          new int[] {2, 2},
          new int[] {2, 2},
          new int[] {0, 4},
          new int[] {0, 4},
          new int[] {0, 0},
        };
    Clues example = new CluesImpl(row1, col1);
    ArrayList<Clues> oneclues = new ArrayList<Clues>();
    oneclues.add(example);
    Boardimpl exboard = new Boardimpl(oneclues.get(0)) {};
    System.out.println("wuxi");
    System.out.println("isSpace> :" + exboard.isSpace(0, 0));
    System.out.println("isSpace> :" + exboard.isSpace(0, 1));
    System.out.println("isSpace> :" + exboard.isSpace(0, 2));
    System.out.println("isSpace> :" + exboard.isSpace(0, 3));
    System.out.println("isSpace> :" + exboard.isSpace(0, 4));
    System.out.println("isSpace> :" + exboard.isSpace(1, 3));
    System.out.println("isShaded false> :" + exboard.isShaded(0, 0));
    exboard.toggleCellShaded(0, 0);
    System.out.println(exboard.isShaded(0,0));
    exboard.toggleCellShaded(0, 1);
    System.out.println(exboard.isShaded(0,1));
    System.out.println(exboard.isShaded(0,2));
    System.out.println(exboard.isShaded(0,3));
    System.out.println(exboard.isShaded(0,4));
    System.out.println(exboard.isEliminated(0,4));
  }
}
