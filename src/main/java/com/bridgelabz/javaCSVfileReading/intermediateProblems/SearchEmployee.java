package com.bridgelabz.javaCSVfileReading.intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;

public class SearchEmployee {
    public static final String File_name = "output.csv";

    public static void main(String[] args) {
        writeCSV();
    }


    public static void writeCSV() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
             String[] header = {"Name", "Department", "Salary"};

             String[] em1 = {"Aaryan", "IT", "50000"};
             String[] em2 = {"Hitesh", "IT", "80000"};
             String[] em3 = {"Yash", "Sales", "80000"};
             String[] em4 = {"Harman", "Product", "90000"};

             writer.writeNext(header);
             writer.writeNext(em1);
             writer.writeNext(em2);
             writer.writeNext(em3);
             writer.writeNext(em4);
        } catch(IOException e){
            e.printStackTrace();
        }

        try(CSVReader reader = new CSVReader(new FileReader(File_name))){
            boolean isHeader = true;
            String[] nextLine;

            while((nextLine = reader.readNext())!= null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                if(nextLine[0].equals("Aaryan")){
                    System.out.println("Name: " + nextLine[0] + ", Department: " + nextLine[1] + ", Salary:" + nextLine[2]);
                }
            }
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }

}