package com.apna_college.heaps.dto;

/**
 * Created By Mohammad Shakir - 12/02/2023
 */
public class Row implements Comparable<Row> {

  private int soldiers;
  private int index;

  public Row(int soldiers, int index) {
    this.soldiers = soldiers;
    this.index = index;
  }

  public int getSoldiers() {
    return soldiers;
  }

  public void setSoldiers(int soldiers) {
    this.soldiers = soldiers;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  @Override
  public int compareTo(Row r2) {
    if (this.soldiers == r2.soldiers) {
      return this.index - r2.index;
    } else {
      return this.soldiers - r2.soldiers;
    }
  }
}
