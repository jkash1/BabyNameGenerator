import java.util.ArrayList;
import java.util.HashMap;


public class MarkovModel {

    HashMap<String, int[]> numOfOccurrences = new HashMap<>();
    HashMap<String, double[]> probabilities = new HashMap<>();



    public void Model(ArrayList<String> names, int order){
        String front = "";
        String nextLetter = "";
        //loop through the names
        for(String name : names){

            //loop through the letters of each name
            for(int i = 0; i < name.length(); i++){

            }
            front = name.substring(0, order);
            nextLetter = name.substring(order, order + 1);



        }
    }

}
