package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
* The AnalyticsCounter class provides functionality to analyze and count symptoms data.
*/

public class AnalyticsCounter {
  ISymptomReader reader;
  ISymptomWriter writer;

  /**
   * Constructs an AnalyticsCounter object with the specified reader and writer.
   *
   *@param reader The ISymptomReader implementation used to read symptom data.
   *@param writer The ISymptomWriter implementation used to write analyzed data.
   */  
  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;

  }

  /**
  *Retrieves the list of syptoms from the reader.
  *@return the list of symptoms.
  */
  public List<String> getSymptoms() {
    return this.reader.getSymptoms();
  }

  /**
  *Counts the occurences of symptoms and returns a map of symptom - frequency pairs.
  *@param symptoms The list of symptoms to count.
  *@return A map containing symptoms as keys and their corresponding frequences as values.
  */

  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String,Integer> mapSymptoms = new HashMap<>();
    for (String symptom : symptoms) {
      if (mapSymptoms.containsKey(symptom)) {
        mapSymptoms.put(symptom, mapSymptoms.get(symptom) + 1);
      } else {
        mapSymptoms.put(symptom, 1);
      }
    }
    return mapSymptoms;
  }      

  /**
  * Sorts the symptoms in alphabetical order and returns a TreeMap.
  *
  *@param symptoms The map of symptoms to sort.
  *@return A TreeMap containing the symptoms sorted in alphabetical order.
  */

  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();
    sortedSymptoms.putAll(symptoms);
    return sortedSymptoms;
    
  }


  /** Writes the symptoms and their frequences using the writer.
  *
  *@param symptoms the map of symptoms and their frequences to write.
  */

  public void writeSymptoms(Map<String, Integer> symptoms) {
    this.writer.writeSymptoms(symptoms);
  }

}