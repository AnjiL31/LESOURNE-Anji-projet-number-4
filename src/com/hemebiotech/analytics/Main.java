package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/** The Main class is the entry point for the analytics application.
*It performs symptom analysis and writes the results to a file.
*/

public class Main {
  /** The Main method that executes the analytics application.
  *@param args The comman line arguments.
  
  */

  public static void main(String[]args) {
    // Created an instance of ISymptomReader to read symptom data from file
    ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

    // Created an instance of ISymptomWriter to write the data to the file
    ISymptomWriter writer = new WriteSymptomDataToFile();

    //Created an instance of AnalyticsCounter with specified reader and writer
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader,writer);

    //Retreived the list of symptoms from the reader
    List<String> symptoms = analyticsCounter.getSymptoms();

    //Counting the occurences of symptoms
    Map<String, Integer> countedSymptoms = analyticsCounter.countSymptoms(symptoms);

    //Sorted the symptoms in alphabetical order
    Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(countedSymptoms);

    //Wrote sorted symptoms and their frequency to a file
    analyticsCounter.writeSymptoms(sortedSymptoms);

  }
}

