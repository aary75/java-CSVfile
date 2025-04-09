package com.bridgelabz.javaCSVfileReading.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecordsFromDatabase {
    public  static final String outputFile = "src/main/java/com/bridgelabz/javaCSVfileReading/basicProblems/Data.csv";

    public static void main(String[] args){
        readCSV();
    }

    public static void readCSV(){
        try(CSVReader reader = new CSVReader(new FileReader(outputFile))){
            String[] nextLine;
            boolean isHeader = true;

            while((nextLine = reader.readNext()) != null){
                if(isHeader) {
                    isHeader = false;
                    continue;
                }

                System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2] + " " + nextLine[3]);

            }
        } catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }

}

//101 Aaryan 21 95
//102 Hitesh 22 96
//103 Yash 22 95