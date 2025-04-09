package com.bridgelabz.javaCSVfileReading.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailRegex {
    public static final String FileName = "output.csv";
    public static void main(String[]  args){
        writeCSV();
        readCSV();
    }

    public static void writeCSV(){
        try(CSVWriter writer = new CSVWriter(new FileWriter(FileName))){
            String[] header = {"Email", "PhoneNo."};

            String[] info1 = {"aaryan@gmail.com","6841298745"};
            String[] info2 = {"harman@gmail.com", "7855145527"};
            String[] info3 = {"hitesh@.com", "6445175228"};
            String[] info4 = {"yash@gmail.com", "4578964"};

            writer.writeNext(header);
            writer.writeNext(info1);
            writer.writeNext(info2);
            writer.writeNext(info3);
            writer.writeNext(info4);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readCSV(){
        try(CSVReader reader = new CSVReader(new FileReader(FileName))){
            String[] nextLine;
            boolean isHeader = true;
            String emailRegex = "[A-Za-z0-9&%$#@]+@[A-Za-z]+\\.[A-Za-z]{2,}";
            String phoneRegex = "[0-9]{10}";

            while((nextLine = reader.readNext()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(nextLine[0]);

                Pattern phonePattern = Pattern.compile(phoneRegex);
                Matcher phoneMatcher = phonePattern.matcher(nextLine[1]);

                if(!matcher.find() || !phoneMatcher.find()){
                    System.out.print(nextLine[0] + " " + nextLine[1] + " ");
                    System.out.println("This is an invalid row");
                }
            }
        } catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}

//hitesh@.com 6445175228 This is an invalid row
//yash@gmail.com 4578964 This is an invalid row