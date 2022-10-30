package com.comp301.a09nonograms.controller;

import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelObserver;

public class ControllerImpl implements Controller {

  private final Model nonogramapp;

  public ControllerImpl(Model model) {
    // Constructor code goes here
    nonogramapp = model;
  }

  @Override
  public Clues getClues() {
    return nonogramapp.getClues();
  }

  @Override
  public void toggleShaded(int row, int col) {
    nonogramapp.toggleCellShaded(row, col);
  }

  @Override
  public boolean isShaded(int row, int col) {
    return nonogramapp.isShaded(row, col);
  }

  @Override
  public boolean isSolved() {
    return nonogramapp.isSolved();
  }

  @Override
  public void toggleEliminated(int row, int col) {
    nonogramapp.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    nonogramapp.clear();
    try {
      nonogramapp.setPuzzleIndex(nonogramapp.getPuzzleIndex() + 1);
    } catch (IndexOutOfBoundsException e) {
      nonogramapp.setPuzzleIndex(0);
    }
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return nonogramapp.isEliminated(row, col);
  }

  @Override
  public void randPuzzle() {
    nonogramapp.clear();
    int min = 0;
    int max = nonogramapp.getPuzzleCount() - 1;
    int random = ((int) Math.floor(Math.random() * (max - min + 1) + min));
    int current=nonogramapp.getPuzzleIndex();
    if (random==current){
      random=random+1;
    }
    nonogramapp.setPuzzleIndex(random);
  }

  @Override
  public void prevPuzzle() {
    nonogramapp.clear();
    try {
      nonogramapp.setPuzzleIndex(nonogramapp.getPuzzleIndex() - 1);
    } catch (IndexOutOfBoundsException e) {
      nonogramapp.setPuzzleIndex(nonogramapp.getPuzzleCount() - 1);
    }
  }

  @Override
  public int getPuzzleIndex() {
    return nonogramapp.getPuzzleIndex();
  }

  public void update(Model model) {
    for (ModelObserver item : model.getObservers()) {
      item.notify();
    }
  }

  @Override
  public int getPuzzleCount() {
    return nonogramapp.getPuzzleCount();
  }

  @Override
  public void clearBoard() {
    nonogramapp.clear();
  }
}
