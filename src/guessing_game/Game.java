package guessing_game;


import java.util.List;
import java.util.Random;
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
    private static String guessedCity;


    /**
     * Method
     *
     * @param cities
     * @return
     */
    public static void randomCity(List<String> cities) {
        Random random = new Random();
        guessedCity = cities.get(random.nextInt(cities.size()));
    }

    public static String underscoreCity() {
        String a = "";
        for (int i = 0; i < guessedCity.length(); i++) {
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
