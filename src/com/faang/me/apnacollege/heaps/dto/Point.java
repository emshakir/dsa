package com.faang.me.apnacollege.heaps.dto;

/**
 * Created By Mohammad Shakir - 11/02/2023
 */
public class Point implements Comparable<Point> {

  private int distance;
  private int position;

  public Point(int distance, int position) {
    this.distance = distance;
    this.position = position;
  }

  public void setDistancec(int distance) {
    this.distance = distance;
  }

  public int getDistance() {
    return this.distance;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  @Override
  public int compareTo(Point p1) {
    return this.distance - p1.distance;
  }
}
