package com.bridgelabz.javaCSVfileReading.basicProblems;

import java.io.*;

public class ReadCSV {
       public static void main(String[] args){
           String filePath = "src/main/java/com/bridgelabz/javaCSVfileReading/Data.csv";

//           try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
//               writer.write("Id, Name, Age, Marks\n");
//               writer.write("104, Aaryan, 21, 95");
//               writer.write("105, Hitesh, 21, 96");
//               writer.write("106, Yash, 22, 95");
//           }
//           catch(IOException e) {
//               e.printStackTrace();
//           }

//           try(CSVReader reader = new CSVReader(new FileReader("output.csv"))){
//                 String[] nextLine;
//
//                 while((nextLine = reader.readNext()) != null){
//                     System.out.println(nextLine[0] + " " + nextLine[1] + " " + nextLine[2] + " " + nextLine[3]);
//               }
//           }
//           catch (Exception e){
//               e.printStackTrace();
//           }
           String line;
           try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
                   boolean isHeader = true;
               while((line = br.readLine()) != null){
                   if(isHeader){
                       isHeader = false;
                       continue;
                   }

                   String[] data = line.split(",");
                   int id = Integer.parseInt(data[0].trim());
                   String name = data[1].trim();
                   int age = Integer.parseInt(data[2].trim());
                   int marks = Integer.parseInt(data[3].trim());

                   System.out.print("ID: " + id);
                   System.out.print(", Name: " + name);
                   System.out.print(", Age: " + age);
                   System.out.println(", Marks: " + marks);

               }
           }
           catch(IOException e){
               System.out.println(e.getMessage());
           }
       }
}
//
//ID: 101, Name: Aaryan, Age: 21, Marks: 95
//ID: 102, Name: Hitesh, Age: 22, Marks: 96
//ID: 103, Name: Yash, Age: 22, Marks: 95
