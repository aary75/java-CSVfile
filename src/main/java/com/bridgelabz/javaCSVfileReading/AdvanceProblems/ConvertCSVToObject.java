package com.bridgelabz.javaCSVfileReading.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student{
    int id;
    String name;
    String department;
    double grade;

    public Student(int id, String name, String department, double grade){
        this.id = id;
        this.name = name;
        this.department = department;
        this.grade = grade;
    }
}

public class ConvertCSVToObject {
    public static final String fileName = "output.csv";

    public static void main(String[] args){
        writeCSV();
        readCSV();
    }

    public static void writeCSV(){
        try(CSVWriter writer = new CSVWriter(new FileWriter(fileName))){
            String[] header = {"ID","Name","Department","Grade"};

            String[] st1 = {"101","Aaryan","IT","9.8"};
            String[] st2 = {"102","Harman","IT","9.5"};
            String[] st3 = {"103","Yash","Sales","9.0"};
            String[] st4 = {"104","Hitesh","Development","9.7"};

            writer.writeNext(header);
            writer.writeNext(st1);
            writer.writeNext(st2);
            writer.writeNext(st3);
            writer.writeNext(st4);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readCSV(){
        List<Student> list = new ArrayList<Student>();
        try(CSVReader reader = new CSVReader(new FileReader(fileName))){
            String[] nextLine;
            boolean isHeader = true;

            while((nextLine = reader.readNext()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String department = nextLine[2];
                double grade = Double.parseDouble(nextLine[3]);

                Student student = new Student(id, name, department, grade);
                list.add(student);
            }

            for(int i=0;i<list.size();i++){
                System.out.println("ID:" + list.get(i).id);
                System.out.println("Name:" + list.get(i).name);
                System.out.println("Department:" + list.get(i).department);
                System.out.println("Grade:" + list.get(i).grade);
                System.out.println();
            }
        }
     catch(IOException | CsvValidationException e){
        e.printStackTrace();
    }
}}

//ID:101
//Name:Aaryan
//Department:IT
//Grade:9.8
//
//ID:102
//Name:Harman
//Department:IT
//Grade:9.5
//
//ID:103
//Name:Yash
//Department:Sales
//Grade:9.0
//
//ID:104
//Name:Hitesh
//Department:Development
//Grade:9.7

