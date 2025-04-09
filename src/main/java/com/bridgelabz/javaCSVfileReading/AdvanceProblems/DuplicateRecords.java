package com.bridgelabz.javaCSVfileReading.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateRecords {
    public  static final String outputFile = "output.csv";

    public static void main(String[] args){
        writeFirstCSV();
        readCSV();
    }

    public static void writeFirstCSV(){
        try(CSVWriter writer = new CSVWriter(new FileWriter(outputFile))){
            String[] header = {"ID","Grade","Marks"};

            String[] em1 = {"101","A-","98"};
            String[] em2 = {"102","B+","87"};
            String[] em3 = {"101","A-", "53"};
            String[] em4 = {"102","B-","42"};
            String[] em5 = {"103","C+","35"};

            writer.writeNext(header);
            writer.writeNext(em1);
            writer.writeNext(em2);
            writer.writeNext(em3);
            writer.writeNext(em4);
            writer.writeNext(em5);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readCSV(){
        try(CSVReader reader = new CSVReader(new FileReader(outputFile))){
            String[] nextLine;
            boolean isHeader = true;
           List<String> list = new ArrayList<>();

            while((nextLine = reader.readNext()) != null){
                if(isHeader) {
                    isHeader = false;
                    continue;
                }

                if(list.contains(nextLine[0])){
                    System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2]);
                }
                else{
                    list.add(nextLine[0]);
                }
            }
        } catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }

}

//101 A- 53
//102 B- 42