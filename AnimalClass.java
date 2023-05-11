import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnimalClass{
        private int age;
        private String gender;
        private String species;
        private String birthSeason;
        private String animalName;
        private String color;
        private int weight;
        private String origin;
        private String birthdate;
        private String getDay;
        private String uniqueID;
        
        public AnimalClass(int age, String gender, String species, String birthSeason, String color, int weight, String origin){
            this.age = age;
            this.gender = gender;
            this.species = species;
            this.birthSeason = birthSeason;
            this.color = color;
            this.weight = weight;
            this.origin = origin;
        }
        
        @Override
        public String toString(){
            return uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthdate + "; " + color + "; " + gender + "; " + weight + " pounds; " + origin + "; arrived " + getDay;
        }
        public int getAge(){
            return age;
        }
        public String getGender(){
            return gender;
        }
        public String getSpecies(){
            return species;
        }
        public String getBirthSeason(){
            return birthSeason;
        }
        public String getAnimalName(){
            return animalName;
        }
        public String getColor(){
            return color;
        }
        public int getWeight(){
            return weight;
        }
        public String getOrigin(){
            return origin;
        }
        public String getBirthdate(){
            return birthdate;
        }
        public String getGetDay(){
            return getDay;
        }
        public String getID(){
            return uniqueID;
        }
        public void setAge(int age){
            this.age = age;
        }
        public void setGender(String gender){
            this.gender = gender;
        }
        public void setSpecies(String species){
            this.species = species;
        }
        public void setBirthSeason(String birthSeason){
            this.birthSeason = birthSeason;
        }
        public void setName(String name){
            this.animalName = name;
        }
        public void setColor(String color){
            this.color = color;
        }
        public void setWeight(int weight){
            this.weight = weight;
        }
        public void setOrigin(String origin){
            this.origin = origin;
        }
        public void setBirthdate(String birthdate){
            this.birthdate = birthdate;
        }
        public void setGetDay(String getDay){
            this.getDay = getDay;
        }
        public void setID(String ID){
            this.uniqueID = ID;
        }
        public String genBirthDay(int age, String birthSeason){
            Random random = new Random();
            int birthYear = 2023 - age;
            int birthMonth = 0;
            int birthDay = 0;
            
            if(birthSeason.equals("spring")){
                birthMonth = 3 + random.nextInt(3);
                birthDay = 1 + random.nextInt(30);
            }else if(birthSeason.equals("summer")){
                birthMonth = 5 + random.nextInt(3);
                birthDay = 1 + random.nextInt(30);
            }else if(birthSeason.equals("spring")){
                birthMonth = 8 + random.nextInt(3);
                birthDay = 1 + random.nextInt(30);
            }else if(birthSeason.equals("spring")){
                birthMonth = 11 + random.nextInt(2);
                birthDay = 1 + random.nextInt(30);
            }else{
                birthMonth = random.nextInt(12) + 1;
                birthDay = random.nextInt(30) + 1;
            }
        
            if(birthMonth == 2 && (birthDay == 29 || birthDay == 30)){
                birthDay = 28;
            }
            
            LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
            return birthdate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        }
        public String genGetDay(){
            LocalDate getDate = java.time.LocalDate.now();
            return getDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        }
        public String genID(String species, int counter){
            return species.substring(0,2) + "0" + counter;
        }
        public String genName(String[] names){
            Random random = new Random();
            return names[random.nextInt(names.length)];
        }
    }