package com.bridgelabz.javaCSVfileReading.intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SortBySalary {
    public static final String FileName = "output.csv";

    public static void main(String[] args){
        writeCSV();
        readCSV();
    }

    public static void writeCSV(){
        try(CSVWriter writer = new CSVWriter(new FileWriter(FileName))){
            String[] header = {"Name","Salary"};

            String[] em1 = {"Aaryan","100000"};
            String[] em2 = {"Hitesh","50000"};
            String[] em3 = {"Aman", "70000"};
            String[] em4 = {"Yash", "80000"};
            String[] em5 = {"Harman", "75000"};

            writer.writeNext(header);
            writer.writeNext(em1);
            writer.writeNext(em2);
            writer.writeNext(em3);
            writer.writeNext(em4);
            writer.writeNext(em5);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readCSV(){
        try(CSVReader reader = new CSVReader(new FileReader(FileName))){
            String[] nextLine;
            boolean isHeader = true;

            List<String[]> rows = reader.readAll();
            reader.close();

            String[] header = rows.remove(0);
            rows.sort((a,b) ->{
                double salaryA = Double.parseDouble(a[1]);
                double salaryB = Double.parseDouble(b[1]);

                return Double.compare(salaryB, salaryA);
            });


            System.out.println(header[0] + ", " + header[1]);

            for(int i = 0;i<5;i++){
                System.out.println(String.join(",",rows.get(i)));
            }

        }catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}


