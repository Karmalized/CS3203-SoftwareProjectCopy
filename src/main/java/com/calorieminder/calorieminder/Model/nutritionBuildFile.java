package com.calorieminder.calorieminder.Model;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class nutritionBuildFile {
    public static int lineData; //line vitamin selection data
    public static int informationData; //data with information from some food that needs to be filled

    public nutritionBuildFile(){ //nutrition file constructor
        lineData = 0;
        informationData = 0;
    }

    private void systemPrompt(){
        Scanner takeInput = new Scanner(System.in);
    System.out.println("1. Vitamin A\n");
    System.out.println("2. Vitamin B1\n");
    System.out.println("3. Vitamin B2\n");
    System.out.println("4. Vitamin B3\n");
    System.out.println("5. Vitamin B4\n");
    System.out.println("6. Vitamin B5\n");
    System.out.println("7. Vitamin B6\n");
    System.out.println("8. Vitamin B7\n");
    System.out.println("9. Vitamin B9\n");
    System.out.println("10. Vitamin B12\n");
    System.out.println("11. Vitamin C\n");
    System.out.println("12. Vitamin D\n");
    System.out.println("13. Vitamin E\n");
    System.out.println("14. Vitamin K\n");
    System.out.println("15. Calcium\n");
    System.out.println("16. Phosphorus\n");
    System.out.println("17. Magnesium\n");
    System.out.println("18. Iron\n");
    System.out.println("19. Zinc\n");
    System.out.println("20. Copper\n");
    System.out.println("21. Potassium\n");
    System.out.println("22. Sodium\n");
    System.out.println("23. Chloride\n"); //list of vitamins
    System.out.print("Select a number corresponding to desired nutrient to input: "); //select a nutrient number to manipulate, more changes will be added later
    lineData = takeInput.nextInt(); //takes the input given by the system/user
    while(lineData >= 23 || lineData <= 0){ //if the input isn't within the column values, re-prompt until column selected
        System.out.println("not a valid selection! Enter valid nutrient number!\n");
        System.out.print("Select a number corresponding to desired nutrient to input: ");
        lineData = takeInput.nextInt();
    }
    System.out.print("Enter data to append: "); //enter data to append to the section
    informationData = takeInput.nextInt(); //takes the data input for the selected nutrient
    while(informationData <= 0){ //if the number is unreasonable, re-prompt
        System.out.println("not a valid selection! Enter valid nutrient data amount!\n");
        System.out.print("Enter data to append: ");
        informationData = takeInput.nextInt();
    }
    takeInput.close(); //close the input selector
    }

    public void writeNewFile(File f) throws IOException{ //new file generation
        FileWriter write = new FileWriter(f);
    write.write("1. Vitamin A: \n");
    write.write("2. Vitamin B1: \n");
    write.write("3. Vitamin B2: \n");
    write.write("4. Vitamin B3: \n");
    write.write("5. Vitamin B4: \n");
    write.write("6. Vitamin B5: \n");
    write.write("7. Vitamin B6: \n");
    write.write("8. Vitamin B7: \n");
    write.write("9. Vitamin B9: \n");
    write.write("10. Vitamin B12: \n");
    write.write("11. Vitamin C: \n");
    write.write("12. Vitamin D: \n");
    write.write("13. Vitamin E: \n");
    write.write("14. Vitamin K: \n");
    write.write("15. Calcium: \n");
    write.write("16. Phosphorus: \n");
    write.write("17. Magnesium: \n");
    write.write("18. Iron: \n");
    write.write("19. Zinc: \n");
    write.write("20. Copper: \n");
    write.write("21. Potassium: \n");
    write.write("22. Sodium: \n");
    write.write("23. Chloride: \n");
        write.close();
    }

    public static void appendToRow(int lData, int infData, File f){ //implements the given changes from the system into the NutrientFile
        try{
        Scanner readFile = new Scanner(f);
        ArrayList<String> lines = new ArrayList<>();
        String line;

        while(readFile.hasNextLine()){ //if the file has lines, scan and add them into the arraylist
            lines.add(readFile.nextLine());
        }

        readFile.close();
        int nutrientInfoNumber; //Nutrient Data being manipulated

        if (lData > 0 && lData <= lines.size()) { // Append newData to the existing row data
            line = lines.get(lData-1);
            Scanner lineParser = new Scanner(line);
            String[] sections = line.split(":");
            String infoData = sections[sections.length-1].trim();
            if(infoData.matches("[0-9]+")){
                int nutrientNumber = Integer.parseInt(infoData);
                nutrientInfoNumber = nutrientNumber + infData;
            } else {
                nutrientInfoNumber = infData;
            }
            String newData = sections[0] + ": " + nutrientInfoNumber;
            lines.remove(lData-1);
            lines.add(lData-1, newData);
            lineParser.close();
        } else {
            System.out.println("Invalid Row Number!"); //if there's an issue with the number selection then throw this line
        }
        // Write modified lines back to the file
        FileWriter writeOut = new FileWriter(f);
        for(String fileLines : lines){
            writeOut.write(fileLines);
            writeOut.write("\n");
        }
        lines.clear();
        writeOut.close();
        System.out.println("changes successful!");

        }catch(Exception e){
            System.out.println("uh oh...Issue!! :P"); //handles the IOExceptions if they occur
        }
    }
    public static void main(String[] args){
        nutritionBuildFile newFile = new nutritionBuildFile(); //creates new nutrition build file
        newFile.systemPrompt(); //System prompts to select nutrition and added values to nutrition
        File f = new File("nutrientData.txt"); //the file stored locally on the system containing the data of nutrients recorded
        try{
            if(f.exists() && f.length() != 0){ //if the file exists and isn't empty
                appendToRow(lineData, informationData,f); //append more data into the existing file
            } else {
                newFile.writeNewFile(f); //otherwise create a new file of nutrients
                appendToRow(lineData, informationData,f); //and add in the inputted data into the new file
            }
        } catch(Exception e){ //if there's a file issue, flag is right here
            System.out.println("file Error!");
        }
    }
}
