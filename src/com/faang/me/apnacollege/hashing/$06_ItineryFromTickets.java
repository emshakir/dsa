package com.apna_college.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Mohammad Shakir - 28/02/2023
 */
public class $06_ItineryFromTickets {

  public static String getStart(Map<String, String> tickets) {
    Map<String, String> revMap = new HashMap<>();
    for (String key : tickets.keySet()) {
      revMap.put(tickets.get(key), key);
    }

    for (String key : tickets.keySet()) {
      if (!revMap.containsKey(key)) {
        return key;
      }
    }
    return null;

  }

  public static void showStations(Map<String, String> tickets) {
    String start = getStart(tickets);
    System.out.print(start);
    for (String key : tickets.keySet()) {
      System.out.print(" -> " + tickets.get(start));
      start = tickets.get(start);
    }
  }

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("Chennai", "Bangalore");
    map.put("Bombay", "Delhi");
    map.put("Delhi", "Goa");
    map.put("Goa", "Chennai");
    showStations(map);
  }
}
