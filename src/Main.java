import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static int genderTrigger;
    private static int minLength;
    private static int maxLength;
    private static int markovOrder;
    private static int numNames;

    private static ArrayList<String> tempBoys = new ArrayList<>();
    private static ArrayList<String> tempGirls = new ArrayList<>();
    private static ArrayList<String> finalBoys = new ArrayList<>();
    private static ArrayList<String> finalGirls = new ArrayList<>();

    public static void main(String[] args){
        System.out.println("======================================");
        System.out.println("Welcome to the Baby Name Generator");
        System.out.println("Created by, James Kash");
        System.out.println("=======================================\n");
        //testing code
        /*
              UI for choosing either Male of female names
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to generate Male or Female Names?");
        String gender = sc.nextLine();
        while(!gender.equals("Male") || !gender.equals("male") || !gender.equals("Female") || !gender.equals("female")) {
            if (gender.equals("Male") || gender.equals("male")) {
                genderTrigger = 0;
                break;
            } else if (gender.equals("Female") || gender.equals("female")) {
                genderTrigger = 1;
                break;
            } else {
                System.out.println("Please Enter Male or Female");
                gender = sc.nextLine();
            }
        }
        /*
            UI for entering the minimum length of the name
         */
        System.out.println("Please enter the minimum length of the name.");
        minLength = sc.nextInt();
        while(minLength < 0){
            System.out.println("Please enter a length above 0!");
            minLength = sc.nextInt();
        }
        /*
             UI for entering the maximum length of the name
         */
        System.out.println("Please enter the maximum length of the name.");
        maxLength = sc.nextInt();
        while(maxLength < 1 || maxLength <= minLength){
            System.out.println("Please enter a value higher than the minimum length!");
            maxLength = sc.nextInt();
        }
        /*
            UI for entering the order of the Markov Model
         */
        System.out.println("Please enter the order of the model");
        markovOrder = sc.nextInt();
        System.out.println("Please enter the number of Names");
        numNames = sc.nextInt();

        NameGenerator nameGenerator = new NameGenerator(markovOrder);
        tempBoys = nameGenerator.getBoysNames();
        tempGirls = nameGenerator.getGirlsNames();

        MarkovModel markov = new MarkovModel();
        if(genderTrigger == 0){
            System.out.println("Generating Male Names.....");
            markov.Model(tempBoys, markovOrder);
            finalBoys = markov.probabilityModel(markovOrder, minLength, maxLength, numNames);
            for(String name : finalBoys){
                System.out.println(name);
            }
        }else if(genderTrigger == 1){
            System.out.println("Generating Female Names.....");
            markov.Model(tempGirls, markovOrder);
            finalGirls = markov.probabilityModel(markovOrder, minLength, maxLength, numNames);
            for(String name: finalGirls){
                System.out.println(name);
            }
        }else{
            System.out.println("Error");
        }
    }
}
