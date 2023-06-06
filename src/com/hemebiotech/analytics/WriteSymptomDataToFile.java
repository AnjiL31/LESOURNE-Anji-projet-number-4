package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;




/**
*The WriteSymptomDataToFile  class implements the ISymptomWriter interface.
*providing functionality to writing symptoms to a file.

*/

public class WriteSymptomDataToFile implements ISymptomWriter { 
  /** Writes symptoms and how often they occur to a file.
  *@param symptoms is a map containing symtoms and their occurences.
  */

  public void writeSymptoms(Map<String, Integer> symptoms) {
    try {
      File finalFile = new File("result.out"); // Création du fichier.
      FileWriter writer = new FileWriter(finalFile); //Object created to write in FinalFile.
      TreeMap<String, Integer> sortedSymptoms = new TreeMap<>();
      sortedSymptoms.putAll(symptoms);
      Set<String> listOfSymptoms = symptoms.keySet();
      
      for (String symptomName : listOfSymptoms) { // Pour chaque symptom dans la liste des symptom.
        writer.write(symptomName + " : " + symptoms.get(symptomName) + "\n");// Write in File.
      }
      writer.close();
    } catch (IOException totoEx) {
      System.out.println(totoEx.getMessage());
    }
   
  }
}




  
