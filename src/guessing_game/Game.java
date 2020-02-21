package guessing_game;


import com.sun.jdi.ArrayReference;

import java.util.*;
import java.io.*;
import java.util.List;


public class Game {
    /*
     *
     *       VARIABLES
     *
     * */

    private static String FILE_PATH = "cities.txt";
    private static List<String> cities = new ArrayList<String>();
    private static List<Character> guessedCity = new ArrayList<Character>();
    private static List<Character> usedLetters = new ArrayList<Character>();


    public Game() {
        this.guessedCity= new ArrayList<Character>();
   }
    /*
    *
    *
    *       METHODS
    *
    * */
    public void newGame(){
        createCities();
        randomCity();
        System.out.println(guessedCity);
        System.out.println(underscoreCity());

    }



    public static void randomCity() {
        Random random = new Random();
        String city = cities.get(random.nextInt(cities.size()));
        for(char letter : city.toCharArray()){
            guessedCity.add(letter);
        }
    }

    public static String underscoreCity() {
        String a = "";
        for (int i = 0; i < guessedCity.size(); i++) {
            a += "_ ";
        }
        return a;
    }

    public static void createCities () {
        File file = new File(FILE_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String city = "";
            while ((city = br.readLine()) != null) {
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading: " + FILE_PATH);
        }
    }
}
