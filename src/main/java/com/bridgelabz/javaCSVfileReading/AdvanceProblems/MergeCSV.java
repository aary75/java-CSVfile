package com.bridgelabz.javaCSVfileReading.AdvanceProblems;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MergeCSV {
    public static final String firstFile = "first.csv";
    public static final String secondFile = "second.csv";
    public  static final String outputFile = "output.csv";

    public static void main(String[] args){
        writeFirstCSV();
        writeSecondCSV();
        mergeCSV();
    }

    public static void writeFirstCSV(){
        try(CSVWriter writer = new CSVWriter(new FileWriter(firstFile))){
            String[] header = {"ID","Grade","Marks"};

            String[] em1 = {"101","A-","98"};
            String[] em2 = {"102","B+","87"};

            writer.writeNext(header);
            writer.writeNext(em1);
            writer.writeNext(em2);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeSecondCSV(){
        try(CSVWriter writer = new CSVWriter(new FileWriter(secondFile))){
            String[] header = {"ID","Name","Age"};

            String[] em1 = {"101","Aaryan","21"};
            String[] em2 = {"102","Hitesh","22"};

            writer.writeNext(header);
            writer.writeNext(em1);
            writer.writeNext(em2);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void mergeCSV(){
        try(CSVReader readerGrades = new CSVReader(new FileReader(firstFile));
        CSVReader readerStudents = new CSVReader(new FileReader(secondFile));
        CSVWriter writerData = new CSVWriter(new FileWriter(outputFile))){

            Map<String, List<String>> map = new HashMap<>();

            String[] skipGradeHeader = readerGrades.readNext();
            String[] readGrade;

            while((readGrade = readerGrades.readNext()) != null){
                String[] otherThanId = Arrays.copyOfRange(readGrade,1,readGrade.length);
                map.put(readGrade[0], Arrays.asList(otherThanId));
            }

            String[] skipStudentHeader = readerStudents.readNext();
            String[] studentGrade;

            while((studentGrade = readerStudents.readNext()) != null){
            List<String> mergedList = new ArrayList<>(Arrays.asList(studentGrade));
            List<String> grade = map.get(studentGrade[0]);

            for(int i =0; i<grade.size();i++){
                mergedList.add(grade.get(i));
            }
            writerData.writeNext(mergedList.toArray(new String[0]));
            }
        }
        catch(IOException | CsvValidationException e){
            e.printStackTrace();
        }

        try(CSVReader reader1 = new CSVReader(new FileReader(outputFile))){
            String[] nextLine;

            while((nextLine = reader1.readNext()) != null){
                System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2] + " " + nextLine[3] + " " + nextLine[4]);
            }
        }
        catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
    }
}

//101 Aaryan 21 A- 98
//102 Hitesh 22 B+ 87
