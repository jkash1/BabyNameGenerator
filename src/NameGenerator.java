import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NameGenerator {


    private static ArrayList<String> boysNames = new ArrayList<>();
    private static ArrayList<String> girlsNames = new ArrayList<>();

    /**
     * This class is used to generate the formatted arrays for both boys and girls names.
     * The names are set by the call of the unparamatized constructor.
     */
    public NameGenerator(int order){
        setNames(order);
    }

    /**
     * This method takes in the 2 text files reads them adds the pre and post "_"
     * to be used in the markovModel and then adds that name to its respective gender
     * ArrayList.
     */
    public static void setNames(int order){
        String name;
        String orderStart = new String(new char[order]).replace("\0", "_");
        try {
            File namesBoys = new File("src/namesBoys.txt");
            File namesGirls = new File("src/namesGirls.txt");
            FileReader fileReaderBoys = new FileReader(namesBoys);
            FileReader fileReaderGirls = new FileReader(namesGirls);
            BufferedReader bufferedReaderBoys = new BufferedReader(fileReaderBoys);
            BufferedReader bufferedReaderGirls = new BufferedReader(fileReaderGirls);

            while((name = bufferedReaderBoys.readLine()) != null){
                name = orderStart + name + "_";
                boysNames.add(name);
            }

            while((name = bufferedReaderGirls.readLine()) != null){
                name = orderStart + name + "_";
                girlsNames.add(name);
            }
            bufferedReaderBoys.close();
            bufferedReaderGirls.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("ERROR");
        }

    }

    //Getter for ArrayList of boys names
    public ArrayList<String> getBoysNames(){
        return boysNames;
    }

    //Getter for ArrayList of girls names
    public ArrayList<String> getGirlsNames(){
        return girlsNames;
    }



}
