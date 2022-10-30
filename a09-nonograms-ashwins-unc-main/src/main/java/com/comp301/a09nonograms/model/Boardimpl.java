package com.comp301.a09nonograms.model;

public class Boardimpl implements Board {

  private final Clues _clue;
  private final int[][] boradcoord;

  public Boardimpl(Clues clue) {
    if (clue == null) {
      throw new IllegalArgumentException();
    }
    _clue = clue;
    boradcoord = new int[_clue.getHeight()][_clue.getWidth()];
    clear();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (col > _clue.getWidth() || row > _clue.getHeight() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    if (isEliminated(row, col)) {
      boradcoord[row][col] = 0;
    } else {
      boradcoord[row][col] = 2;
    }
  }

  @Override
  public void clear() {
    for (int[] row : boradcoord) {
      for (int i = 0; i < row.length; i++) {
        row[i] = 0;
      }
    }
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (col > _clue.getWidth() || row > _clue.getHeight() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    return boradcoord[row][col] == 2;
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (col > _clue.getWidth() || row > _clue.getHeight() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    return boradcoord[row][col] == 0;
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (col > _clue.getWidth() || row > _clue.getHeight() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    if (isShaded(row, col)) {
      boradcoord[row][col] = 0;
    } else {
      boradcoord[row][col] = 1;
    }
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (col > _clue.getWidth() || row > _clue.getHeight() || row < 0 || col < 0) {
      throw new RuntimeException();
    }
    return boradcoord[row][col] == 1;
  }
}
