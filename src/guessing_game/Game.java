package guessing_game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    /*
    *
    *       VARIABLES
    *
    * */

    private static String FILE_PATH = "cities.txt";
    private static List<String> cities = new ArrayList<String>();
    private String guessedCity;

    /*
    *
    *       CONSTRUCTOR
    *
    * */

    public Game(String city) {
        this.guessedCity = city;
    }



    /*
    *
    *       METHODS
    *
    * */


    public static void createCities(){
        File file = new File(FILE_PATH);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String city = "";
            while((city = br.readLine()) != null){
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading: "+FILE_PATH);
        }
    }
}
