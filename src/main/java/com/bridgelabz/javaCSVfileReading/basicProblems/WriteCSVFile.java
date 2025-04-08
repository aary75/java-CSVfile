package com.bridgelabz.javaCSVfileReading.basicProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    public static void main(String[] args){
        try(CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))) {
            String[] header = {"ID", "Name", "Department", "Salary"};

            String[] em1 = {"101", "Aaryan", "CSE", "100000"};
            String[] em2 = {"102", "Hitesh", "BCA", "95000"};
            String[] em3 = {"103", "Yash", "CA", "180000"};
            String[] em4 = {"104", "Harman", "CSE", "100000"};
            String[] em5 = {"105", "Mohit", "CSE AI", "90000"};

            writer.writeNext(header);
            writer.writeNext(em1);
            writer.writeNext(em2);
            writer.writeNext(em3);
            writer.writeNext(em4);
            writer.writeNext(em5);

        } catch (IOException e){
            e.printStackTrace();
        }


        try(CSVReader reader = new CSVReader(new FileReader("output.csv"))){
            String[] nextLine;

            while((nextLine = reader.readNext()) != null){
                System.out.println("ID: " + nextLine[0] + ",Name:"+ nextLine[1] + ",Department:" + nextLine[2] + ",Salary:" + nextLine[3]);
            }
        } catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }

    }
}

//ID: ID,Name:Name,Department:Department,Salary:Salary
//ID: 101,Name:Aaryan,Department:CSE,Salary:100000
//ID: 102,Name:Hitesh,Department:BCA,Salary:95000
//ID: 103,Name:Yash,Department:CA,Salary:180000
//ID: 104,Name:Harman,Department:CSE,Salary:100000
//ID: 105,Name:Mohit,Department:CSE AI,Salary:90000
