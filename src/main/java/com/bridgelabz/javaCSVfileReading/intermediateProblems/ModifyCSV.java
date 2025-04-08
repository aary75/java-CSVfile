package com.bridgelabz.javaCSVfileReading.intermediateProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class ModifyCSV {
    public static final String File_Name = "output.csv";

    public static void main(String[] args){
        writeCSV();
        readCSV();
    }

    public static void writeCSV(){
        try(CSVWriter writer = new CSVWriter(new FileWriter("output.csv"))){
            String[] header = {"Name","Department","Salary"};

            String[] em1 = {"Aaryan","IT","50000"};
            String[] em2 = {"Hitesh","IT","80000"};
            String[] em3 = {"Yash","Sales","75000"};

            writer.writeNext(header);

            writer.writeNext(em1);
            writer.writeNext(em2);
            writer.writeNext(em3);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(File_Name))) {

            String[] nextLine;
            boolean isHeader = true;

            while ((nextLine = reader.readNext()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (nextLine[1].equals("IT")) {
                    int salary = Integer.parseInt(nextLine[2]);
                    double newSalary = salary + (salary * (0.1));
                    nextLine[2] = String.valueOf(newSalary);
                }

                System.out.println("Name: " + nextLine[0] + ", Department: " + nextLine[1] + ", Salary: " + nextLine[2]);
            }

        } catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }

    }
}

//Name: Aaryan, Department: IT, Salary: 55000.0
//Name: Hitesh, Department: IT, Salary: 88000.0
//Name: Yash, Department: Sales, Salary: 75000