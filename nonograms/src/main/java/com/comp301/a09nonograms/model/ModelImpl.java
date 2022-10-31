package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelImpl implements Model {

  private final List<Clues> _clues;
  private final ArrayList<ModelObserver> listobs;
  private final List<Board> games;
  private int act;
  private Board noAct;

  public ModelImpl(List<Clues> clues) {
    // Constructor code here
    _clues = clues;
    act = -1;
    listobs = new ArrayList<>();
    noAct = null;
    games = new ArrayList<>();
    setPuzzleIndex(0);
  }

  @Override
  public Clues getClues() {
    return _clues.get(act);
  }

  @Override
  public ArrayList<ModelObserver> getObservers() {
    return listobs;
  }

  @Override
  public int getPuzzleCount() {
    return _clues.size();
  }

  @Override
  public int getPuzzleIndex() {
    return act;
  }

  @Override
  public void setPuzzleIndex(int index) {
    if (act != -1) {
      games.add(noAct);
    }
    act = index;
    Clues pk = _clues.get(index);
    noAct = new Boardimpl(pk);
    signal();
  }

  private void signal() {
    for (ModelObserver alert : listobs) {
      alert.update(this);
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    listobs.add(observer);
  }

  private int counted(int[] rowCol) {
    int count = 0;
    for (int num : rowCol) {
      count += num;
    }
    return count;
  }

  @Override
  public boolean isSpace(int row, int col) {
    return noAct.isSpace(row, col);
  }

  @Override
  public boolean isSolved() {
    int[][] _row_board_slot = new int[getHeight()][getRowCluesLength()];
    int[][] _col_board_slot = new int[getWidth()][getColCluesLength()];

    for (int a = getHeight() - 1; a >= 0; a--) {
      boolean _false = false;
      int x = getRowCluesLength() - 1;
      for (int b = getWidth() - 1; b >= 0; b--) {
        if (isShaded(a, b)) {
          _row_board_slot[a][x]++;
          _false = true;
        } else if (x != 0 && _false) {
          x--;
          _false = false;
        }
      }
    }

    for (int a = getWidth() - 1; a >= 0; a--) {
      boolean _false = false;
      int x = getColCluesLength() - 1;
      for (int b = getHeight() - 1; b >= 0; b--) {
        if (isShaded(b, a)) {
          _col_board_slot[a][x]++;
          _false = true;
        } else if (x != 0 && _false) {
          x--;
          _false = false;
        }
      }
    }
    for (int i = 0; i < getHeight(); i++) {
      if (!Arrays.equals(_row_board_slot[i], getRowClues(i))) {
        return false;
      }
    }

    for (int i = 0; i < getWidth(); i++) {
      if (!Arrays.equals(_col_board_slot[i], getColClues(i))) {
        return false;
      }
    }
    /*for (int i = 0; i < getHeight(); i++) {
      int shaded = 0;

        }
      }
      if (shaded != counted(getRowClues(i))) {

    }*/
    return true;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return noAct.isShaded(row, col);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    listobs.remove(observer);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    noAct.toggleCellShaded(row, col);
    signal();
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return noAct.isEliminated(row, col);
  }

  @Override
  public int getColCluesLength() {
    return _clues.get(act).getColCluesLength();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    noAct.toggleCellEliminated(row, col);
    signal();
  }

  @Override
  public int[] getColClues(int index) {
    return _clues.get(act).getColClues(index);
  }

  @Override
  public void clear() {
    noAct.clear();
    signal();
  }

  @Override
  public int getHeight() {
    return _clues.get(act).getHeight();
  }

  @Override
  public int getRowCluesLength() {
    return _clues.get(act).getRowCluesLength();
  }

  @Override
  public int getWidth() {
    return _clues.get(act).getWidth();
  }

  @Override
  public int[] getRowClues(int index) {
    return _clues.get(act).getRowClues(index);
  }
}
