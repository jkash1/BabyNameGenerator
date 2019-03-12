import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class MarkovModel {

    HashMap<String, String> letters = new HashMap<>();
    public void Model(ArrayList<String> names, int order){
        String front;
        String nextLetter;
        //loop through the names
        for(String name : names){
            //loop through the letters of each name
            for(int i = order; i < name.length(); i++){ //sets i to the order
                int firstLetter = i - order; //Will initially start at index 0
                front = name.substring(firstLetter, i);
                nextLetter = name.substring(i, i+1);

                if(letters.containsKey(front)){
                    String value = letters.get(front);
                    value = value + nextLetter;
                    letters.put(front, value);
                }else{
                    letters.put(front, nextLetter);
                }
            }
        }
    }

    public ArrayList<String> probabilityModel(int order, int min, int max, int numNames){
        ArrayList<String> newNames = new ArrayList<>();

        int len = 0;
        while(len != numNames){
            String newNameKey = "_";
            for(int i = 0; i < order - 1;i++){
                newNameKey = "_" + newNameKey;
            }
            String nameValue = letters.get(newNameKey);
            Random random = new Random();
            int randInt = random.nextInt(nameValue.length());
            newNameKey = newNameKey + nameValue.substring(randInt, randInt+1);
            while(!(newNameKey.substring(newNameKey.length() - 1)).equals("_")){
                String latestNameValue = letters.get(newNameKey.substring(newNameKey.length() - order));
                int randInt2 = random.nextInt(latestNameValue.length());
                newNameKey = newNameKey + latestNameValue.substring(randInt2, randInt2 + 1);
            }
            String newName = newNameKey.replace("_", "");
            if(!newNames.contains(newName) && newName.length() > min && newName.length() < max){
                newNames.add(newName);
                len++;
            }
        }
        return newNames;
    }

}
