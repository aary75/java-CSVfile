package com.bridgelabz.javaCSVfileReading.intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args){
        try(CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))){
            String[] header = {"ID" ,"Name" ,"Marks"};

            String[] em1 = {"101", "Aaryan" , "95"};
            String[] em2 = {"102", "Hitesh" , "96"};
            String[] em3 = {"103", "Yash" , "90"};
            String[] em4 = {"104", "Harman" , "95"};
            String[] em5 = {"105", "Smile" , "75"};

            writer.writeNext(header);
            writer.writeNext(em1);
            writer.writeNext(em2);
            writer.writeNext(em3);
            writer.writeNext(em4);
            writer.writeNext(em5);

        } catch(IOException e){
            e.printStackTrace();
        }

        try(CSVReader reader = new CSVReader(new FileReader("output.csv"))){
             String[] nextLine;
             boolean isHeader = true;

             while((nextLine = reader.readNext()) != null){
                 if(isHeader){
                     isHeader = false;
                     continue;
                 }

                 if(Integer.parseInt(nextLine[2]) > 80){
                     System.out.println("ID: " + nextLine[0] + ", Name:" + nextLine[1] + ", Marks:" + nextLine[2]);
                 }
             }
        }
        catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}

//ID: 101, Name:Aaryan, Marks:95
//ID: 102, Name:Hitesh, Marks:96
//ID: 103, Name:Yash, Marks:90
//ID: 104, Name:Harman, Marks:95
