package com.apna_college.heaps.dto;

/**
 * Created By Mohammad Shakir - 12/02/2023
 */
public class MaxSumPair implements Comparable<MaxSumPair> {

  public int val;
  public int idx;

  public MaxSumPair(int val, int idx) {
    this.val = val;
    this.idx = idx;
  }


  @Override
  public int compareTo(MaxSumPair p2) {
    return p2.val - this.val;
  }
}
