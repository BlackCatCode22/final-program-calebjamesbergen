/*
Here is my final program
This is the link to the video of it: https://www.youtube.com/watch?v=r1vg4hKgciU
The program reads the input file line by line and divides the lines up into variables containing certain information
An animal object is then created with that information and put into a linked list for the specific habitat it belongs to
At the end, the contents of the linked list are written into the output file zooPopulation.txt
*/

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Write a description of class Final here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Final
{
    String[] hyenaNames = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou", "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
    String[] lionNames = {"Scar", "Mufasa", "Simba", "Kiara", "King", "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
    String[] bearNames = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle", "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};
    String[] tigerNames = {"Tony", "Tigger", "Amber", "Cosimia", "Cuddles", "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};
    
    LinkedList<AnimalClass> hyenaHabitat = new LinkedList<>();
    LinkedList<AnimalClass> lionHabitat = new LinkedList<>();
    LinkedList<AnimalClass> tigerHabitat = new LinkedList<>();
    LinkedList<AnimalClass> bearHabitat = new LinkedList<>();
    
    int hyenaCounter = 1;
    int lionCounter = 1;
    int bearCounter = 1;
    int tigerCounter = 1;
    
    
    public Final () throws IOException
    {
        File inputFile = new File("arrivingAnimals.txt");
        Scanner scanner = new Scanner(inputFile);
        
        FileWriter writer = new FileWriter("zooPopulation.txt");
        writer.write("Final Program Output; by Caleb Bergen, Spring 2023, Fresno, CA\n\n");
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] data = line.split(", ");
            String[] ageData = data[0].split(" ");
            
            int age = Integer.parseInt(ageData[0]);
            String sex = ageData[3];
            String species = ageData[4];
            String birthSeason = "unknown";
            String animalName = "";
            if (ageData.length == 6) {
                birthSeason = ageData[5];
            }
            String color = data[2];
            int weight = Integer.parseInt(data[3].split(" ")[0]);
            String origin = data[4] + ", " + data[5];
            
            AnimalClass temp = new AnimalClass(age, sex, species, birthSeason, color, weight, origin);
            
            switch(species){
                case "hyena":
                    temp.setName(temp.genName(hyenaNames));
                    hyenaHabitat.add(temp);
                    temp.setID(temp.genID(temp.getSpecies(), hyenaCounter));
                    hyenaCounter++;
                    break;
                case "lion":
                    temp.setName(temp.genName(lionNames));
                    lionHabitat.add(temp);
                    temp.setID(temp.genID(temp.getSpecies(), lionCounter));
                    lionCounter++;
                    break;
                case "bear":
                    temp.setName(temp.genName(bearNames));
                    bearHabitat.add(temp);
                    temp.setID(temp.genID(temp.getSpecies(), bearCounter));
                    bearCounter++;
                    break;
                case "tiger":
                    temp.setName(temp.genName(tigerNames));
                    tigerHabitat.add(temp);
                    temp.setID(temp.genID(temp.getSpecies(), tigerCounter));
                    tigerCounter++;
                    break;
            }
            temp.setBirthdate(temp.genBirthDay(age, birthSeason));
            temp.setGetDay(temp.genGetDay());
        }
        writer.write("\n\nHyena Habitat:\n\n");
        for(AnimalClass animal : hyenaHabitat){
            writer.write(animal.toString() + "\n");
        }
        writer.write("\n\nLion Habitat:\n\n");
        for(AnimalClass animal : lionHabitat){
            writer.write(animal.toString() + "\n");
        }
        writer.write("\n\nBear Habitat:\n\n");
        for(AnimalClass animal : bearHabitat){
            writer.write(animal.toString() + "\n");
        }
        writer.write("\n\nTiger Habitat:\n\n");
        for(AnimalClass animal : tigerHabitat){
            writer.write(animal.toString() + "\n");
        }
        writer.close();
    }
}
