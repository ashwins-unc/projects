package com.comp301.a09nonograms.model;

import java.util.ArrayList;

public class CluesImpl implements Clues {

  private final int[][] _rowClues;
  private final int[][] _colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    // Constructor code here
    if (rowClues == null || colClues == null) {
      throw new IllegalArgumentException();
    }
    _rowClues = rowClues;
    _colClues = colClues;
  }

  @Override
  public int[] getRowClues(int index) {
    ArrayList<Integer> _r_o_w_cluearray = new ArrayList<>();
    for (int q = 0; q <= _rowClues.length; q++) {
      if (q == index) {
        for (int w = 0; w < _rowClues[q].length; w++) {
          _r_o_w_cluearray.add(_rowClues[q][w]);
        }
      }
    }
    int[] rowClues = new int[_r_o_w_cluearray.size()];
    for (int e = 0; e < _r_o_w_cluearray.size(); e++) {
      rowClues[e] = _r_o_w_cluearray.get(e);
    }
    return rowClues;
  }

  @Override
  public int getWidth() {
    return _colClues.length;
  } // +1

  @Override
  public int getColCluesLength() {
    return _colClues[0].length;
  }

  @Override
  public int[] getColClues(int index) {
    ArrayList<Integer> Colcluearray = new ArrayList<>();
    for (int q = 0; q <= _colClues.length; q++) {
      if (q == index) {
        for (int w = 0; w < _colClues[q].length; w++) {
          Colcluearray.add(_colClues[q][w]);
        }
      }
    }
    int[] colClues = new int[Colcluearray.size()];
    for (int e = 0; e < Colcluearray.size(); e++) {
      colClues[e] = Colcluearray.get(e);
    }
    return colClues; // return col[index];
  }

  @Override
  public int getHeight() {
    return _rowClues.length;
  } // +1

  @Override
  public int getRowCluesLength() {
    return _rowClues[0].length;
  }
}
