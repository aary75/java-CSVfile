package com.bridgelabz.javaCSVfileReading.basicProblems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
    public static void main(String[] args){
        String filePath = "src/main/java/com/bridgelabz/javaCSVfileReading/basicProblems/Data.csv";

        int count = 0;
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            boolean isHeader = true;
            while((line = br.readLine()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }

                count++;
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Total number of records:" + count);
    }
}
